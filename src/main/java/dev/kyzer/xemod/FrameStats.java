package dev.kyzer.xemod;

import java.util.Arrays;

/** Statistics over real intervals between frame starts, including pacing. */
public record FrameStats(int samples, double averageFps, double p99Millis, double onePercentLowFps) {
    public static FrameStats calculate(long[] intervals) {
        if (intervals.length == 0) return new FrameStats(0, 0, 0, 0);
        long[] sorted = intervals.clone();
        double total = 0;
        for (long nanos : sorted) {
            if (nanos <= 0) throw new IllegalArgumentException("Frame intervals must be positive");
            total += nanos;
        }
        Arrays.sort(sorted);
        int tailSize = Math.max(1, (int) Math.ceil(sorted.length * 0.01));
        double slowTotal = 0;
        for (int i = sorted.length - tailSize; i < sorted.length; i++) slowTotal += sorted[i];
        int p99Index = Math.min(sorted.length - 1, (int) Math.ceil(sorted.length * 0.99) - 1);
        return new FrameStats(sorted.length, sorted.length * 1_000_000_000.0 / total,
            sorted[p99Index] / 1_000_000.0, tailSize * 1_000_000_000.0 / slowTotal);
    }
}
