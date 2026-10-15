package dev.adelantecodes.astfps;

import dev.adelantecodes.astfps.framegen.FrameGenerationPacer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

final class FrameGenerationPacerTest {
    private static FrameGenerationPacer stableAt(long nanos) {
        var pacer = new FrameGenerationPacer();
        for (int i = 0; i < 40; i++) pacer.recordNativeFrame(nanos);
        return pacer;
    }

    @Test void supportsTwoAndFourTimesModes() {
        var pacer = stableAt(10_000_000);
        assertEquals(1, pacer.decide(FrameGenerationPacer.Request.X2, true, 0.10).generatedFrames());
        assertEquals(3, pacer.decide(FrameGenerationPacer.Request.X4, true, 0.10).generatedFrames());
    }

    @Test void autoChoosesMultiplierFromHeadroom() {
        var pacer = stableAt(10_000_000);
        assertEquals(3, pacer.decide(FrameGenerationPacer.Request.AUTO, true, 0.40).generatedFrames());
        assertEquals(1, pacer.decide(FrameGenerationPacer.Request.AUTO, true, 0.75).generatedFrames());
    }

    @Test void suspendsForLowRateUnsupportedAndCameraCuts() {
        assertEquals(FrameGenerationPacer.Suspension.LOW_BASE_RATE,
            stableAt(25_000_000).decide(FrameGenerationPacer.Request.X2, true, 0.10).suspension());
        assertEquals(FrameGenerationPacer.Suspension.UNSUPPORTED,
            stableAt(10_000_000).decide(FrameGenerationPacer.Request.X2, false, 0.10).suspension());
        var pacer = stableAt(10_000_000); pacer.cameraCut();
        assertEquals(FrameGenerationPacer.Suspension.CAMERA_CUT,
            pacer.decide(FrameGenerationPacer.Request.X2, true, 0.10).suspension());
        assertEquals(FrameGenerationPacer.Suspension.NONE,
            pacer.decide(FrameGenerationPacer.Request.X2, true, 0.10).suspension());
    }

    @Test void requiresStableSamplesAndGpuHeadroom() {
        var pacer = new FrameGenerationPacer();
        pacer.recordNativeFrame(10_000_000);
        assertEquals(FrameGenerationPacer.Suspension.UNSTABLE,
            pacer.decide(FrameGenerationPacer.Request.X2, true, 0.10).suspension());
        assertEquals(FrameGenerationPacer.Suspension.NO_GPU_HEADROOM,
            stableAt(10_000_000).decide(FrameGenerationPacer.Request.X2, true, 0.93).suspension());
        assertEquals(1, stableAt(10_000_000)
            .decide(FrameGenerationPacer.Request.X2, true, Double.NaN).generatedFrames());
    }

    @Test void acceptsSubMillisecondRealRenderSamplesOnFastHardware() {
        var decision = stableAt(500_000).decide(FrameGenerationPacer.Request.X4, true, 0.20);
        assertEquals(FrameGenerationPacer.Suspension.NONE, decision.suspension());
        assertEquals(3, decision.generatedFrames());
    }
}
