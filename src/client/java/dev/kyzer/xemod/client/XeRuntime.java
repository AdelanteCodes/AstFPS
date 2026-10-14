package dev.kyzer.xemod.client;

import dev.kyzer.xemod.FeatureGate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.fabricmc.loader.api.FabricLoader;

public final class XeRuntime {
    private XeRuntime() { }
    public static final FeatureGate VISIBILITY_MEMO = new FeatureGate("visibility-memo");
    public static final FeatureGate TERRAIN_BATCHER = new FeatureGate("terrain-batcher");
    private static final Logger LOGGER = LoggerFactory.getLogger("Xe-Mod");
    public static boolean safeMode() { return Boolean.getBoolean("xe.safeMode"); }
    public static boolean memoHooksAvailable() { return !safeMode() && Boolean.getBoolean("xe.enableVisibilityMemo"); }
    public static boolean terrainHooksAvailable() {
        return !safeMode() && Boolean.getBoolean("xe.enableTerrainBatcher") && rendererConflict() == null;
    }
    public static String rendererConflict() {
        for (String id : new String[]{"sodium", "iris", "nvidium", "vulkanmod", "vulkanflow", "meshelium"}) {
            if (FabricLoader.getInstance().isModLoaded(id)) return id;
        }
        return null;
    }
    public static long terrainBatchFrames;
    public static long terrainSectionDraws;
    public static long terrainGpuBatches;
    public static long terrainFallbacks;
    public static void terrainFailure(String stage, RuntimeException error) {
        TERRAIN_BATCHER.disableAfterFailure(stage, error);
        terrainFallbacks++;
        LOGGER.error("XE-FEATURE-DISABLED terrain-batcher stage={} -- vanilla submission retained; /xe diagnose", stage, error);
    }
    public static void memoFailure(String stage, RuntimeException error) {
        VISIBILITY_MEMO.disableAfterFailure(stage, error);
        LOGGER.error("XE-FEATURE-DISABLED visibility-memo stage={} -- vanilla fallback retained; /xe diagnose", stage, error);
    }
    public static volatile long frameEpoch;
    public static long visibilityHits;
    public static long visibilityMisses;
    public static long worldTargetCleanups;
    public static long releasedTargetReferences;
}
