package dev.adelantecodes.astfps.client.render;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.renderpearl.api.buffers.GpuBuffer;
import com.mojang.renderpearl.api.buffers.GpuBufferSlice;
import com.mojang.renderpearl.api.commands.RenderPass;
import com.mojang.renderpearl.api.pipeline.IndexType;
import com.mojang.renderpearl.api.pipeline.PrimitiveTopology;
import dev.adelantecodes.astfps.client.AstFPSRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.function.BiConsumer;
import net.minecraft.client.renderer.DynamicGpuData;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.client.renderer.chunk.ChunkSectionsToRender;
import net.minecraft.client.renderer.chunk.SectionRenderDispatcher;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Util;
import org.joml.Matrix4fc;

/** Original CPU terrain submission stage; vanilla still owns meshing, shaders and GPU lifetimes. */
public final class AstFPSTerrainBatcher {
    private static final ChunkSectionLayer[] LAYERS = ChunkSectionLayer.values();
    private AstFPSTerrainBatcher() { }

    /** Captures only an immutable integer. The caller supplies the current frame's GPU slices. */
    private record SectionUniform(int infoIndex) implements BiConsumer<GpuBufferSlice[], RenderPass.UniformUploader> {
        @Override public void accept(GpuBufferSlice[] buffers, RenderPass.UniformUploader uploader) {
            uploader.setUniform("ChunkSection", buffers[infoIndex]);
        }
    }

    private static final class Batch {
        GpuBuffer vertex;
        GpuBuffer index;
        IndexType indexType;
        final ArrayList<DynamicGpuData.IndexedDraw> commands = new ArrayList<>();
        final List<DynamicGpuData.IndexedDraw> reverseCommands = commands.reversed();
        Batch nextWithSameVertex;
        int cursor;
        long allocated;
        long reused;
        int commandHighWater;
        void reset(GpuBuffer vertex, GpuBuffer index, IndexType indexType) {
            this.vertex = vertex; this.index = index; this.indexType = indexType;
            nextWithSameVertex = null;
            cursor = 0; allocated = 0; reused = 0;
        }
        boolean matches(GpuBuffer vertex, GpuBuffer index, IndexType type) {
            return this.vertex == vertex && this.index == index && this.indexType == type;
        }
        void add(int indexCount, int firstIndex, int baseVertex, int infoIndex) {
            DynamicGpuData.IndexedDraw previous = cursor < commands.size() ? commands.get(cursor) : null;
            if (previous != null && previous.indexCount() == indexCount && previous.instanceCount() == 1
                    && previous.firstIndex() == firstIndex && previous.baseVertex() == baseVertex && previous.baseInstance() == infoIndex) {
                reused++;
            } else {
                var command = new DynamicGpuData.IndexedDraw(indexCount, 1, firstIndex, baseVertex, infoIndex);
                if (previous == null) commands.add(command); else commands.set(cursor, command);
                allocated++;
            }
            cursor++;
            commandHighWater = Math.max(commandHighWater, commands.size());
        }
        void seal() { if (cursor < commands.size()) commands.subList(cursor, commands.size()).clear(); }
    }

    private static final class LayerBatches {
        final ArrayList<Batch> ordered = new ArrayList<>();
        IdentityHashMap<GpuBuffer, Batch> byVertex = new IdentityHashMap<>();
        final ArrayList<Batch> pool = new ArrayList<>();
        Batch last;
        int used;
        Batch acquire(GpuBuffer vertex, GpuBuffer index, IndexType type) {
            Batch batch;
            if (used < pool.size()) batch = pool.get(used);
            else { batch = new Batch(); pool.add(batch); }
            used++; batch.reset(vertex, index, type); return batch;
        }
        Batch find(GpuBuffer vertex, GpuBuffer index, IndexType type, boolean orderedTransparency) {
            // Consecutive sections often share an arena. This avoids a map lookup/chain walk while
            // still checking this frame's complete GPU key. For transparency only adjacency merges.
            if (last != null && last.matches(vertex, index, type)) return last;
            if (orderedTransparency) {
                Batch batch = acquire(vertex, index, type);
                ordered.add(batch); last = batch; return batch;
            }
            Batch head = byVertex.get(vertex);
            for (Batch candidate = head; candidate != null; candidate = candidate.nextWithSameVertex) {
                if (candidate.matches(vertex, index, type)) { last = candidate; return candidate; }
            }
            Batch batch = acquire(vertex, index, type);
            batch.nextWithSameVertex = head;
            byVertex.put(vertex, batch); ordered.add(batch); last = batch; return batch;
        }
    }

    /** Renderer-owned CPU scratch; retained commands contain integers, never GPU resources. */
    public static final class Workspace {
        private static final int RETAINED_COMMAND_BUDGET = 16_384;
        private static final int RETAINED_BATCHES_PER_LAYER = 32;
        private final Thread owner = Thread.currentThread();
        private final EnumMap<ChunkSectionLayer, LayerBatches> layers = new EnumMap<>(ChunkSectionLayer.class);
        private final ArrayList<DynamicGpuData.ChunkSectionInfo> infos = new ArrayList<>();
        private final ArrayList<SectionUniform> sectionUniforms = new ArrayList<>();
        private long uniformCallbacksAllocated;
        private long uniformCallbacksReused;
        private DynamicGpuData.ChunkSectionInfo[] directSectionInfos;
        // Nearby visible-section counts can oscillate while moving. Keep up to four exact
        // lengths, with the same total reference-slot budget as the previous single array.
        private final DynamicGpuData.ChunkSectionInfo[][] directInfoArrays =
                new DynamicGpuData.ChunkSectionInfo[4][];
        private int directArraySlots;
        private int nextDirectArraySlot;
        private final ArrayList<List<DynamicGpuData.IndexedDraw>> commandGroups = new ArrayList<>();
        private final ArrayList<Batch> submissionOrder = new ArrayList<>();
        private final int[] strides = new int[LAYERS.length];
        private int infoCursor;
        private long infosAllocated;
        private long infosReused;
        private boolean busy;
        public Workspace() { for (var layer : LAYERS) layers.put(layer, new LayerBatches()); }
        public long uniformCallbacksAllocated() { return uniformCallbacksAllocated; }
        public long uniformCallbacksReused() { return uniformCallbacksReused; }
        private SectionUniform sectionUniform(int infoIndex) {
            if (infoIndex < 0) throw new IllegalArgumentException("Negative section info index");
            // Bound retained callbacks independently of transient render distance spikes.
            if (infoIndex >= RETAINED_COMMAND_BUDGET) {
                uniformCallbacksAllocated++;
                return new SectionUniform(infoIndex);
            }
            int previousSize = sectionUniforms.size();
            while (sectionUniforms.size() <= infoIndex) {
                sectionUniforms.add(new SectionUniform(sectionUniforms.size()));
                uniformCallbacksAllocated++;
            }
            if (infoIndex < previousSize) uniformCallbacksReused++;
            return sectionUniforms.get(infoIndex);
        }
        private void begin() {
            if (Thread.currentThread() != owner || busy) throw new IllegalStateException("Terrain workspace ownership/reentrancy violation");
            busy = true;
            infoCursor = 0; infosAllocated = 0; infosReused = 0;
            for (var layer : LAYERS) layers.get(layer).used = 0;
        }
        private int addInfo(BlockPos origin, float visibility) {
            int index = infoCursor++;
            DynamicGpuData.ChunkSectionInfo previous = index < infos.size() ? infos.get(index) : null;
            // The record is immutable and contains only primitive coordinates/fade, no section/world/GPU object.
            // Compare raw float bits so signed zero and NaN payloads are never silently changed.
            if (previous != null && previous.x() == origin.getX() && previous.y() == origin.getY()
                    && previous.z() == origin.getZ()
                    && Float.floatToRawIntBits(previous.visibility()) == Float.floatToRawIntBits(visibility)) {
                infosReused++;
            } else {
                var info = new DynamicGpuData.ChunkSectionInfo(origin.getX(), origin.getY(), origin.getZ(), visibility);
                if (previous == null) infos.add(info); else infos.set(index, info);
                infosAllocated++;
            }
            return index;
        }
        private void sealInfos() {
            if (infoCursor < infos.size()) infos.subList(infoCursor, infos.size()).clear();
        }
        private DynamicGpuData.ChunkSectionInfo[] directSectionInfos() {
            int count = infos.size();
            // The engine serializes every array entry synchronously, so the array must have exact length.
            // Only this CPU scratch array is reused; returned GPU slices remain engine-owned.
            if (directSectionInfos == null || directSectionInfos.length != count) {
                directSectionInfos = null;
                for (var candidate : directInfoArrays) {
                    if (candidate != null && candidate.length == count) {
                        directSectionInfos = candidate;
                        break;
                    }
                }
                if (directSectionInfos == null) {
                    directSectionInfos = new DynamicGpuData.ChunkSectionInfo[count];
                    if (count <= RETAINED_COMMAND_BUDGET) {
                        // Round-robin eviction is bounded to four entries. Every candidate was
                        // cleared by finish() before another frame can borrow the workspace.
                        do {
                            var evicted = directInfoArrays[nextDirectArraySlot];
                            if (evicted != null) directArraySlots -= evicted.length;
                            directInfoArrays[nextDirectArraySlot] = null;
                            if (directArraySlots + count <= RETAINED_COMMAND_BUDGET) break;
                            nextDirectArraySlot = (nextDirectArraySlot + 1) % directInfoArrays.length;
                        } while (true);
                        directInfoArrays[nextDirectArraySlot] = directSectionInfos;
                        directArraySlots += count;
                        nextDirectArraySlot = (nextDirectArraySlot + 1) % directInfoArrays.length;
                    }
                }
            }
            return infos.toArray(directSectionInfos);
        }
        private void finish() {
            if (directSectionInfos != null) {
                Arrays.fill(directSectionInfos, null);
                if (directSectionInfos.length > RETAINED_COMMAND_BUDGET) directSectionInfos = null;
            }
            int remaining = RETAINED_COMMAND_BUDGET;
            int retainInfos = Math.min(infoCursor, RETAINED_COMMAND_BUDGET);
            if (retainInfos < infos.size()) infos.subList(retainInfos, infos.size()).clear();
            if (infosCapacityExceeded) infos.trimToSize();
            infosCapacityExceeded = false;
            boolean largeGroupLists = submissionOrder.size() > 128;
            commandGroups.clear(); submissionOrder.clear();
            if (largeGroupLists) { commandGroups.trimToSize(); submissionOrder.trimToSize(); }
            for (var layer : LAYERS) {
                var state = layers.get(layer);
                boolean largeOrderedList = state.ordered.size() > 128;
                state.ordered.clear();
                state.last = null;
                if (largeOrderedList) state.ordered.trimToSize();
                if (state.byVertex.size() > 128) state.byVertex = new IdentityHashMap<>();
                else state.byVertex.clear();
                int retain = Math.min(state.pool.size(), RETAINED_BATCHES_PER_LAYER);
                for (int i = 0; i < state.pool.size(); i++) {
                    Batch batch = state.pool.get(i);
                    batch.vertex = null; batch.index = null; batch.indexType = null;
                    batch.nextWithSameVertex = null;
                    int count = batch.commands.size();
                    if (i >= retain || count > remaining || i >= state.used) {
                        batch.commands.clear(); batch.commands.trimToSize();
                        batch.commandHighWater = 0;
                    } else {
                        remaining -= count;
                        if (batch.commandHighWater > Math.max(64, count * 2)) {
                            batch.commands.trimToSize(); batch.commandHighWater = count;
                        }
                    }
                }
                if (retain < state.pool.size()) {
                    state.pool.subList(retain, state.pool.size()).clear(); state.pool.trimToSize();
                }
            }
            busy = false;
        }
        private boolean infosCapacityExceeded;
    }

    public static ChunkSectionsToRender prepare(Workspace workspace, boolean indirect, SectionRenderDispatcher dispatcher,
            List<SectionRenderDispatcher.RenderSection> visible, Matrix4fc matrix,
            boolean orderedTransparency, double fadeSeconds, int atlasWidth, int atlasHeight) {
        workspace.begin();
        try {
            return prepareOwned(workspace, indirect, dispatcher, visible, matrix, orderedTransparency, fadeSeconds, atlasWidth, atlasHeight);
        } finally { workspace.finish(); }
    }

    private static ChunkSectionsToRender prepareOwned(Workspace workspace, boolean indirect, SectionRenderDispatcher dispatcher,
            List<SectionRenderDispatcher.RenderSection> visible, Matrix4fc matrix,
            boolean orderedTransparency, double fadeSeconds, int atlasWidth, int atlasHeight) {
        var layers = workspace.layers;
        int[] strides = workspace.strides;
        for (ChunkSectionLayer layer : LAYERS) {
            strides[layer.ordinal()] = layer.pipeline(false).getVertexFormatBinding(0).getVertexSize();
        }
        var infos = workspace.infos;
        infos.ensureCapacity(visible.size());
        workspace.infosCapacityExceeded = visible.size() > Workspace.RETAINED_COMMAND_BUDGET;
        int largestSequentialIndexCount = 0;
        long drawCount = 0;
        long now = Util.getMillis();
        long fadeMillis = Util.toMillis(fadeSeconds);
        if (dispatcher != null) {
            dispatcher.lock();
            try {
                for (int s = 0; s < visible.size(); s++) {
                    var section = visible.get(s);
                    var mesh = section.getSectionMesh();
                    int infoIndex = -1;
                    for (ChunkSectionLayer layer : LAYERS) {
                        var draw = mesh.getSectionDraw(layer);
                        // Empty layers require no dispatcher lookup, batch key or GPU command.
                        if (draw == null) continue;
                        var slice = dispatcher.getRenderSectionSlice(mesh, layer);
                        if (slice == null || (draw.hasCustomIndexBuffer() && slice.indexBuffer() == null)) continue;
                        int indexCount = draw.indexCount();
                        int stride = strides[layer.ordinal()];
                        long vertexOffset = slice.vertexBufferOffset();
                        if (indexCount < 0 || stride <= 0 || vertexOffset < 0 || vertexOffset % stride != 0
                                || slice.vertexBuffer() == null || vertexOffset > slice.vertexBuffer().size()) {
                            throw new IllegalStateException("Invalid terrain vertex slice or draw count");
                        }
                        IndexType type = draw.hasCustomIndexBuffer() ? draw.indexType() : null;
                        long indexOffset = slice.indexBufferOffset();
                        if (draw.hasCustomIndexBuffer() && (type == null || type.bytes <= 0 || indexOffset < 0
                                || indexOffset % type.bytes != 0 || indexOffset > slice.indexBuffer().size()
                                || (long) indexCount * type.bytes > slice.indexBuffer().size() - indexOffset)) {
                            throw new IllegalStateException("Invalid terrain index slice");
                        }
                        // Validate all conversions before any GPU writer is called, allowing preparation fallback.
                        int firstIndex = type == null ? 0 : Math.toIntExact(indexOffset / type.bytes);
                        int baseVertex = Math.toIntExact(vertexOffset / stride);
                        if (infoIndex < 0) {
                            BlockPos origin = section.getRenderOrigin();
                            infoIndex = workspace.addInfo(origin, section.getVisibility(now, fadeMillis));
                        }
                        GpuBuffer index = draw.hasCustomIndexBuffer() ? slice.indexBuffer() : null;
                        if (type == null) largestSequentialIndexCount = Math.max(largestSequentialIndexCount, indexCount);
                        Batch batch = layers.get(layer).find(slice.vertexBuffer(), index, type, orderedTransparency && layer.translucent());
                        batch.add(indexCount, firstIndex, baseVertex, infoIndex);
                        drawCount++;
                    }
                }
            } finally {
                dispatcher.unlock();
            }
        }

        // GPU writers still serialize every current frame. Never send retained, unused record tails.
        workspace.sealInfos();
        AstFPSRuntime.terrainSectionInfosAllocated += workspace.infosAllocated;
        AstFPSRuntime.terrainSectionInfosReused += workspace.infosReused;
        var commandGroups = workspace.commandGroups;
        var submissionOrder = workspace.submissionOrder;
        for (ChunkSectionLayer layer : LAYERS) {
            List<Batch> batches = layers.get(layer).ordered;
            boolean reversed = layer.translucent() && orderedTransparency;
            for (int i = 0; i < batches.size(); i++) {
                Batch batch = batches.get(reversed ? batches.size() - 1 - i : i);
                batch.seal();
                submissionOrder.add(batch);
                commandGroups.add(reversed ? batch.reverseCommands : batch.commands);
                AstFPSRuntime.terrainCommandRecordsAllocated += batch.allocated;
                AstFPSRuntime.terrainCommandRecordsReused += batch.reused;
            }
        }
        var gpu = RenderSystem.getDynamicUniforms();
        if (!indirect) {
            EnumMap<ChunkSectionLayer, List<RenderPass.Draw<GpuBufferSlice[]>>> directDraws = new EnumMap<>(ChunkSectionLayer.class);
            int group = 0;
            for (ChunkSectionLayer layer : LAYERS) {
                int batchCount = layers.get(layer).ordered.size();
                int layerDrawCount = 0;
                for (int b = 0; b < batchCount; b++) {
                    layerDrawCount = Math.addExact(layerDrawCount, submissionOrder.get(group + b).commands.size());
                }
                // These lists escape into DrawSeparate; allocate a fresh, exact-sized list each frame.
                // The empty immutable list is safe to share and carries no frame resources.
                List<RenderPass.Draw<GpuBufferSlice[]>> list = layerDrawCount == 0
                    ? List.of() : new ArrayList<>(layerDrawCount);
                directDraws.put(layer, list);
                for (int b = 0; b < batchCount; b++) {
                    Batch batch = submissionOrder.get(group);
                    for (var command : commandGroups.get(group++)) {
                        final int infoIndex = command.baseInstance();
                        list.add(new RenderPass.Draw<>(0, batch.vertex, batch.index, batch.indexType,
                            command.firstIndex(), command.indexCount(), command.baseVertex(),
                            workspace.sectionUniform(infoIndex)));
                    }
                }
            }
            var terrain = gpu.writeTerrainTransform(matrix, atlasWidth, atlasHeight);
            var sectionData = gpu.writeChunkSections(workspace.directSectionInfos());
            if (largestSequentialIndexCount > 0) RenderSystem.getSequentialBuffer(PrimitiveTopology.QUADS).requestIndexCount(largestSequentialIndexCount);
            AstFPSRuntime.terrainBatchFrames++;
            AstFPSRuntime.terrainDirectFrames++;
            AstFPSRuntime.terrainSectionDraws += drawCount;
            return new ChunkSectionsToRender.DrawSeparate(terrain, directDraws, largestSequentialIndexCount, sectionData);
        }
        GpuBufferSlice[] commands = gpu.writeChunkSectionCommands(commandGroups);
        EnumMap<ChunkSectionLayer, List<ChunkSectionsToRender.GpuMultiDrawIndexedIndirect>> draws = new EnumMap<>(ChunkSectionLayer.class);
        int commandIndex = 0;
        for (ChunkSectionLayer layer : LAYERS) {
            int batchCount = layers.get(layer).ordered.size();
            List<ChunkSectionsToRender.GpuMultiDrawIndexedIndirect> layerDraws = new ArrayList<>(batchCount);
            draws.put(layer, layerDraws);
            for (int i = 0; i < batchCount; i++) {
                Batch batch = submissionOrder.get(commandIndex);
                layerDraws.add(new ChunkSectionsToRender.GpuMultiDrawIndexedIndirect(batch.vertex.slice(),
                    batch.index == null ? null : batch.index.slice(), batch.indexType, commands[commandIndex++], batch.commands.size()));
            }
        }
        var terrain = gpu.writeTerrainTransform(matrix, atlasWidth, atlasHeight);
        var sectionData = gpu.writeChunkSectionsInstanced(infos);
        if (largestSequentialIndexCount > 0) RenderSystem.getSequentialBuffer(PrimitiveTopology.QUADS).requestIndexCount(largestSequentialIndexCount);
        AstFPSRuntime.terrainBatchFrames++;
        AstFPSRuntime.terrainIndirectFrames++;
        AstFPSRuntime.terrainSectionDraws += drawCount;
        AstFPSRuntime.terrainGpuBatches += commandIndex;
        return new ChunkSectionsToRender.DrawIndirect(terrain, draws, largestSequentialIndexCount, sectionData);
    }
}
