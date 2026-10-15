package dev.adelantecodes.astfps;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/** Optional sampled method-wall timings. These are neither GPU timestamps nor thread CPU time. */
public final class StageTimings {
    public enum Stage { SECTION_COMPILE, TERRAIN_DIRECT, TERRAIN_INDIRECT }
    public record Sample(long session, long started) { }
    private static final int SAMPLE_EVERY = 64;
    private static final int WINDOW = 2_048;
    private static final boolean AVAILABLE = Boolean.getBoolean("astfps.profileStages")
            && !Boolean.getBoolean("astfps.safeMode");
    private static final Bucket[] BUCKETS = new Bucket[AVAILABLE ? Stage.values().length : 0];
    private static final ThreadLocal<int[]> SEQUENCES = ThreadLocal.withInitial(() -> new int[Stage.values().length]);
    private static volatile long session;
    private static volatile boolean capturing;
    static { for (int i = 0; i < BUCKETS.length; i++) BUCKETS[i] = new Bucket(); }
    private StageTimings() { }
    public static boolean available() { return AVAILABLE; }
    public static void stopCapturing() { capturing = false; }

    public static synchronized void start() {
        capturing = false;
        session++;
        for (Bucket bucket : BUCKETS) bucket.reset();
        capturing = AVAILABLE;
    }

    public static Sample begin(Stage stage) {
        if (!AVAILABLE || !capturing) return null;
        long observedSession = session;
        int[] sequences = SEQUENCES.get();
        if ((++sequences[stage.ordinal()] & (SAMPLE_EVERY - 1)) != 0) return null;
        return new Sample(observedSession, System.nanoTime());
    }

    public static void end(Stage stage, Sample sample, boolean successful) {
        if (sample == null) return;
        long elapsed = System.nanoTime() - sample.started();
        if (elapsed <= 0 || !capturing || sample.session() != session) return;
        BUCKETS[stage.ordinal()].record(sample.session(), elapsed, successful);
    }

    public static synchronized Map<String, Object> snapshot(boolean stop) {
        if (stop) capturing = false;
        var report = new LinkedHashMap<String, Object>();
        report.put("available", AVAILABLE);
        report.put("capturing", capturing);
        report.put("sampleEveryCallsPerThread", SAMPLE_EVERY);
        report.put("measurement", "Sampled method elapsed wall time; includes waits, not GPU timing or exclusive thread CPU time. Worker compile timings overlap render work. Nested stages are not additive.");
        if (AVAILABLE) {
            for (Stage stage : Stage.values()) report.put(stage.name(), BUCKETS[stage.ordinal()].snapshot());
        }
        return report;
    }

    private static final class Bucket {
        private final long[] samples = new long[WINDOW];
        private long ownerSession;
        private long count, failed;
        private double totalNanos;
        private long maximum;
        private int cursor, size;
        synchronized void reset() {
            ownerSession = session;
            count = failed = maximum = 0;
            totalNanos = 0;
            cursor = size = 0;
        }
        synchronized void record(long sampleSession, long elapsed, boolean successful) {
            // Recheck while holding the same lock used by reset; previous captures cannot contaminate a new one.
            if (ownerSession != sampleSession || session != sampleSession || !capturing) return;
            count++;
            if (!successful) failed++;
            totalNanos += elapsed;
            maximum = Math.max(maximum, elapsed);
            samples[cursor] = elapsed;
            cursor = (cursor + 1) % WINDOW;
            size = Math.min(size + 1, WINDOW);
        }
        synchronized Map<String, Object> snapshot() {
            long[] sorted = Arrays.copyOf(samples, size);
            Arrays.sort(sorted);
            var result = new LinkedHashMap<String, Object>();
            result.put("sampledCalls", count);
            result.put("sampledFailures", failed);
            result.put("meanMillis", count == 0 ? 0.0 : totalNanos / count / 1_000_000.0);
            result.put("maximumMillis", maximum / 1_000_000.0);
            result.put("recentWindowSamples", size);
            result.put("recentP50Millis", percentile(sorted, 0.50));
            result.put("recentP95Millis", percentile(sorted, 0.95));
            result.put("recentP99Millis", percentile(sorted, 0.99));
            return result;
        }
        private static double percentile(long[] sorted, double fraction) {
            if (sorted.length == 0) return 0;
            return sorted[Math.max(0, (int) Math.ceil(fraction * sorted.length) - 1)] / 1_000_000.0;
        }
    }
}
