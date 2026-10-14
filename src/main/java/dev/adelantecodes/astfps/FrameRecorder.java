package dev.adelantecodes.astfps;

import java.util.Arrays;

/** Render-thread recorder: bounded storage, no allocations on the per-frame path. */
public final class FrameRecorder {
    public static final int CAPACITY = 60_000;
    private long[] intervals;
    private int count;
    private long previous;
    private boolean hasPrevious;
    private boolean recording;
    private boolean capped;

    public void start() {
        if (intervals == null) intervals = new long[CAPACITY];
        count = 0;
        hasPrevious = false;
        capped = false;
        recording = true;
    }

    public void frameStart(long now) {
        if (!recording) return;
        if (hasPrevious) {
            long delta = now - previous;
            if (delta > 0) {
                intervals[count++] = delta;
                if (count == CAPACITY) { recording = false; capped = true; }
            }
        }
        previous = now;
        hasPrevious = true;
    }

    public Snapshot stop() {
        recording = false;
        return new Snapshot(intervals == null ? new long[0] : Arrays.copyOf(intervals, count), capped);
    }

    public boolean isRecording() { return recording; }
    public int count() { return count; }

    public record Snapshot(long[] intervals, boolean capped) { }
}
