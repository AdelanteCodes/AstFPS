package dev.adelantecodes.astfps.client.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import dev.adelantecodes.astfps.client.AstFPSProfiles;
import dev.adelantecodes.astfps.client.V1Features;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.client.renderer.blockentity.ShulkerBoxRenderer;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.entity.ShulkerBoxBlockEntity;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

/** Explicit Maximum-profile visual tradeoff; native visibility runs first. Never changes ticking. */
@Mixin(BlockEntityRenderDispatcher.class)
public abstract class MaximumBlockEntityDistanceMixin {
    @Shadow private Vec3 cameraPos;

    @ModifyExpressionValue(method = "tryExtractRenderState(Lnet/minecraft/world/level/block/entity/BlockEntity;FLnet/minecraft/client/renderer/feature/ModelFeatureRenderer$CrumblingOverlay;Z)Lnet/minecraft/client/renderer/blockentity/state/BlockEntityRenderState;", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/client/renderer/blockentity/BlockEntityRenderer;shouldRender(Lnet/minecraft/world/level/block/entity/BlockEntity;Lnet/minecraft/world/phys/Vec3;)Z"))
    private boolean astfpsMaximumContainerDistance(boolean visible, @Local(argsOnly = true) BlockEntity entity,
            @Local(ordinal = 0) BlockEntityRenderer<?, ?> renderer, @Local(argsOnly = true) boolean offScreen) {
        if (offScreen || !visible || V1Features.culling() == V1Features.Level.OFF) return visible;
        // Restrict the tradeoff to native ordinary containers. Beacons, signs, custom block
        // entities and offscreen/special renderers keep their original distance behavior.
        Class<?> type = entity.getClass();
        Class<?> rendererType = renderer.getClass();
        if (!((type == ChestBlockEntity.class && rendererType == ChestRenderer.class)
                || (type == ShulkerBoxBlockEntity.class && rendererType == ShulkerBoxRenderer.class))) return visible;
        if (cameraPos == null || !Double.isFinite(cameraPos.x) || !Double.isFinite(cameraPos.y)
                || !Double.isFinite(cameraPos.z)) return visible;
        var position = entity.getBlockPos();
        double x = position.getX() + 0.5 - cameraPos.x;
        double y = position.getY() + 0.5 - cameraPos.y;
        double z = position.getZ() + 0.5 - cameraPos.z;
        double limit=switch(V1Features.culling()){case CONSERVATIVE->64.0;case BALANCED->48.0;case AGGRESSIVE->32.0;default->Double.POSITIVE_INFINITY;};
        return x * x + y * y + z * z < limit * limit;
    }
}
