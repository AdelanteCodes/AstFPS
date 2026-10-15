package dev.adelantecodes.astfps.client.render;

import dev.adelantecodes.astfps.framegen.FrameGenerationPacer;
import dev.adelantecodes.astfps.framegen.PresentationSchedule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Live frame-generation contract. Presentation remains disabled until its renderer is complete. */
public final class FrameGenerationController {
    private static final Logger LOGGER = LoggerFactory.getLogger("AstFPS-FrameGen");
    public enum Mode {
        OFF("Off"), AUTO("Auto"), X2("2x"), X4("4x");
        private final String label;
        Mode(String label) { this.label = label; }
        public String label() { return label; }
        public Mode next() { return values()[(ordinal() + 1) % values().length]; }
    }

    private static volatile Mode requested = Mode.OFF;
    private static final FrameGenerationPacer PACER = new FrameGenerationPacer();
    private static volatile FrameGenerationPacer.Decision decision =
        new FrameGenerationPacer.Decision(0, FrameGenerationPacer.Suspension.UNSUPPORTED, 0);
    private static volatile boolean historyAvailable;
    private static final PresentationSchedule SCHEDULE = new PresentationSchedule();
    private static volatile boolean compositorSupported;
    private static volatile boolean environmentAllowed;
    private static volatile String compositorFailure;
    private static volatile PresentationSchedule.Presentation presentation = PresentationSchedule.Presentation.real();
    private static long metricWindow = System.nanoTime();
    private static int realInWindow, generatedInWindow;
    private static volatile int measuredNativeFps, measuredGeneratedFps;

    private FrameGenerationController() { }

    public static Mode requested() { return requested; }
    public static void request(Mode mode) {
        requested = mode == null ? Mode.OFF : mode;
    }
    public static boolean active() {
        return environmentAllowed && compositorFailure == null && compositorSupported
            && decision.suspension() == FrameGenerationPacer.Suspension.NONE;
    }
    public static boolean captureRequested() { return requested != Mode.OFF; }
    public static boolean canPreflight() { return compositorFailure == null; }
    public static String failure() { return compositorFailure; }
    public static FrameGenerationPacer.Decision decision() { return decision; }
    public static void historyAvailable(boolean value) { historyAvailable = value; }
    public static void environmentAllowed(boolean value) {
        environmentAllowed = value;
        if (!value) {
            SCHEDULE.reset();
            presentation = PresentationSchedule.Presentation.real();
        }
    }
    public static void frameStart(double gpuUtilizationPercent) {
        double gpuUtilizationFraction = Double.isFinite(gpuUtilizationPercent) && gpuUtilizationPercent > 0
            ? gpuUtilizationPercent / 100.0 : Double.NaN;
        decision = PACER.decide(switch (requested) {
            case OFF -> FrameGenerationPacer.Request.OFF;
            case AUTO -> FrameGenerationPacer.Request.AUTO;
            case X2 -> FrameGenerationPacer.Request.X2;
            case X4 -> FrameGenerationPacer.Request.X4;
        }, compositorSupported, gpuUtilizationFraction);
        if (dev.adelantecodes.astfps.client.V1Features.latency() == dev.adelantecodes.astfps.client.V1Features.LatencyMode.LOW && decision.generatedFrames() > 1)
            decision = new FrameGenerationPacer.Decision(1, decision.suspension(), decision.nativeFps());
    }
    public static PresentationSchedule.Presentation beginPresentation() {
        if (!active()) {
            SCHEDULE.reset();
            presentation = PresentationSchedule.Presentation.real();
        } else {
            presentation = SCHEDULE.begin();
        }
        if (!presentation.renderRealWorld()) generatedInWindow++;
        publishMetrics();
        return presentation;
    }
    public static boolean renderRealWorldThisPresentation() { return presentation.renderRealWorld(); }
    public static void realFrameCaptured() {
        if (active() && historyAvailable) SCHEDULE.afterRealFrame(decision.generatedFrames());
        else SCHEDULE.reset();
    }
    /** Records real renderer cost only; real-to-real wall time also contains our synthetic frames. */
    public static void realFrameRendered(long renderNanos) {
        PACER.recordNativeFrame(renderNanos);
        realInWindow++;
        publishMetrics();
    }
    public static void compositorReady() {
        if (compositorFailure == null) compositorSupported = true;
    }
    public static void compositorFailure(Throwable error) {
        compositorSupported = false;
        SCHEDULE.reset();
        if (compositorFailure == null) {
            String message = error == null ? null : error.getMessage();
            compositorFailure = error == null ? "unknown compositor failure"
                : error.getClass().getSimpleName() + (message == null || message.isBlank() ? "" : ": " + message);
            LOGGER.error("Frame generation disabled for this session: {}", compositorFailure, error);
        }
    }
    public static void cameraCut() {
        PACER.cameraCut();
        SCHEDULE.reset();
    }
    public static String status() {
        return requested == Mode.OFF ? "Frame Generation: Off"
            : compositorFailure != null ? "Frame Generation disabled for this session: " + compositorFailure
            : !environmentAllowed ? "Frame Generation " + requested.label() + " paused outside gameplay"
            : "Frame Generation " + requested.label() + " requested; history "
                + (historyAvailable ? "ready" : "warming up") + "; suspended: "
                + decision.suspension().name().toLowerCase().replace('_', ' ');
    }
    public static int measuredNativeFps() { return measuredNativeFps; }
    public static int measuredGeneratedFps() { return measuredGeneratedFps; }
    public static int measuredDisplayedFps() { return measuredNativeFps + measuredGeneratedFps; }
    private static void publishMetrics() {
        long now=System.nanoTime(); long elapsed=now-metricWindow;
        if(elapsed<1_000_000_000L)return;
        measuredNativeFps=(int)Math.round(realInWindow*1_000_000_000.0/elapsed);
        measuredGeneratedFps=(int)Math.round(generatedInWindow*1_000_000_000.0/elapsed);
        realInWindow=0;generatedInWindow=0;metricWindow=now;
    }
}
