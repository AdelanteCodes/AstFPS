package dev.kyzer.astfps;

public final class CoreChecks {
    public static void main(String[] args) {
        FrameStats known = FrameStats.calculate(new long[]{10_000_000, 10_000_000, 30_000_000});
        close(known.averageFps(), 60);
        close(known.p99Millis(), 30);
        close(known.onePercentLowFps(), 1000.0 / 30);
        if (FrameStats.calculate(new long[0]).samples() != 0) fail("Empty recording");
        try { FrameStats.calculate(new long[]{0}); fail("Invalid interval accepted"); }
        catch (IllegalArgumentException expected) { }
        FrameRecorder recorder = new FrameRecorder();
        recorder.frameStart(100);
        if (recorder.count() != 0) fail("Recorded while idle");
        recorder.start();
        recorder.frameStart(-100);
        recorder.frameStart(-90);
        recorder.frameStart(-90);
        recorder.frameStart(-80);
        var capture = recorder.stop();
        if (capture.intervals().length != 2 || capture.intervals()[0] != 10) fail("Negative clock origin or zero interval");
        recorder.start();
        for (int i = 0; i <= FrameRecorder.CAPACITY + 5; i++) recorder.frameStart(i);
        var capped = recorder.stop();
        if (!capped.capped() || capped.intervals().length != FrameRecorder.CAPACITY || recorder.isRecording()) fail("Storage cap");
        recorder.start();
        if (recorder.count() != 0 || recorder.stop().capped()) fail("Restart state");
        checkMemo();
        FeatureGate gate = new FeatureGate("test-feature");
        if (!gate.enable(true) || !gate.enabled()) fail("Feature enable");
        gate.disableAfterFailure("test-stage", new IllegalStateException("injected test failure"));
        if (gate.enabled() || gate.enable(true) || !gate.failure().stage().equals("test-stage")) fail("Failure isolation");
        gate.disableAfterFailure("second-stage", new RuntimeException("second"));
        if (!gate.failure().stage().equals("test-stage")) fail("First error was overwritten");
        if (!gate.failure().stackTrace().contains("injected test failure")) fail("Missing error evidence");
        System.out.println("Core checks passed: FPS statistics, recorder lifecycle, memo bounds, epochs, invalidation and thread fallback.");
    }
    private static void close(double actual, double expected) { if (Math.abs(actual - expected) > 0.000001) fail(actual + " != " + expected); }
    private static void fail(String message) { throw new AssertionError(message); }
    private static void checkMemo() {
        VisibilityMemo memo = new VisibilityMemo();
        if (memo.probe(1, 0, 0, 0, 1, 1, 1) != -1) fail("Uninitialized cache");
        memo.store(1, 0, 0, 0, 1, 1, 1, false);
        if (memo.probe(1, 0, 0, 0, 1, 1, 1) != 0) fail("False result not retained");
        if (memo.probe(2, 0, 0, 0, 1, 1, 1) != -1) fail("Stale frame reused");
        if (memo.probe(1, 0, 0, 0, 2, 1, 1) != -1) fail("Changed bounds reused");
        memo.invalidate();
        if (memo.probe(1, 0, 0, 0, 1, 1, 1) != -1) fail("Invalidation failed");
        java.util.Random random = new java.util.Random(2026);
        for (int i = 0; i < 5000; i++) {
            double x = random.nextDouble() * 200 - 100;
            boolean result = x >= 0;
            memo.store(i, x, -1, -1, x + 1, 1, 1, result);
            if (memo.probe(i, x, -1, -1, x + 1, 1, 1) != (result ? 1 : 0)) fail("Result changed");
            if (memo.probe(i, x, -1, -1, x + 1, 2, 1) != -1) fail("One coordinate changed");
        }
        memo.store(99, 0, 0, 0, 1, 1, 1, true);
        Thread other = new Thread(() -> {
            if (memo.probe(99, 0, 0, 0, 1, 1, 1) != -1) fail("Cross-thread reuse");
        });
        try { other.start(); other.join(); } catch (InterruptedException e) { throw new AssertionError(e); }
        if (memo.probe(99, 0, 0, 0, 1, 1, 1) != -1) fail("Shared instance did not fall back");
    }
}
