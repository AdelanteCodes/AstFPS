package dev.adelantecodes.astfps.client;

import dev.adelantecodes.astfps.adaptive.AdaptivePolicy;
import dev.adelantecodes.astfps.adaptive.StutterController;
import java.lang.management.ManagementFactory;

/** Client bridge for the pure adaptive controller. */
public final class AdaptiveRuntime {
    private static final AdaptivePolicy POLICY = new AdaptivePolicy();
    private static long lastFrame;
    private static volatile AdaptivePolicy.Snapshot snapshot = POLICY.snapshot();
    private static final StutterController STUTTERS = new StutterController();
    private static int framesUntilGcPoll;
    private static long gcCollections;

    private AdaptiveRuntime() { }

    public static void frame(double gpuPercent, int chunkBacklog) {
        long now = System.nanoTime();
        long interval = lastFrame == 0 ? 16_666_667L : now - lastFrame;
        lastFrame = now;
        Runtime runtime = Runtime.getRuntime();
        snapshot = POLICY.sample(interval, gpuPercent, runtime.totalMemory() - runtime.freeMemory(),
            runtime.maxMemory(), runtime.availableProcessors(), chunkBacklog);
        if (--framesUntilGcPoll <= 0) {
            framesUntilGcPoll = 30;
            long count = 0;
            for (var collector : ManagementFactory.getGarbageCollectorMXBeans())
                if (collector.getCollectionCount() > 0) count += collector.getCollectionCount();
            gcCollections = count;
        }
        STUTTERS.sample(interval, gpuPercent, chunkBacklog, snapshot.chunkQueueLimit(), gcCollections);
    }

    public static AdaptivePolicy.Snapshot snapshot() { return snapshot; }
    public static void chunkCompile(long elapsedNanos) { POLICY.recordChunkCompile(elapsedNanos); }
    public static StutterController.Snapshot stutters() { return STUTTERS.snapshot(); }
}
