package dev.adelantecodes.astfps.client.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import dev.adelantecodes.astfps.client.AstFPSRuntime;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.chunk.RenderSectionRegion;
import net.minecraft.client.renderer.chunk.SectionRenderDispatcher;
import net.minecraft.client.renderer.state.level.SectionUpdateRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

/** Performance modes trade a short chunk-appearance delay for removal of render-thread compile stalls. */
@Mixin(LevelRenderer.class)
public abstract class ChunkCompileSchedulingMixin {
    @WrapOperation(method = "compileSections", at = @At(value = "INVOKE",
        target = "Lnet/minecraft/client/renderer/chunk/SectionRenderDispatcher$RenderSection;compileSync(Lnet/minecraft/client/renderer/chunk/RenderSectionRegion;)V"))
    private void astfpsAvoidSynchronousCompile(SectionRenderDispatcher.RenderSection section,
            RenderSectionRegion region, Operation<Void> original,
            @Local SectionUpdateRenderState update) {
        // Player-edited blocks must remain immediate. Nearby terrain streaming may complete one or
        // more frames later, preventing chunk compilation from monopolizing the render thread.
        if (update != null && !update.playerChanged()) {
            section.compileAsync(region);
            AstFPSRuntime.synchronousChunkCompilesDeferred++;
        } else {
            original.call(section, region);
        }
    }
}
