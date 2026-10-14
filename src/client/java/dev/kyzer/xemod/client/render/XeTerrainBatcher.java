package dev.kyzer.xemod.client.render;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.renderpearl.api.buffers.GpuBuffer;
import com.mojang.renderpearl.api.buffers.GpuBufferSlice;
import com.mojang.renderpearl.api.pipeline.IndexType;
import com.mojang.renderpearl.api.pipeline.PrimitiveTopology;
import dev.kyzer.xemod.client.XeRuntime;
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
public final class XeTerrainBatcher {
    private static final ChunkSectionLayer[] LAYERS = ChunkSectionLayer.values();
    private XeTerrainBatcher() { }

    private static final class Batch {
        final GpuBuffer vertex;
        final GpuBuffer index;
        final IndexType indexType;
        final List<DynamicGpuData.IndexedDraw> commands = new ArrayList<>();
        Batch(GpuBuffer vertex, GpuBuffer index, IndexType indexType) {
            this.vertex = vertex; this.index = index; this.indexType = indexType;
        }
        boolean matches(GpuBuffer vertex, GpuBuffer index, IndexType type) {
            return this.vertex == vertex && this.index == index && this.indexType == type;
        }
    }

    private static final class LayerBatches {
        final List<Batch> ordered = new ArrayList<>();
        final IdentityHashMap<GpuBuffer, List<Batch>> byVertex = new IdentityHashMap<>();
        Batch find(GpuBuffer vertex, GpuBuffer index, IndexType type, boolean orderedTransparency) {
            if (orderedTransparency) {
                if (!ordered.isEmpty() && ordered.getLast().matches(vertex, index, type)) return ordered.getLast();
                Batch batch = new Batch(vertex, index, type);
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
            Batch batch = new Batch(vertex, index, type);
            candidates.add(batch); ordered.add(batch); return batch;
        }
    }

    public static ChunkSectionsToRender prepare(SectionRenderDispatcher dispatcher,
            List<SectionRenderDispatcher.RenderSection> visible, Matrix4fc matrix,
            boolean orderedTransparency, double fadeSeconds, int atlasWidth, int atlasHeight) {
        EnumMap<ChunkSectionLayer, LayerBatches> layers = new EnumMap<>(ChunkSectionLayer.class);
        int[] strides = new int[LAYERS.length];
        for (ChunkSectionLayer layer : LAYERS) {
            layers.put(layer, new LayerBatches());
            strides[layer.ordinal()] = layer.pipeline(false).getVertexFormatBinding(0).getVertexSize();
        }
        List<DynamicGpuData.ChunkSectionInfo> infos = new ArrayList<>(visible.size());
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
                        batch.commands.add(new DynamicGpuData.IndexedDraw(draw.indexCount(), 1, firstIndex, baseVertex, infoIndex));
                        drawCount++;
                    }
                }
            } finally {
                dispatcher.unlock();
            }
        }

        List<List<DynamicGpuData.IndexedDraw>> commandGroups = new ArrayList<>();
        List<Batch> submissionOrder = new ArrayList<>();
        for (ChunkSectionLayer layer : LAYERS) {
            List<Batch> batches = layers.get(layer).ordered;
            boolean reversed = layer.translucent() && orderedTransparency;
            for (int i = 0; i < batches.size(); i++) {
                Batch batch = batches.get(reversed ? batches.size() - 1 - i : i);
                submissionOrder.add(batch);
                commandGroups.add(reversed ? batch.commands.reversed() : batch.commands);
            }
        }
        var gpu = RenderSystem.getDynamicUniforms();
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
        XeRuntime.terrainBatchFrames++;
        XeRuntime.terrainSectionDraws += drawCount;
        XeRuntime.terrainGpuBatches += commandIndex;
        return new ChunkSectionsToRender.DrawIndirect(terrain, draws, largestSequentialIndexCount, sectionData);
    }
}
