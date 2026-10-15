package dev.adelantecodes.astfps.client.mixin;

import dev.adelantecodes.astfps.client.render.EntityVisibilityClock;
import net.minecraft.client.renderer.LevelRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

/** Avoids a native clock query per entity while retaining one timestamp per extraction pass. */
@Mixin(LevelRenderer.class)
public abstract class EntityVisibilityClockMixin {
    @Redirect(method = "isSectionCompiledAndVisible", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/util/Util;getMillis()J"))
    private long astfpsEntityVisibilityTime() {
        return EntityVisibilityClock.millis();
    }
}
