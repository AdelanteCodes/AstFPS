package dev.adelantecodes.astfps.client;

import dev.adelantecodes.astfps.FeatureGate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.fabricmc.loader.api.FabricLoader;
import java.util.concurrent.atomic.LongAdder;

public final class AstFPSRuntime {
    private AstFPSRuntime() { }
    public static final FeatureGate VISIBILITY_MEMO = new FeatureGate("visibility-memo");
    public static final FeatureGate TERRAIN_BATCHER = new FeatureGate("terrain-batcher");
    public static final FeatureGate SECTION_WORKER_CACHE = new FeatureGate("section-worker-cache");
    public static final LongAdder sectionCacheJobs = new LongAdder();
    public static final LongAdder sectionModelHelpersAllocated = new LongAdder();
    public static final LongAdder sectionModelHelpersReused = new LongAdder();
    public static final LongAdder sectionFluidHelpersAllocated = new LongAdder();
    public static final LongAdder sectionFluidHelpersReused = new LongAdder();
    private static final Logger LOGGER = LoggerFactory.getLogger("AstFPS");
    public static boolean safeMode() { return Boolean.getBoolean("astfps.safeMode"); }
    public static boolean memoHooksAvailable() { return !safeMode() && Boolean.getBoolean("astfps.enableVisibilityMemo"); }
    public static boolean terrainHooksAvailable() {
        return !safeMode() && Boolean.getBoolean("astfps.enableTerrainBatcher") && rendererConflict() == null;
    }
    public static boolean sectionCacheHooksAvailable() {
        return !safeMode() && Boolean.getBoolean("astfps.enableSectionWorkerCache") && rendererConflict() == null;
    }
    public static void sectionCacheFailure(String stage, RuntimeException error) {
        SECTION_WORKER_CACHE.disableAfterFailure(stage, error);
        LOGGER.error("ASTFPS-FEATURE-DISABLED section-worker-cache stage={} -- subsequent jobs use fresh helpers; original compile error preserved", stage, error);
    }
    public static String rendererConflict() {
        for (String id : new String[]{"sodium", "iris", "nvidium", "vulkanmod", "vulkanflow", "meshelium"}) {
            if (FabricLoader.getInstance().isModLoaded(id)) return id;
        }
        return null;
    }
    public static long terrainBatchFrames;
    public static long terrainDirectFrames;
    public static long terrainIndirectFrames;
    public static long terrainCommandRecordsAllocated;
    public static long terrainCommandRecordsReused;
    public static long terrainSectionInfosAllocated;
    public static long terrainSectionInfosReused;
    public static long terrainSectionDraws;
    public static long terrainGpuBatches;
    public static long terrainFallbacks;
    public static void terrainFailure(String stage, RuntimeException error) {
        TERRAIN_BATCHER.disableAfterFailure(stage, error);
        terrainFallbacks++;
        LOGGER.error("ASTFPS-FEATURE-DISABLED terrain-batcher stage={} -- vanilla submission retained; /astfps diagnose", stage, error);
    }
    public static void memoFailure(String stage, RuntimeException error) {
        VISIBILITY_MEMO.disableAfterFailure(stage, error);
        LOGGER.error("ASTFPS-FEATURE-DISABLED visibility-memo stage={} -- vanilla fallback retained; /astfps diagnose", stage, error);
    }
    public static volatile long frameEpoch;
    public static long visibilityHits;
    public static long visibilityMisses;
    public static long worldTargetCleanups;
    public static long releasedTargetReferences;
}
