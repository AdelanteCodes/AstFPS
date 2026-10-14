package dev.kyzer.xemod.client.mixin;

import dev.kyzer.xemod.client.XeClient;
import dev.kyzer.xemod.client.XeRuntime;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public abstract class MinecraftFrameMixin {
    @Inject(method = "runTick", at = @At("HEAD"))
    private void xeFrameStart(CallbackInfo callback) {
        XeRuntime.frameEpoch++;
        if (XeClient.RECORDER.isRecording()) XeClient.RECORDER.frameStart(System.nanoTime());
    }
}
