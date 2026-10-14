package dev.kyzer.xemod.client.mixin;

import dev.kyzer.xemod.client.XeRuntime;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/** Drops stale targeting references after the old world has been detached. */
@Mixin(Minecraft.class)
public abstract class WorldTargetCleanupMixin {
    @Inject(method = "clearClientLevel(Lnet/minecraft/client/gui/screens/Screen;)V", at = @At("RETURN"))
    private void xeAfterClearLevel(Screen screen, CallbackInfo callback) {
        xeReleaseTargets();
    }

    @Inject(method = "disconnect(Lnet/minecraft/client/gui/screens/Screen;ZZ)V", at = @At("RETURN"))
    private void xeAfterDisconnect(Screen screen, boolean transferring, boolean keepResourcePacks, CallbackInfo callback) {
        xeReleaseTargets();
    }

    @Unique
    private void xeReleaseTargets() {
        Minecraft client = (Minecraft) (Object) this;
        if (client.level != null) return;
        int released = (client.crosshairPickEntity != null ? 1 : 0) + (client.hitResult != null ? 1 : 0);
        client.crosshairPickEntity = null;
        client.hitResult = null;
        if (released != 0) {
            XeRuntime.worldTargetCleanups++;
            XeRuntime.releasedTargetReferences += released;
        }
    }
}
