package dev.adelantecodes.astfps.client.render;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.mojang.blaze3d.vertex.BufferBuilder;
import dev.adelantecodes.astfps.client.AstFPSRuntime;
import dev.adelantecodes.astfps.client.AdaptiveRuntime;
import it.unimi.dsi.fastutil.ints.IntArrayFIFOQueue;
import java.util.BitSet;
import java.util.EnumMap;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;

/** Bounded compile-only scratch. No world, model, mesh, or native-buffer ownership. */
public final class SectionMeshWorkspace {
    private static final int MAX_RETAINED_QUEUE_CAPACITY = 8192;
    private EnumMap<ChunkSectionLayer, BufferBuilder> layers;
    private BitSet visibility;
    private IntArrayFIFOQueue queue;
    private int floodDepth;
    private boolean layersClaimed;
    private boolean visibilityClaimed;
    private boolean queueClaimed;
    private boolean poisoned;

    SectionMeshWorkspace() { }

    void begin() {
        layersClaimed = false;
        visibilityClaimed = false;
        poisoned = false;
    }

    private static SectionMeshWorkspace active() {
        SectionMeshWorkspace workspace = SectionCompilationContext.mesh();
        return workspace != null && !workspace.poisoned ? workspace : null;
    }

    public void poison() {
        poisoned = true;
    }

    void finish() {
        // Clear builder references only after compile, sorting, and Fabric's synchronous emitter finish.
        if (layers != null) layers.clear();
        if (visibility != null) visibility.clear();
        if (queue != null) queue.clear();
        if (poisoned) {
            layers = null;
            visibility = null;
            queue = null;
        } else {
            int scale = AdaptiveRuntime.snapshot().cacheScalePercent();
            if (scale < 50) {
                layers = null;
                visibility = null;
                queue = null;
            } else {
                if (visibility != null && visibility.size() > 4096L * scale / 100) visibility = null;
                if (queue != null && queue.capacity() > MAX_RETAINED_QUEUE_CAPACITY * scale / 100) queue = null;
            }
        }
        floodDepth = 0;
        queueClaimed = false;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static EnumMap layers(Class keyType, Operation<EnumMap> original) {
        SectionMeshWorkspace workspace = active();
        if (workspace == null || workspace.layersClaimed || keyType != ChunkSectionLayer.class) {
            return original.call(keyType);
        }
        workspace.layersClaimed = true;
        if (workspace.layers != null) {
            AstFPSRuntime.layerMapsReused.increment();
            return workspace.layers;
        }
        EnumMap map = original.call(keyType);
        // Preserve a cooperating constructor wrapper's custom collection implementation.
        if (map.getClass() == EnumMap.class && map.isEmpty()) workspace.layers = map;
        return map;
    }

    public static BitSet visibility(int bits, Operation<BitSet> original) {
        SectionMeshWorkspace workspace = active();
        if (workspace == null || workspace.visibilityClaimed || bits != 4096) return original.call(bits);
        workspace.visibilityClaimed = true;
        if (workspace.visibility != null) {
            workspace.visibility.clear();
            AstFPSRuntime.visibilityBitsetsReused.increment();
            return workspace.visibility;
        }
        BitSet bitSet = original.call(bits);
        if (bitSet.getClass() == BitSet.class && bitSet.isEmpty()) workspace.visibility = bitSet;
        return bitSet;
    }

    public static SectionMeshWorkspace enterFloodFill() {
        SectionMeshWorkspace workspace = active();
        if (workspace != null) workspace.floodDepth++;
        return workspace;
    }

    public void leaveFloodFill() {
        if (--floodDepth == 0) {
            if (queue != null) queue.clear();
            queueClaimed = false;
        }
    }

    public static IntArrayFIFOQueue queue(Operation<IntArrayFIFOQueue> original) {
        SectionMeshWorkspace workspace = active();
        if (workspace == null || workspace.floodDepth != 1 || workspace.queueClaimed) return original.call();
        workspace.queueClaimed = true;
        if (workspace.queue != null) {
            AstFPSRuntime.floodQueuesReused.increment();
            return workspace.queue;
        }
        IntArrayFIFOQueue nativeQueue = original.call();
        if (nativeQueue.getClass() != IntArrayFIFOQueue.class || !nativeQueue.isEmpty()) return nativeQueue;
        workspace.queue = new SectionMeshWorkspaceQueue();
        return workspace.queue;
    }
}
