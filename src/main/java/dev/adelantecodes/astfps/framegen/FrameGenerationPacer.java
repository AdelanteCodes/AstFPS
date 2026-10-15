package dev.adelantecodes.astfps.framegen;

/** Pure pacing policy shared by every vendor backend; it never counts generated frames as native. */
public final class FrameGenerationPacer {
    public enum Request { OFF, AUTO, X2, X4 }
    public enum Suspension { NONE, DISABLED, UNSUPPORTED, LOW_BASE_RATE, UNSTABLE, NO_GPU_HEADROOM, CAMERA_CUT }
    public record Decision(int generatedFrames, Suspension suspension, double nativeFps) { }

    // Fast GPUs can render a low-distance Minecraft frame in well under 1 ms.
    private static final long MIN_FRAME_NANOS = 100_000L;
    private static final long MAX_FRAME_NANOS = 1_000_000_000L;
    private static final double MIN_BASE_FPS = 45.0;
    private static final int STABLE_SAMPLES = 30;
    private double frameNanosEwma;
    private double deviationNanosEwma;
    private int samples;
    private boolean cameraCut;

    public void recordNativeFrame(long frameNanos) {
        if (frameNanos < MIN_FRAME_NANOS || frameNanos > MAX_FRAME_NANOS) {
            samples = 0;
            return;
        }
        if (samples == 0) {
            frameNanosEwma = frameNanos;
            deviationNanosEwma = 0;
        } else {
            double difference = frameNanos - frameNanosEwma;
            frameNanosEwma += difference * 0.125;
            deviationNanosEwma += (Math.abs(difference) - deviationNanosEwma) * 0.125;
        }
        samples++;
    }

    public void cameraCut() { cameraCut = true; }

    public Decision decide(Request request, boolean supported, double gpuUtilizationFraction) {
        double nativeFps = frameNanosEwma <= 0 ? 0 : 1_000_000_000.0 / frameNanosEwma;
        if (request == Request.OFF) return new Decision(0, Suspension.DISABLED, nativeFps);
        if (!supported) return new Decision(0, Suspension.UNSUPPORTED, nativeFps);
        if (cameraCut) {
            cameraCut = false;
            return new Decision(0, Suspension.CAMERA_CUT, nativeFps);
        }
        if (samples < STABLE_SAMPLES || deviationNanosEwma > frameNanosEwma * 0.15)
            return new Decision(0, Suspension.UNSTABLE, nativeFps);
        if (nativeFps < MIN_BASE_FPS) return new Decision(0, Suspension.LOW_BASE_RATE, nativeFps);
        // Timer queries are not available on every compatible backend. Manual modes remain usable
        // when the signal is unknown, but a known saturated GPU must not be overloaded further.
        if (Double.isFinite(gpuUtilizationFraction) && gpuUtilizationFraction > 0.92)
            return new Decision(0, Suspension.NO_GPU_HEADROOM, nativeFps);
        int generated = switch (request) {
            case X2 -> 1;
            case X4 -> 3;
            case AUTO -> Double.isFinite(gpuUtilizationFraction)
                && gpuUtilizationFraction <= 0.55 && nativeFps >= 60.0 ? 3 : 1;
            case OFF -> 0;
        };
        return new Decision(generated, Suspension.NONE, nativeFps);
    }

    public void reset() {
        frameNanosEwma = 0;
        deviationNanosEwma = 0;
        samples = 0;
        cameraCut = false;
    }
}
