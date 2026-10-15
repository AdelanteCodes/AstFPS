package dev.adelantecodes.astfps.client.mixin;

import dev.adelantecodes.astfps.client.AstFPSProfiles;
import dev.adelantecodes.astfps.client.AstFPSRuntime;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/** Maximum-mode distance culling after native renderer/frustum checks and before render-state extraction. */
@Mixin(EntityRenderDispatcher.class)
public abstract class EntityDistanceCullingMixin {
    @Inject(method = "shouldRender", at = @At("RETURN"), cancellable = true)
    private <E extends Entity> void astfpsMaximumDistance(E entity, Frustum frustum,
            double cameraX, double cameraY, double cameraZ, float partialTick,
            CallbackInfoReturnable<Boolean> callback) {
        if (!callback.getReturnValueZ() || !AstFPSProfiles.maximum()) return;
        // Never hide players, glowing/selected objects, named entities, vehicles, bosses represented
        // as players, or projectiles whose long-range motion is gameplay-relevant.
        if (entity instanceof Player || entity instanceof Projectile || entity.isCurrentlyGlowing()
                || entity.hasCustomName() || entity.isPassenger() || entity.isVehicle()) return;
        double limit = entity instanceof ExperienceOrb ? 24.0
            : entity instanceof ItemEntity ? 32.0
            : entity instanceof LivingEntity ? 64.0 : 48.0;
        if (entity.distanceToSqr(cameraX, cameraY, cameraZ) > limit * limit) {
            AstFPSRuntime.entitiesDistanceCulled++;
            callback.setReturnValue(false);
        }
    }
}
