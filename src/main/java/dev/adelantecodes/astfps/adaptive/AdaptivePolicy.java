package dev.adelantecodes.astfps.adaptive;

/** Pure, vendor-neutral controller for renderer work and cache pressure. */
public final class AdaptivePolicy {
    public enum Tier { CONSERVATIVE, BALANCED, THROUGHPUT }
    public record Snapshot(Tier tier, long frameBudgetNanos, int chunkJobsPerFrame,
                           int chunkQueueLimit, int cacheScalePercent, boolean memoryPressure,
                           double frameMillis, double gpuUtilization) { }

    private static final long TARGET_NANOS = 16_666_667L;
    private double frameNanosEwma = TARGET_NANOS;
    private double gpuEwma = Double.NaN;
    private int pressureScore;
    private int reliefScore;
    private Tier tier = Tier.BALANCED;
    private double chunkCostNanos = 750_000.0;
    private boolean initialized;
    private Snapshot snapshot = make(false, Runtime.getRuntime().availableProcessors(), 0, 0.0);

    public synchronized Snapshot sample(long frameNanos, double gpuPercent, long usedHeap,
                                        long maxHeap, int processors, int chunkBacklog) {
        if (!initialized) {
            initialized = true;
            if (processors <= 4 || (maxHeap > 1_048_576L && maxHeap < 1_610_612_736L))
                tier = Tier.CONSERVATIVE;
            else if (processors >= 12 && maxHeap >= 6_442_450_944L)
                tier = Tier.THROUGHPUT;
        }
        if (frameNanos >= 1_000_000L && frameNanos <= 1_000_000_000L)
            frameNanosEwma += (frameNanos - frameNanosEwma) * 0.0625;
        if (Double.isFinite(gpuPercent) && gpuPercent > 0 && gpuPercent <= 200)
            gpuEwma = Double.isFinite(gpuEwma) ? gpuEwma + (gpuPercent - gpuEwma) * 0.0625 : gpuPercent;
        boolean memoryPressure = maxHeap > 0 && usedHeap * 100L / maxHeap >= 82;
        boolean overloaded = memoryPressure || frameNanosEwma > 22_000_000.0
            || (Double.isFinite(gpuEwma) && gpuEwma > 94.0) || chunkBacklog > Math.max(24, processors * 6);
        boolean relieved = !memoryPressure && frameNanosEwma < 13_500_000.0
            && (!Double.isFinite(gpuEwma) || gpuEwma < 75.0) && chunkBacklog < Math.max(8, processors * 2);
        pressureScore = overloaded ? Math.min(240, pressureScore + 2) : Math.max(0, pressureScore - 1);
        reliefScore = relieved ? Math.min(600, reliefScore + 1) : Math.max(0, reliefScore - 2);
        if (pressureScore >= 30) {
            tier = tier == Tier.THROUGHPUT ? Tier.BALANCED : Tier.CONSERVATIVE;
            pressureScore = 0; reliefScore = 0;
        } else if (reliefScore >= 180) {
            tier = tier == Tier.CONSERVATIVE ? Tier.BALANCED : Tier.THROUGHPUT;
            reliefScore = 0; pressureScore = 0;
        }
        snapshot = make(memoryPressure, Math.max(1, processors), Math.max(0, chunkBacklog), gpuEwma);
        return snapshot;
    }

    public synchronized Snapshot snapshot() { return snapshot; }

    public synchronized void recordChunkCompile(long elapsedNanos) {
        if (elapsedNanos >= 50_000L && elapsedNanos <= 5_000_000_000L)
            chunkCostNanos += (elapsedNanos - chunkCostNanos) * 0.0625;
    }

    private Snapshot make(boolean memoryPressure, int processors, int backlog, double gpu) {
        int cpuLimit = switch (tier) {
            case CONSERVATIVE -> Math.max(1, processors / 3);
            case BALANCED -> Math.max(2, processors / 2);
            case THROUGHPUT -> Math.max(4, processors);
        };
        if (memoryPressure) cpuLimit = Math.max(1, cpuLimit / 2);
        int queue = switch (tier) {
            case CONSERVATIVE -> Math.max(4, processors);
            case BALANCED -> Math.max(8, processors * 2);
            case THROUGHPUT -> Math.max(16, processors * 4);
        };
        int cache = memoryPressure ? 25 : switch (tier) {
            case CONSERVATIVE -> 50;
            case BALANCED -> 100;
            case THROUGHPUT -> 150;
        };
        long spare = Math.max(500_000L, (long) (TARGET_NANOS - frameNanosEwma));
        long budget = Math.min(switch (tier) {
            case CONSERVATIVE -> 750_000L;
            case BALANCED -> 1_750_000L;
            case THROUGHPUT -> 3_500_000L;
        }, spare);
        int base = Math.max(1, Math.min(cpuLimit, (int) Math.max(1, budget / Math.max(50_000.0, chunkCostNanos))));
        return new Snapshot(tier, budget, Math.min(base, Math.max(1, queue - backlog)), queue,
            cache, memoryPressure, frameNanosEwma / 1_000_000.0, gpu);
    }
}
