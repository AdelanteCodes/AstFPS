package dev.adelantecodes.astfps.client.mixin;
import dev.adelantecodes.astfps.client.ZoomController;
import net.minecraft.client.MouseHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
@Mixin(MouseHandler.class)
public abstract class ZoomScrollMixin {
    @Inject(method="onScroll",at=@At("HEAD"),cancellable=true)
    private void astfpsZoomScroll(long window,double horizontal,double vertical,CallbackInfo ci){
        if(ZoomController.active()){ZoomController.scroll(vertical);ci.cancel();}
    }
}
