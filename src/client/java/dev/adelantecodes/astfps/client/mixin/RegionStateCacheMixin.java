package dev.adelantecodes.astfps.client.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import dev.adelantecodes.astfps.client.AstFPSRuntime;
import dev.adelantecodes.astfps.client.render.SectionStateCache;
import net.minecraft.client.renderer.chunk.RenderSectionRegion;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(RenderSectionRegion.class)
public abstract class RegionStateCacheMixin {
    @WrapMethod(method = "getBlockState")
    private BlockState astfpsStateRead(BlockPos position, Operation<BlockState> original) {
        if (!AstFPSRuntime.SECTION_STATE_CACHE.enabled()) return original.call(position);
        return SectionStateCache.get((RenderSectionRegion) (Object) this, position, original);
    }
}
