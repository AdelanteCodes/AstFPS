package dev.adelantecodes.astfps.client.mixin;

import dev.adelantecodes.astfps.VisibilityMemo;
import dev.adelantecodes.astfps.client.AstFPSRuntime;
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
    @Unique private final VisibilityMemo astfpsMemo = new VisibilityMemo();

    @Inject(method = {"prepare", "set(Lnet/minecraft/client/renderer/culling/Frustum;)V", "calculateFrustum"}, at = @At("HEAD"))
    private void astfpsInvalidate(CallbackInfo callback) {
        if (astfpsMemo != null) astfpsMemo.invalidate();
    }

    @Inject(method = "offsetToFullyIncludeCameraCube", at = @At("HEAD"))
    private void astfpsInvalidateOffset(CallbackInfoReturnable<Frustum> callback) {
        if (astfpsMemo != null) astfpsMemo.invalidate();
    }

    @Inject(method = "isVisible(Lnet/minecraft/world/phys/AABB;)Z", at = @At("HEAD"), cancellable = true)
    private void astfpsLookup(AABB box, CallbackInfoReturnable<Boolean> callback) {
        if (!AstFPSRuntime.VISIBILITY_MEMO.enabled()) return;
        try {
            int result = astfpsMemo.probe(AstFPSRuntime.frameEpoch, box.minX, box.minY, box.minZ, box.maxX, box.maxY, box.maxZ);
            if (result >= 0) { AstFPSRuntime.visibilityHits++; callback.setReturnValue(result == 1); }
            else AstFPSRuntime.visibilityMisses++;
        } catch (RuntimeException error) { AstFPSRuntime.memoFailure("Frustum.isVisible/cache-lookup", error); }
    }

    @Inject(method = "isVisible(Lnet/minecraft/world/phys/AABB;)Z", at = @At("RETURN"))
    private void astfpsRemember(AABB box, CallbackInfoReturnable<Boolean> callback) {
        if (!AstFPSRuntime.VISIBILITY_MEMO.enabled()) return;
        try {
            astfpsMemo.store(AstFPSRuntime.frameEpoch, box.minX, box.minY, box.minZ, box.maxX, box.maxY, box.maxZ, callback.getReturnValueZ());
        } catch (RuntimeException error) { AstFPSRuntime.memoFailure("Frustum.isVisible/cache-store", error); }
    }
}
