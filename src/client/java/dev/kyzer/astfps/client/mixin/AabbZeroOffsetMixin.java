package dev.kyzer.astfps.client.mixin;

import net.minecraft.world.phys.AABB;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/** Reuses an immutable collision box only when all translated coordinates are bit-for-bit unchanged. */
@Mixin(AABB.class)
public abstract class AabbZeroOffsetMixin {
    @Inject(method = "move(DDD)Lnet/minecraft/world/phys/AABB;", at = @At("HEAD"), cancellable = true)
    private void astfpsReuseUnchangedBox(double x, double y, double z, CallbackInfoReturnable<AABB> callback) {
        if (x != 0.0 || y != 0.0 || z != 0.0) return;
        AABB box = (AABB) (Object) this;
        // Adding zero can change a negative-zero coordinate; preserve that vanilla behavior.
        if (astfpsSameCoordinate(box.minX, x) && astfpsSameCoordinate(box.maxX, x)
            && astfpsSameCoordinate(box.minY, y) && astfpsSameCoordinate(box.maxY, y)
            && astfpsSameCoordinate(box.minZ, z) && astfpsSameCoordinate(box.maxZ, z)) {
            callback.setReturnValue(box);
        }
    }

    @Unique
    private static boolean astfpsSameCoordinate(double coordinate, double offset) {
        return Double.isFinite(coordinate)
            && Double.doubleToRawLongBits(coordinate) == Double.doubleToRawLongBits(coordinate + offset);
    }
}
