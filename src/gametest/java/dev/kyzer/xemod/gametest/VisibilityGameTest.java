package dev.kyzer.xemod.gametest;

import dev.kyzer.xemod.HookAudit;
import dev.kyzer.xemod.client.XeClient;
import dev.kyzer.xemod.client.XeRuntime;
import java.util.Random;
import net.fabricmc.fabric.api.client.gametest.v1.FabricClientGameTest;
import net.fabricmc.fabric.api.client.gametest.v1.context.ClientGameTestContext;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.world.phys.AABB;
import org.joml.Matrix4f;

/** Exercises transformed game classes; these checks are not an FPS benchmark. */
public final class VisibilityGameTest implements FabricClientGameTest {
    @Override public void runTest(ClientGameTestContext context) {
        context.runOnClient(client -> {
            var random = new Random(5600);
            Matrix4f projection = new Matrix4f().perspective((float) Math.toRadians(85), 16f / 9f, 0.05f, 512);
            Frustum frustum = new Frustum(new Matrix4f(), projection);
            for (int camera = 0; camera < 12; camera++) {
                double origin = camera * 0.375;
                frustum.prepare(origin, camera * -0.25, camera * 0.5);
                for (int i = 0; i < 500; i++) {
                    double x = random.nextDouble() * 800 - 400;
                    double y = random.nextDouble() * 200 - 100;
                    double z = random.nextDouble() * 1000 - 500;
                    AABB box = new AABB(x, y, z, x + 0.5 + random.nextDouble() * 24, y + 2, z + 3);
                    compare(frustum, box, "camera=" + camera + " box=" + i);
                    compare(frustum, box.inflate(0.01), "expanded bounds");
                }
                // Prime before each mutator, then compare without changing the frame epoch.
                AABB edge = new AABB(-1, -1, -10, 1, 1, -9);
                XeRuntime.VISIBILITY_MEMO.enable(!XeRuntime.safeMode());
                frustum.isVisible(edge);
                frustum.prepare(origin + 1000, 0, 0);
                boolean actual = frustum.isVisible(edge);
                XeRuntime.VISIBILITY_MEMO.enable(false);
                require(actual == frustum.isVisible(edge), "camera invalidation");

                XeRuntime.VISIBILITY_MEMO.enable(!XeRuntime.safeMode());
                frustum.isVisible(edge);
                frustum.set(new Frustum(new Matrix4f().rotateY(0.7f), projection));
                actual = frustum.isVisible(edge);
                XeRuntime.VISIBILITY_MEMO.enable(false);
                require(actual == frustum.isVisible(edge), "frustum replacement invalidation");

                XeRuntime.VISIBILITY_MEMO.enable(!XeRuntime.safeMode());
                frustum.isVisible(edge);
                frustum.offsetToFullyIncludeCameraCube(8);
                actual = frustum.isVisible(edge);
                XeRuntime.VISIBILITY_MEMO.enable(false);
                require(actual == frustum.isVisible(edge), "camera cube invalidation");
            }
            require(XeRuntime.VISIBILITY_MEMO.failure() == null, "feature threw an exception");
            if (!XeRuntime.safeMode()) require(XeRuntime.visibilityHits > 0, "visibility hook did not reuse any result");
            var receipts = HookAudit.snapshot();
            String state = receipts.get("dev.kyzer.xemod.client.mixin.FrustumMemoMixin");
            require(state != null && state.contains(XeRuntime.safeMode() ? "disabled" : "applied"), "missing frustum hook receipt");
            XeClient.RECORDER.start();
        });
        long before = context.computeOnClient(client -> XeRuntime.frameEpoch);
        context.waitTicks(4);
        context.runOnClient(client -> {
            require(XeRuntime.frameEpoch > before, "frame hook did not run");
            require(XeClient.RECORDER.stop().intervals().length > 0, "frame recorder did not capture running game");
            System.out.println("XE-CLIENT-CHECKS-PASSED safeMode=" + XeRuntime.safeMode() + " hits=" + XeRuntime.visibilityHits);
        });
    }

    private static void compare(Frustum frustum, AABB box, String stage) {
        XeRuntime.VISIBILITY_MEMO.enable(false);
        boolean expected = frustum.isVisible(box);
        XeRuntime.frameEpoch++;
        XeRuntime.VISIBILITY_MEMO.enable(!XeRuntime.safeMode());
        boolean first = frustum.isVisible(box);
        boolean repeated = frustum.isVisible(box);
        require(expected == first && expected == repeated, "visibility disagreement: " + stage);
    }

    private static void require(boolean condition, String stage) {
        if (!condition) throw new AssertionError("Xe-Mod: " + stage);
    }
}
