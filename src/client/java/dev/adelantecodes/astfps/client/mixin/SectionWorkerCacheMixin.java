package dev.adelantecodes.astfps.client.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import dev.adelantecodes.astfps.client.AstFPSRuntime;
import dev.adelantecodes.astfps.client.render.SectionWorkerCache;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.renderer.block.FluidRenderer;
import net.minecraft.client.renderer.block.FluidStateModelSet;
import net.minecraft.client.renderer.block.ModelBlockRenderer;
import net.minecraft.client.renderer.chunk.SectionCompiler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

/** Keeps native compilation and its hooks; only native helper factories are optional cache points. */
@Mixin(SectionCompiler.class)
public abstract class SectionWorkerCacheMixin {
    @WrapOperation(method = "compile", at = @At(value = "NEW", target = "net/minecraft/client/renderer/block/ModelBlockRenderer"))
    private ModelBlockRenderer astfpsModelHelper(boolean ambientOcclusion, boolean cull, BlockColors colors,
            Operation<ModelBlockRenderer> original) {
        if (!AstFPSRuntime.SECTION_WORKER_CACHE.enabled()) return original.call(ambientOcclusion, cull, colors);
        SectionWorkerCache cache = dev.adelantecodes.astfps.client.render.SectionCompilationContext.worker();
        if (cache == null) return original.call(ambientOcclusion, cull, colors);
        return cache.model(ambientOcclusion, cull, colors, original);
    }

    @WrapOperation(method = "compile", at = @At(value = "NEW", target = "net/minecraft/client/renderer/block/FluidRenderer"))
    private FluidRenderer astfpsFluidHelper(FluidStateModelSet models, Operation<FluidRenderer> original) {
        if (!AstFPSRuntime.SECTION_WORKER_CACHE.enabled()) return original.call(models);
        SectionWorkerCache cache = dev.adelantecodes.astfps.client.render.SectionCompilationContext.worker();
        if (cache == null) return original.call(models);
        return cache.fluid(models, original);
    }
}
