package dev.adelantecodes.astfps.client.mixin;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import dev.adelantecodes.astfps.client.ZoomController;
import net.minecraft.client.Camera;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
@Mixin(Camera.class)
public abstract class ZoomCameraMixin {
    @ModifyReturnValue(method="calculateFov",at=@At("RETURN"))
    private float astfpsZoomFov(float original){return ZoomController.apply(original);}
}
