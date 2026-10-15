package dev.adelantecodes.astfps.client.mixin;

import dev.adelantecodes.astfps.client.AstFPSClient;
import dev.adelantecodes.astfps.client.AstFPSRuntime;
import dev.adelantecodes.astfps.StageTimings;
import dev.adelantecodes.astfps.client.render.FrameGenerationController;
import dev.adelantecodes.astfps.client.AdaptiveRuntime;
import dev.adelantecodes.astfps.client.AutoBenchmark;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public abstract class MinecraftFrameMixin {
    @Inject(method = "runTick", at = @At("HEAD"))
    private void astfpsFrameStart(CallbackInfo callback) {
        long now = System.nanoTime();
        Minecraft minecraft = (Minecraft) (Object) this;
        double gpu = minecraft.getGpuUtilization();
        var dispatcher = minecraft.levelRenderer.sectionRenderDispatcher();
        AdaptiveRuntime.frame(gpu, dispatcher == null ? 0 : dispatcher.getCompileQueueSize());
        FrameGenerationController.frameStart(gpu);
        AutoBenchmark.frame(minecraft, now);
        if (AstFPSRuntime.VISIBILITY_MEMO.enabled()) AstFPSRuntime.frameEpoch++;
        if (AstFPSClient.RECORDER.isRecording()) {
            AstFPSClient.RECORDER.frameStart(now);
            if (!AstFPSClient.RECORDER.isRecording()) StageTimings.stopCapturing();
        }
    }
}
