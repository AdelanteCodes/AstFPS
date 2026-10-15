package dev.adelantecodes.astfps.client.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import dev.adelantecodes.astfps.client.render.EntityVisibilityClock;
import net.minecraft.client.Camera;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.extract.LevelExtractor;
import net.minecraft.client.renderer.state.level.LevelRenderState;
import org.spongepowered.asm.mixin.Mixin;

/** Defines a strict lifetime for the shared entity-visibility timestamp. */
@Mixin(LevelExtractor.class)
public abstract class EntityVisibilityExtractionMixin {
    @WrapMethod(method = "extractVisibleEntities")
    private void astfpsShareVisibilityTime(Camera camera, Frustum frustum, DeltaTracker delta,
            LevelRenderState state, Operation<Void> original) {
        EntityVisibilityClock.enter();
        try {
            original.call(camera, frustum, delta, state);
        } finally {
            EntityVisibilityClock.leave();
        }
    }
}
