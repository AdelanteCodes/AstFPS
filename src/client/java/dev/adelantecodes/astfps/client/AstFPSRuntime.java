package dev.adelantecodes.astfps.client;

import dev.adelantecodes.astfps.FeatureGate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.fabricmc.loader.api.FabricLoader;
import java.util.concurrent.atomic.LongAdder;
import java.util.Set;
import java.util.stream.Collectors;
import dev.adelantecodes.astfps.compat.CompatibilityPolicy;

public final class AstFPSRuntime {
    private AstFPSRuntime() { }
    public static final FeatureGate VISIBILITY_MEMO = new FeatureGate("visibility-memo");
    public static final FeatureGate TERRAIN_BATCHER = new FeatureGate("terrain-batcher");
    public static final FeatureGate SECTION_WORKER_CACHE = new FeatureGate("section-worker-cache");
    public static final FeatureGate SECTION_STATE_CACHE = new FeatureGate("section-state-cache");
    public static final FeatureGate SECTION_MESH_WORKSPACE = new FeatureGate("section-mesh-workspace");
    public static final FeatureGate SECTION_QUAD_FORMAT = new FeatureGate("section-quad-format");
    public static final FeatureGate SECTION_FABRIC_WORKSPACE = new FeatureGate("section-fabric-workspace");
    public static final FeatureGate MODEL_ROTATION_SCRATCH = new FeatureGate("model-rotation-scratch");
    public static final FeatureGate TAB_LIST_CACHE = new FeatureGate("tab-list-cache");
    public static final LongAdder tabCacheHits = new LongAdder();
    public static final LongAdder tabCacheMisses = new LongAdder();
    public static final LongAdder tabCacheBypasses = new LongAdder();
    public static final LongAdder tabCacheInvalidations = new LongAdder();
    public static final LongAdder quadFormatBuildersCached = new LongAdder();
    public static final LongAdder quadFormatElementLookupsAvoided = new LongAdder();
    public static final LongAdder fabricWorkspaceJobs = new LongAdder();
    public static final LongAdder fabricAoHelpersAllocated = new LongAdder();
    public static final LongAdder fabricAoHelpersReused = new LongAdder();
    public static final LongAdder fabricAoHelpersBypassed = new LongAdder();
    public static final LongAdder modelRotationJobs = new LongAdder();
    public static final LongAdder modelRotationMatricesReused = new LongAdder();
    public static final LongAdder modelRotationVectorsReused = new LongAdder();
    public static final LongAdder meshWorkspaceJobs = new LongAdder();
    public static final LongAdder layerMapsReused = new LongAdder();
    public static final LongAdder visibilityBitsetsReused = new LongAdder();
    public static final LongAdder floodQueuesReused = new LongAdder();
    public static final LongAdder sectionStateJobs = new LongAdder();
    public static final LongAdder sectionStateHits = new LongAdder();
    public static final LongAdder sectionStateMisses = new LongAdder();
    public static final LongAdder sectionStateBypasses = new LongAdder();
    public static final LongAdder sectionStateMismatches = new LongAdder();
    public static final LongAdder sectionCacheJobs = new LongAdder();
    public static final LongAdder sectionModelHelpersAllocated = new LongAdder();
    public static final LongAdder sectionModelHelpersReused = new LongAdder();
    public static final LongAdder sectionFluidHelpersAllocated = new LongAdder();
    public static final LongAdder sectionFluidHelpersReused = new LongAdder();
    private static final Logger LOGGER = LoggerFactory.getLogger("AstFPS");
    public static boolean safeMode() { return Boolean.getBoolean("astfps.safeMode"); }
    public static boolean tabCacheHooksAvailable() {
        return !safeMode() && dev.adelantecodes.astfps.client.AstFPSConfig.startupFlag("astfps.enableTabListCache")
            && !FabricLoader.getInstance().isModLoaded("blindspot")
            && !FabricLoader.getInstance().isModLoaded("badoptimizations");
    }
    public static void tabCacheFailure(String stage, Throwable error) {
        TAB_LIST_CACHE.disableAfterFailure(stage, error);
        LOGGER.error("ASTFPS-FEATURE-DISABLED tab-list-cache stage={} -- original failure preserved", stage, error);
    }
    public static boolean memoHooksAvailable() { return !safeMode() && dev.adelantecodes.astfps.client.AstFPSConfig.startupFlag("astfps.enableVisibilityMemo"); }
    public static boolean terrainHooksAvailable() {
        return !safeMode() && dev.adelantecodes.astfps.client.AstFPSConfig.startupFlag("astfps.enableTerrainBatcher")
            && subsystemConflict(CompatibilityPolicy.Subsystem.TERRAIN_SUBMISSION) == null;
    }
    public static boolean sectionCacheHooksAvailable() {
        return !safeMode() && dev.adelantecodes.astfps.client.AstFPSConfig.startupFlag("astfps.enableSectionWorkerCache") && rendererConflict() == null;
    }
    public static boolean sectionStateHooksAvailable() {
        return !safeMode() && dev.adelantecodes.astfps.client.AstFPSConfig.startupFlag("astfps.enableSectionStateCache")
            && rendererConflict() == null && !FabricLoader.getInstance().isModLoaded("noammaddons");
    }
    public static boolean sectionMeshHooksAvailable() {
        return !safeMode() && dev.adelantecodes.astfps.client.AstFPSConfig.startupFlag("astfps.enableSectionMeshWorkspace") && rendererConflict() == null;
    }
    public static void sectionMeshFailure(String stage, RuntimeException error) {
        SECTION_MESH_WORKSPACE.disableAfterFailure(stage, error);
        LOGGER.error("ASTFPS-FEATURE-DISABLED section-mesh-workspace stage={} -- subsequent jobs use native scratch; original compile error preserved", stage, error);
    }
    public static boolean sectionQuadFormatHooksAvailable() {
        return !safeMode() && dev.adelantecodes.astfps.client.AstFPSConfig.startupFlag("astfps.enableSectionQuadFormat") && rendererConflict() == null;
    }
    public static void sectionQuadFormatFailure(String stage, RuntimeException error) {
        SECTION_QUAD_FORMAT.disableAfterFailure(stage, error);
        LOGGER.error("ASTFPS-FEATURE-DISABLED section-quad-format stage={} -- original error preserved", stage, error);
    }
    public static boolean sectionFabricHooksAvailable() {
        return !safeMode() && dev.adelantecodes.astfps.client.AstFPSConfig.startupFlag("astfps.enableSectionFabricWorkspace") && rendererConflict() == null
            && exactModVersion("fabric-renderer-indigo", "9.1.23+b9d63e335d")
            && exactModVersion("fabric-renderer-api-v1", "17.0.15+79385d0b5d");
    }
    private static boolean exactModVersion(String id, String version) {
        return FabricLoader.getInstance().getModContainer(id)
            .map(mod -> mod.getMetadata().getVersion().getFriendlyString().equals(version)).orElse(false);
    }
    public static void sectionFabricFailure(String stage, RuntimeException error) {
        SECTION_FABRIC_WORKSPACE.disableAfterFailure(stage, error);
        LOGGER.error("ASTFPS-FEATURE-DISABLED section-fabric-workspace stage={} -- original error preserved", stage, error);
    }
    public static boolean modelRotationHooksAvailable() {
        return !safeMode() && dev.adelantecodes.astfps.client.AstFPSConfig.startupFlag("astfps.enableModelRotationScratch")
            && !FabricLoader.getInstance().isModLoaded("lomka");
    }
    public static void modelRotationFailure(String stage, RuntimeException error) {
        MODEL_ROTATION_SCRATCH.disableAfterFailure(stage, error);
        LOGGER.error("ASTFPS-FEATURE-DISABLED model-rotation-scratch stage={} -- original error preserved", stage, error);
    }
    public static void sectionStateFailure(String stage, RuntimeException error) {
        SECTION_STATE_CACHE.disableAfterFailure(stage, error);
        LOGGER.error("ASTFPS-FEATURE-DISABLED section-state-cache stage={} -- subsequent queries delegate; original compile error preserved", stage, error);
    }
    public static void sectionCacheFailure(String stage, RuntimeException error) {
        SECTION_WORKER_CACHE.disableAfterFailure(stage, error);
        LOGGER.error("ASTFPS-FEATURE-DISABLED section-worker-cache stage={} -- subsequent jobs use fresh helpers; original compile error preserved", stage, error);
    }
    public static String rendererConflict() {
        return subsystemConflict(CompatibilityPolicy.Subsystem.TERRAIN_SUBMISSION);
    }
    public static String subsystemConflict(CompatibilityPolicy.Subsystem subsystem) {
        Set<String> loaded = FabricLoader.getInstance().getAllMods().stream()
            .map(mod -> mod.getMetadata().getId()).collect(Collectors.toUnmodifiableSet());
        return CompatibilityPolicy.conflict(subsystem, loaded);
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
    public static long terrainUniformCallbacksAllocated;
    public static long terrainUniformCallbacksReused;
    public static long entitiesDistanceCulled;
    public static long synchronousChunkCompilesDeferred;
    public static long entityVisibilityClockReadsAvoided;
    public static long frameHistoryCaptures;
    public static long frameHistoryReallocations;
    public static long nativeWorldFramesPresented;
    public static long generatedWorldFramesPresented;
    public static long interpolationFastFrames;
    public static long interpolationQualityFrames;
    public static long syntheticWorldExtractionsSkipped;
    public static long chunkUpdatesAdmitted;
    public static long chunkUpdatesDeferredByBudget;
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
