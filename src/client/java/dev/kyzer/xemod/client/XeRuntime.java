package dev.kyzer.xemod.client;

import dev.kyzer.xemod.FeatureGate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class XeRuntime {
    private XeRuntime() { }
    public static final FeatureGate VISIBILITY_MEMO = new FeatureGate("visibility-memo");
    private static final Logger LOGGER = LoggerFactory.getLogger("Xe-Mod");
    public static boolean safeMode() { return Boolean.getBoolean("xe.safeMode"); }
    public static void memoFailure(String stage, RuntimeException error) {
        VISIBILITY_MEMO.disableAfterFailure(stage, error);
        LOGGER.error("XE-FEATURE-DISABLED visibility-memo stage={} -- vanilla fallback retained; /xe diagnose", stage, error);
    }
    public static volatile long frameEpoch;
    public static long visibilityHits;
    public static long visibilityMisses;
}
