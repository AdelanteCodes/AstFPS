package dev.kyzer.astfps.client.render;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.renderpearl.api.buffers.GpuBuffer;
import com.mojang.renderpearl.api.buffers.GpuBufferSlice;
import com.mojang.renderpearl.api.commands.RenderPass;
import com.mojang.renderpearl.api.pipeline.IndexType;
import com.mojang.renderpearl.api.pipeline.PrimitiveTopology;
import dev.kyzer.astfps.client.AstFPSRuntime;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.IdentityHashMap;
import java.util.List;
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

    private static final class Batch {
        GpuBuffer vertex;
        GpuBuffer index;
        IndexType indexType;
        final ArrayList<DynamicGpuData.IndexedDraw> commands = new ArrayList<>();
        int cursor;
        long allocated;
        long reused;
        int commandHighWater;
        void reset(GpuBuffer vertex, GpuBuffer index, IndexType indexType) {
            this.vertex = vertex; this.index = index; this.indexType = indexType;
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
        IdentityHashMap<GpuBuffer, List<Batch>> byVertex = new IdentityHashMap<>();
        final ArrayList<Batch> pool = new ArrayList<>();
        int used;
        Batch acquire(GpuBuffer vertex, GpuBuffer index, IndexType type) {
            Batch batch;
            if (used < pool.size()) batch = pool.get(used);
            else { batch = new Batch(); pool.add(batch); }
            used++; batch.reset(vertex, index, type); return batch;
        }
        Batch find(GpuBuffer vertex, GpuBuffer index, IndexType type, boolean orderedTransparency) {
            if (orderedTransparency) {
                if (!ordered.isEmpty() && ordered.getLast().matches(vertex, index, type)) return ordered.getLast();
                Batch batch = acquire(vertex, index, type);
                ordered.add(batch); return batch;
            }
            List<Batch> candidates = byVertex.get(vertex);
            if (candidates != null) {
                for (int i = 0; i < candidates.size(); i++) {
                    Batch batch = candidates.get(i);
                    if (batch.matches(vertex, index, type)) return batch;
                }
            } else {
                candidates = new ArrayList<>(1); byVertex.put(vertex, candidates);
            }
            Batch batch = acquire(vertex, index, type);
            candidates.add(batch); ordered.add(batch); return batch;
        }
    }

    /** Renderer-owned CPU scratch; retained commands contain integers, never GPU resources. */
    public static final class Workspace {
        private static final int RETAINED_COMMAND_BUDGET = 16_384;
        private static final int RETAINED_BATCHES_PER_LAYER = 32;
        private final Thread owner = Thread.currentThread();
        private final EnumMap<ChunkSectionLayer, LayerBatches> layers = new EnumMap<>(ChunkSectionLayer.class);
        private final ArrayList<DynamicGpuData.ChunkSectionInfo> infos = new ArrayList<>();
        private final ArrayList<List<DynamicGpuData.IndexedDraw>> commandGroups = new ArrayList<>();
        private final ArrayList<Batch> submissionOrder = new ArrayList<>();
        private final int[] strides = new int[LAYERS.length];
        private boolean busy;
        public Workspace() { for (var layer : LAYERS) layers.put(layer, new LayerBatches()); }
        private void begin() {
            if (Thread.currentThread() != owner || busy) throw new IllegalStateException("Terrain workspace ownership/reentrancy violation");
            busy = true;
            for (var layer : LAYERS) layers.get(layer).used = 0;
        }
        private void finish() {
            int remaining = RETAINED_COMMAND_BUDGET;
            infos.clear();
            if (infosCapacityExceeded) infos.trimToSize();
            infosCapacityExceeded = false;
            boolean largeGroupLists = submissionOrder.size() > 128;
            commandGroups.clear(); submissionOrder.clear();
            if (largeGroupLists) { commandGroups.trimToSize(); submissionOrder.trimToSize(); }
            for (var layer : LAYERS) {
                var state = layers.get(layer);
                boolean largeOrderedList = state.ordered.size() > 128;
                state.ordered.clear();
                if (largeOrderedList) state.ordered.trimToSize();
                if (state.byVertex.size() > 128) state.byVertex = new IdentityHashMap<>();
                else state.byVertex.clear();
                int retain = Math.min(state.pool.size(), RETAINED_BATCHES_PER_LAYER);
                for (int i = 0; i < state.pool.size(); i++) {
                    Batch batch = state.pool.get(i);
                    batch.vertex = null; batch.index = null; batch.indexType = null;
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
                        if (infoIndex < 0) {
                            BlockPos origin = section.getRenderOrigin();
                            infoIndex = infos.size();
                            infos.add(new DynamicGpuData.ChunkSectionInfo(origin.getX(), origin.getY(), origin.getZ(), section.getVisibility(now, fadeMillis)));
                        }
                        GpuBuffer index = draw.hasCustomIndexBuffer() ? slice.indexBuffer() : null;
                        IndexType type = draw.hasCustomIndexBuffer() ? draw.indexType() : null;
                        int firstIndex = type == null ? 0 : Math.toIntExact(slice.indexBufferOffset() / type.bytes);
                        int baseVertex = Math.toIntExact(slice.vertexBufferOffset() / strides[layer.ordinal()]);
                        if (type == null) largestSequentialIndexCount = Math.max(largestSequentialIndexCount, draw.indexCount());
                        Batch batch = layers.get(layer).find(slice.vertexBuffer(), index, type, orderedTransparency && layer.translucent());
                        batch.add(draw.indexCount(), firstIndex, baseVertex, infoIndex);
                        drawCount++;
                    }
                }
            } finally {
                dispatcher.unlock();
            }
        }

        var commandGroups = workspace.commandGroups;
        var submissionOrder = workspace.submissionOrder;
        for (ChunkSectionLayer layer : LAYERS) {
            List<Batch> batches = layers.get(layer).ordered;
            boolean reversed = layer.translucent() && orderedTransparency;
            for (int i = 0; i < batches.size(); i++) {
                Batch batch = batches.get(reversed ? batches.size() - 1 - i : i);
                batch.seal();
                submissionOrder.add(batch);
                commandGroups.add(reversed ? batch.commands.reversed() : batch.commands);
                AstFPSRuntime.terrainCommandRecordsAllocated += batch.allocated;
                AstFPSRuntime.terrainCommandRecordsReused += batch.reused;
            }
        }
        var gpu = RenderSystem.getDynamicUniforms();
        if (!indirect) {
            EnumMap<ChunkSectionLayer, List<RenderPass.Draw<GpuBufferSlice[]>>> directDraws = new EnumMap<>(ChunkSectionLayer.class);
            int group = 0;
            for (ChunkSectionLayer layer : LAYERS) {
                var list = new ArrayList<RenderPass.Draw<GpuBufferSlice[]>>();
                directDraws.put(layer, list);
                for (int b = 0; b < layers.get(layer).ordered.size(); b++) {
                    Batch batch = submissionOrder.get(group);
                    for (var command : commandGroups.get(group++)) {
                        final int infoIndex = command.baseInstance();
                        list.add(new RenderPass.Draw<>(0, batch.vertex, batch.index, batch.indexType,
                            command.firstIndex(), command.indexCount(), command.baseVertex(),
                            (buffers, uploader) -> uploader.setUniform("ChunkSection", buffers[infoIndex])));
                    }
                }
            }
            var terrain = gpu.writeTerrainTransform(matrix, atlasWidth, atlasHeight);
            var sectionData = gpu.writeChunkSections(infos.toArray(DynamicGpuData.ChunkSectionInfo[]::new));
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
