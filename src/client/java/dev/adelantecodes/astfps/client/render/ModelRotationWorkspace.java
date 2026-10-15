package dev.adelantecodes.astfps.client.render;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import dev.adelantecodes.astfps.client.AstFPSRuntime;
import org.joml.Matrix3f;
import org.joml.Vector3f;

/** One small native rotation workspace per thread; nested calls keep their native allocations. */
public final class ModelRotationWorkspace {
    private static final ThreadLocal<ModelRotationWorkspace> LOCAL = new ThreadLocal<>();
    private Matrix3f matrix;
    private Vector3f vector;
    private int depth;
    private boolean matrixClaimed;
    private boolean vectorClaimed;
    private boolean poisoned;
    private int outerCallsSinceFlush;
    private long completedJobs;
    private long matricesReused;
    private long vectorsReused;

    private ModelRotationWorkspace() { }

    public static boolean inScope() {
        ModelRotationWorkspace workspace = LOCAL.get();
        return workspace != null && workspace.depth != 0;
    }

    public static ModelRotationWorkspace enter() {
        ModelRotationWorkspace workspace = LOCAL.get();
        if (workspace == null) {
            workspace = new ModelRotationWorkspace();
            LOCAL.set(workspace);
        }
        if (++workspace.depth == 1) {
            workspace.matrixClaimed = false;
            workspace.vectorClaimed = false;
            workspace.poisoned = false;
        }
        return workspace;
    }

    private static ModelRotationWorkspace active() {
        ModelRotationWorkspace workspace = LOCAL.get();
        return workspace != null && workspace.depth == 1 && !workspace.poisoned
                && AstFPSRuntime.MODEL_ROTATION_SCRATCH.enabled() ? workspace : null;
    }

    public void poison() {
        poisoned = true;
    }

    public void complete() {
        completedJobs++;
    }

    /** Diagnosis flushes the calling thread; other workers may have up to 63 unreported outer calls. */
    public static void flushCurrentThreadCounters() {
        ModelRotationWorkspace workspace = LOCAL.get();
        if (workspace != null) workspace.flushCounters();
    }

    private void flushCounters() {
        if (completedJobs != 0) AstFPSRuntime.modelRotationJobs.add(completedJobs);
        if (matricesReused != 0) AstFPSRuntime.modelRotationMatricesReused.add(matricesReused);
        if (vectorsReused != 0) AstFPSRuntime.modelRotationVectorsReused.add(vectorsReused);
        completedJobs = matricesReused = vectorsReused = 0;
        outerCallsSinceFlush = 0;
    }

    public void leave() {
        if (--depth != 0) return;
        if (poisoned) {
            matrix = null;
            vector = null;
        }
        matrixClaimed = false;
        vectorClaimed = false;
        if (++outerCallsSinceFlush >= 64 || poisoned) flushCounters();
    }

    public static Matrix3f matrix(Operation<Matrix3f> original) {
        ModelRotationWorkspace workspace = active();
        if (workspace == null || workspace.matrixClaimed) return original.call();
        workspace.matrixClaimed = true;
        if (workspace.matrix != null) {
            workspace.matrix.identity();
            workspace.matricesReused++;
            return workspace.matrix;
        }
        Matrix3f created = original.call();
        // Preserve a cooperating constructor wrapper's substituted implementation or initial value.
        if (created != null && created.getClass() == Matrix3f.class && nativeIdentity(created)) {
            workspace.matrix = created;
        }
        return created;
    }

    public static Vector3f vector(Operation<Vector3f> original) {
        ModelRotationWorkspace workspace = active();
        if (workspace == null || workspace.vectorClaimed) return original.call();
        workspace.vectorClaimed = true;
        if (workspace.vector != null) {
            workspace.vector.zero();
            workspace.vectorsReused++;
            return workspace.vector;
        }
        Vector3f created = original.call();
        if (created != null && created.getClass() == Vector3f.class
                && Float.floatToRawIntBits(created.x) == 0
                && Float.floatToRawIntBits(created.y) == 0
                && Float.floatToRawIntBits(created.z) == 0) {
            workspace.vector = created;
        }
        return created;
    }

    private static boolean nativeIdentity(Matrix3f value) {
        return Float.floatToRawIntBits(value.m00()) == 0x3f800000
                && Float.floatToRawIntBits(value.m11()) == 0x3f800000
                && Float.floatToRawIntBits(value.m22()) == 0x3f800000
                && Float.floatToRawIntBits(value.m01()) == 0
                && Float.floatToRawIntBits(value.m02()) == 0
                && Float.floatToRawIntBits(value.m10()) == 0
                && Float.floatToRawIntBits(value.m12()) == 0
                && Float.floatToRawIntBits(value.m20()) == 0
                && Float.floatToRawIntBits(value.m21()) == 0;
    }
}
