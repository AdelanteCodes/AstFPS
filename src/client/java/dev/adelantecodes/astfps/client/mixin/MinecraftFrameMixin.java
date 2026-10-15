package dev.adelantecodes.astfps.client.mixin;

import dev.adelantecodes.astfps.client.AstFPSClient;
import dev.adelantecodes.astfps.client.AstFPSRuntime;
import dev.adelantecodes.astfps.StageTimings;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public abstract class MinecraftFrameMixin {
    @Inject(method = "runTick", at = @At("HEAD"))
    private void astfpsFrameStart(CallbackInfo callback) {
        if (AstFPSRuntime.VISIBILITY_MEMO.enabled()) AstFPSRuntime.frameEpoch++;
        if (AstFPSClient.RECORDER.isRecording()) {
            AstFPSClient.RECORDER.frameStart(System.nanoTime());
            if (!AstFPSClient.RECORDER.isRecording()) StageTimings.stopCapturing();
        }
    }
}
