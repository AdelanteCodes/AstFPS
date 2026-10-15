package dev.adelantecodes.astfps.client.mixin;

import com.mojang.blaze3d.pipeline.RenderTarget;
import dev.adelantecodes.astfps.client.render.FrameHistoryCapture;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.fog.FogRenderer;
import net.minecraft.client.renderer.state.GameRenderState;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.util.Mth;
import net.minecraft.client.DeltaTracker;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import dev.adelantecodes.astfps.framegen.PresentationSchedule;
import dev.adelantecodes.astfps.client.render.FrameGenerationController;
import dev.adelantecodes.astfps.client.render.FrameInterpolationRenderer;
import dev.adelantecodes.astfps.client.AstFPSRuntime;
import com.mojang.renderpearl.api.device.GpuDevice;

/** Captures post-processed world color immediately before vanilla starts the GUI pass. */
@Mixin(GameRenderer.class)
public abstract class FrameHistoryCaptureMixin {
    @Shadow @Final @Mutable private RenderTarget mainRenderTarget;
    @Shadow @Final private GameRenderState gameRenderState;
    @Shadow @Final private Minecraft minecraft;
    @Unique private final FrameHistoryCapture astfpsFrameHistory = new FrameHistoryCapture();
    @Unique private PresentationSchedule.Presentation astfpsPresentation = PresentationSchedule.Presentation.real();
    @Unique private boolean astfpsOriginalShouldRenderLevel;
    @Unique private boolean astfpsEnvironmentAllowed;
    @Unique private boolean astfpsHistoryCaptureEnabled;
    @Unique private boolean astfpsHaveCameraSample;
    @Unique private double astfpsLastCameraX;
    @Unique private double astfpsLastCameraY;
    @Unique private double astfpsLastCameraZ;
    @Unique private float astfpsLastCameraPitch;
    @Unique private float astfpsLastCameraYaw;

    @WrapMethod(method = "render")
    private void astfpsSchedulePresentation(Operation<Void> original) {
        // A generated presentation must be compositor-only. Calling vanilla render with
        // shouldRenderLevel=false still runs late first-person/post passes; those passes
        // have no freshly extracted world state and can overwrite the interpolated image
        // with black (most visibly the hand, and on some worlds the whole frame).
        if (!astfpsPresentation.renderRealWorld()) {
            try {
                astfpsFrameHistory.interpolate(mainRenderTarget, astfpsPresentation.quarterStep());
                AstFPSRuntime.generatedWorldFramesPresented++;
            } catch (RuntimeException error) {
                FrameGenerationController.compositorFailure(error);
                astfpsFrameHistory.presentCurrent(mainRenderTarget);
            }
            return;
        }
        astfpsOriginalShouldRenderLevel = gameRenderState.shouldRenderLevel;
        long astfpsRealRenderStarted = System.nanoTime();
        try {
            original.call();
        } finally {
            gameRenderState.shouldRenderLevel = astfpsOriginalShouldRenderLevel;
            FrameGenerationController.realFrameRendered(System.nanoTime() - astfpsRealRenderStarted);
        }
    }

    @Inject(method = "extract", at = @At("HEAD"))
    private void astfpsPlanPresentation(DeltaTracker delta, boolean renderLevel, CallbackInfo ci) {
        boolean environment = renderLevel && minecraft.isGameLoadFinished()
            && minecraft.level != null && minecraft.player != null
            && minecraft.gui.screen() == null && minecraft.gui.overlay() == null;
        if (environment != astfpsEnvironmentAllowed) {
            astfpsEnvironmentAllowed = environment;
            astfpsFrameHistory.invalidate();
            astfpsHaveCameraSample = false;
        }
        FrameGenerationController.environmentAllowed(environment);
        astfpsPresentation = FrameGenerationController.beginPresentation();
    }

    @Inject(method = "render", at = @At(value = "INVOKE",
        target = "Lnet/minecraft/client/renderer/fog/FogRenderer;endFrame()V", shift = At.Shift.BEFORE))
    private void astfpsCaptureWorldBeforeGui(CallbackInfo ci) {
        if (astfpsPresentation.renderRealWorld()) {
            if (!astfpsOriginalShouldRenderLevel) return;
            boolean captureEnabled = FrameGenerationController.captureRequested();
            if (captureEnabled != astfpsHistoryCaptureEnabled) {
                astfpsHistoryCaptureEnabled = captureEnabled;
                astfpsFrameHistory.invalidate();
                astfpsHaveCameraSample = false;
            }
            if (captureEnabled) {
                astfpsInvalidateOnCameraCut();
                astfpsFrameHistory.capture(mainRenderTarget);
                if (astfpsFrameHistory.ready() && FrameGenerationController.canPreflight()) {
                    try {
                        FrameInterpolationRenderer.preflight();
                        FrameGenerationController.compositorReady();
                        if (FrameGenerationController.active()) astfpsFrameHistory.presentPrevious(mainRenderTarget);
                    } catch (RuntimeException error) {
                        FrameGenerationController.compositorFailure(error);
                    }
                }
            }
            FrameGenerationController.realFrameCaptured();
            AstFPSRuntime.nativeWorldFramesPresented++;
        }
    }

    @Unique
    private void astfpsInvalidateOnCameraCut() {
        CameraRenderState camera = gameRenderState.levelRenderState.cameraRenderState;
        if (camera == null || !camera.initialized || camera.pos == null) {
            astfpsHaveCameraSample = false;
            return;
        }
        if (astfpsHaveCameraSample) {
            double dx = camera.pos.x - astfpsLastCameraX;
            double dy = camera.pos.y - astfpsLastCameraY;
            double dz = camera.pos.z - astfpsLastCameraZ;
            float pitchDelta = Math.abs(Mth.wrapDegrees(camera.xRot - astfpsLastCameraPitch));
            float yawDelta = Math.abs(Mth.wrapDegrees(camera.yRot - astfpsLastCameraYaw));
            if (dx * dx + dy * dy + dz * dz > 64.0 || pitchDelta > 45.0F || yawDelta > 45.0F) {
                FrameGenerationController.cameraCut();
                astfpsFrameHistory.invalidate();
            }
        }
        astfpsLastCameraX = camera.pos.x;
        astfpsLastCameraY = camera.pos.y;
        astfpsLastCameraZ = camera.pos.z;
        astfpsLastCameraPitch = camera.xRot;
        astfpsLastCameraYaw = camera.yRot;
        astfpsHaveCameraSample = true;
    }

    @Inject(method = "close", at = @At("HEAD"))
    private void astfpsCloseFrameHistory(CallbackInfo ci) {
        astfpsFrameHistory.close();
    }
}
