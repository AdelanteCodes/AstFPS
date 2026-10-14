package dev.kyzer.xemod.client.mixin;

import dev.kyzer.xemod.VisibilityMemo;
import dev.kyzer.xemod.client.XeRuntime;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.world.phys.AABB;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Frustum.class)
public abstract class FrustumMemoMixin {
    @Unique private final VisibilityMemo xeMemo = new VisibilityMemo();

    @Inject(method = {"prepare", "set(Lnet/minecraft/client/renderer/culling/Frustum;)V", "calculateFrustum"}, at = @At("HEAD"))
    private void xeInvalidate(CallbackInfo callback) {
        if (xeMemo != null) xeMemo.invalidate();
    }

    @Inject(method = "offsetToFullyIncludeCameraCube", at = @At("HEAD"))
    private void xeInvalidateOffset(CallbackInfoReturnable<Frustum> callback) {
        if (xeMemo != null) xeMemo.invalidate();
    }

    @Inject(method = "isVisible(Lnet/minecraft/world/phys/AABB;)Z", at = @At("HEAD"), cancellable = true)
    private void xeLookup(AABB box, CallbackInfoReturnable<Boolean> callback) {
        if (!XeRuntime.visibilityMemoEnabled) return;
        int result = xeMemo.probe(XeRuntime.frameEpoch, box.minX, box.minY, box.minZ, box.maxX, box.maxY, box.maxZ);
        if (result >= 0) { XeRuntime.visibilityHits++; callback.setReturnValue(result == 1); }
        else XeRuntime.visibilityMisses++;
    }

    @Inject(method = "isVisible(Lnet/minecraft/world/phys/AABB;)Z", at = @At("RETURN"))
    private void xeRemember(AABB box, CallbackInfoReturnable<Boolean> callback) {
        if (XeRuntime.visibilityMemoEnabled)
            xeMemo.store(XeRuntime.frameEpoch, box.minX, box.minY, box.minZ, box.maxX, box.maxY, box.maxZ, callback.getReturnValueZ());
    }
}
