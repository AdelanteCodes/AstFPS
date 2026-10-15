package dev.adelantecodes.astfps.client.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import dev.adelantecodes.astfps.client.render.SectionMeshWorkspace;
import it.unimi.dsi.fastutil.ints.IntArrayFIFOQueue;
import java.util.BitSet;
import java.util.Set;
import net.minecraft.client.renderer.chunk.VisGraph;
import net.minecraft.core.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

/** Fresh graph objects and fresh output sets; reuse only graph-local primitive scratch storage. */
@Mixin(VisGraph.class)
public abstract class SectionMeshWorkspaceVisGraphMixin {
    @WrapOperation(method = "<init>", at = @At(value = "NEW", target = "java/util/BitSet", ordinal = 0))
    private BitSet astfpsMeshVisibilityBits(int bits, Operation<BitSet> original) {
        return SectionMeshWorkspace.visibility(bits, original);
    }

    @WrapMethod(method = "floodFill")
    private Set<Direction> astfpsMeshFloodScope(int start, Operation<Set<Direction>> original) {
        SectionMeshWorkspace workspace = SectionMeshWorkspace.enterFloodFill();
        try {
            return original.call(start);
        } finally {
            if (workspace != null) workspace.leaveFloodFill();
        }
    }

    @WrapOperation(method = "floodFill", at = @At(value = "NEW", target = "it/unimi/dsi/fastutil/ints/IntArrayFIFOQueue", ordinal = 0))
    private IntArrayFIFOQueue astfpsMeshFloodQueue(Operation<IntArrayFIFOQueue> original) {
        return SectionMeshWorkspace.queue(original);
    }
}
