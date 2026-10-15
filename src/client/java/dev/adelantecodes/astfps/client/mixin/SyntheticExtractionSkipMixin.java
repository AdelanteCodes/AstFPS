package dev.adelantecodes.astfps.client.mixin;

import dev.adelantecodes.astfps.client.AstFPSRuntime;
import dev.adelantecodes.astfps.client.render.FrameGenerationController;
import net.minecraft.client.Camera;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.renderer.extract.LevelExtractor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/** Synthetic presentations reuse the last real world state; GUI extraction remains live. */
@Mixin(value = LevelExtractor.class, priority = 1100)
public abstract class SyntheticExtractionSkipMixin {
    @Inject(method = "extract", at = @At("HEAD"), cancellable = true)
    private void astfpsSkipInvisibleWorldExtraction(DeltaTracker delta, Camera camera,
                                                     float partialTick, CallbackInfo ci) {
        if (!FrameGenerationController.renderRealWorldThisPresentation()) {
            AstFPSRuntime.syntheticWorldExtractionsSkipped++;
            ci.cancel();
        }
    }
}
