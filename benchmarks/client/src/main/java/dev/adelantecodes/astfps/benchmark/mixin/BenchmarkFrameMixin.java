package dev.adelantecodes.astfps.benchmark.mixin;
import dev.adelantecodes.astfps.benchmark.BenchmarkClient;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
@Mixin(Minecraft.class)
public abstract class BenchmarkFrameMixin {
    @Inject(method = "runTick", at = @At("HEAD"))
    private void astfpsBenchmarkFrame(boolean renderLevel, CallbackInfo ci) {
        BenchmarkClient.frame((Minecraft) (Object) this);
    }
}
