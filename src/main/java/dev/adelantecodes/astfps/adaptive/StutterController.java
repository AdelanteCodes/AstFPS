package dev.adelantecodes.astfps.adaptive;

import java.util.EnumMap;
import java.util.Map;

/** Classifies frame spikes so adaptive responses target the likely source. */
public final class StutterController {
    public enum Cause { GC, CHUNK_BACKLOG, GPU_SATURATION, UNKNOWN }
    public record Snapshot(Cause latest, long latestFrameNanos, Map<Cause, Long> counts) { }
    private final EnumMap<Cause, Long> counts = new EnumMap<>(Cause.class);
    private double baselineNanos = 16_666_667.0;
    private long lastGcCollections;
    private Cause latest;
    private long latestFrameNanos;

    public StutterController() { for (Cause cause : Cause.values()) counts.put(cause, 0L); }

    public synchronized Cause sample(long frameNanos, double gpuPercent, int chunkBacklog,
                                     int chunkQueueLimit, long gcCollections) {
        boolean spike = frameNanos > Math.max(25_000_000.0, baselineNanos * 1.8);
        baselineNanos += (Math.min(frameNanos, 50_000_000L) - baselineNanos) * 0.03125;
        Cause result = null;
        if (spike) {
            if (gcCollections > lastGcCollections) result = Cause.GC;
            else if (chunkBacklog > chunkQueueLimit) result = Cause.CHUNK_BACKLOG;
            else if (Double.isFinite(gpuPercent) && gpuPercent >= 95.0) result = Cause.GPU_SATURATION;
            else result = Cause.UNKNOWN;
            latest = result;
            latestFrameNanos = frameNanos;
            counts.put(result, counts.get(result) + 1);
        }
        lastGcCollections = Math.max(lastGcCollections, gcCollections);
        return result;
    }

    public synchronized Snapshot snapshot() {
        return new Snapshot(latest, latestFrameNanos, Map.copyOf(counts));
    }
}
