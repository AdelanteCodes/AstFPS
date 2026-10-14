package dev.adelantecodes.astfps.client.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.blaze3d.vertex.VertexSorting;
import dev.adelantecodes.astfps.client.AstFPSRuntime;
import dev.adelantecodes.astfps.client.render.SectionWorkerCache;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.renderer.SectionBufferBuilderPack;
import net.minecraft.client.renderer.block.FluidRenderer;
import net.minecraft.client.renderer.block.FluidStateModelSet;
import net.minecraft.client.renderer.block.ModelBlockRenderer;
import net.minecraft.client.renderer.chunk.RenderSectionRegion;
import net.minecraft.client.renderer.chunk.SectionCompiler;
import net.minecraft.core.SectionPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

/** Keeps native compilation and its hooks; only native helper factories are optional cache points. */
@Mixin(SectionCompiler.class)
public abstract class SectionWorkerCacheMixin {
    @Unique private final ThreadLocal<SectionWorkerCache> astfpsWorkerCache = ThreadLocal.withInitial(SectionWorkerCache::new);

    @WrapMethod(method = "compile")
    private SectionCompiler.Results astfpsCompilationScope(SectionPos position, RenderSectionRegion region,
            VertexSorting sorting, SectionBufferBuilderPack builders, Operation<SectionCompiler.Results> original) {
        if (!AstFPSRuntime.SECTION_WORKER_CACHE.enabled()) return original.call(position, region, sorting, builders);
        SectionWorkerCache cache = astfpsWorkerCache.get();
        cache.enter();
        try {
            var result = original.call(position, region, sorting, builders);
            AstFPSRuntime.sectionCacheJobs.increment();
            return result;
        } catch (RuntimeException error) {
            cache.discard();
            AstFPSRuntime.sectionCacheFailure("SectionCompiler.compile", error);
            // Preserve the game's error and partially built-buffer handling; never retry a dirty compile.
            throw error;
        } finally {
            cache.leave();
        }
    }

    @WrapOperation(method = "compile", at = @At(value = "NEW", target = "net/minecraft/client/renderer/block/ModelBlockRenderer"))
    private ModelBlockRenderer astfpsModelHelper(boolean ambientOcclusion, boolean cull, BlockColors colors,
            Operation<ModelBlockRenderer> original) {
        if (!AstFPSRuntime.SECTION_WORKER_CACHE.enabled()) return original.call(ambientOcclusion, cull, colors);
        SectionWorkerCache cache = astfpsWorkerCache.get();
        return cache.model(ambientOcclusion, cull, colors, original);
    }

    @WrapOperation(method = "compile", at = @At(value = "NEW", target = "net/minecraft/client/renderer/block/FluidRenderer"))
    private FluidRenderer astfpsFluidHelper(FluidStateModelSet models, Operation<FluidRenderer> original) {
        if (!AstFPSRuntime.SECTION_WORKER_CACHE.enabled()) return original.call(models);
        SectionWorkerCache cache = astfpsWorkerCache.get();
        return cache.fluid(models, original);
    }
}
