package dev.adelantecodes.astfps.client.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import dev.adelantecodes.astfps.client.AstFPSRuntime;
import dev.adelantecodes.astfps.client.render.ModelRotationWorkspace;
import net.minecraft.client.model.geom.ModelPart;
import org.joml.Matrix3f;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

/** Preserve rotateBy and its callbacks; substitute only its two nonescaping native temporaries. */
@Mixin(ModelPart.class)
public abstract class ModelRotationScratchMixin {
    @WrapMethod(method = "rotateBy")
    private void astfpsRotationScope(Quaternionf rotation, Operation<Void> original) {
        if ((!AstFPSRuntime.MODEL_ROTATION_SCRATCH.enabled() || ((Object) this).getClass() != ModelPart.class)
                && !ModelRotationWorkspace.inScope()) {
            original.call(rotation);
            return;
        }
        ModelRotationWorkspace workspace = ModelRotationWorkspace.enter();
        try {
            original.call(rotation);
            workspace.complete();
        } catch (RuntimeException error) {
            workspace.poison();
            AstFPSRuntime.modelRotationFailure("ModelPart.rotateBy", error);
            throw error;
        } catch (Error error) {
            workspace.poison();
            throw error;
        } finally {
            workspace.leave();
        }
    }

    @WrapOperation(method = "rotateBy", at = @At(value = "NEW", target = "org/joml/Matrix3f", ordinal = 0))
    private Matrix3f astfpsRotationMatrix(Operation<Matrix3f> original) {
        return ModelRotationWorkspace.matrix(original);
    }

    @WrapOperation(method = "rotateBy", at = @At(value = "NEW", target = "org/joml/Vector3f", ordinal = 0))
    private Vector3f astfpsRotationVector(Operation<Vector3f> original) {
        return ModelRotationWorkspace.vector(original);
    }
}
