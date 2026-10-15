package dev.adelantecodes.astfps.client;

import com.google.gson.GsonBuilder;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import dev.adelantecodes.astfps.FrameRecorder;
import dev.adelantecodes.astfps.FrameStats;
import dev.adelantecodes.astfps.HookAudit;
import dev.adelantecodes.astfps.StageTimings;
import dev.adelantecodes.astfps.RuntimeMetrics;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.command.v2.ClientCommands;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class AstFPSClient implements ClientModInitializer {
    public static final FrameRecorder RECORDER = new FrameRecorder();
    private static final Logger LOGGER = LoggerFactory.getLogger("AstFPS");
    private String label = "unlabelled";
    private Map<String, Object> benchmarkStartContext;
    private Map<String, Object> benchmarkStartRuntime;
    private long benchmarkTerrainFramesStart;

    @Override public void onInitializeClient() {
        AstFPSRuntime.VISIBILITY_MEMO.enable(AstFPSRuntime.memoHooksAvailable() && AstFPSConfig.loadMemo());
        AstFPSRuntime.TERRAIN_BATCHER.enable(AstFPSRuntime.terrainHooksAvailable());
        AstFPSRuntime.SECTION_WORKER_CACHE.enable(AstFPSRuntime.sectionCacheHooksAvailable());
        AstFPSRuntime.SECTION_STATE_CACHE.enable(AstFPSRuntime.sectionStateHooksAvailable());
        AstFPSRuntime.SECTION_MESH_WORKSPACE.enable(AstFPSRuntime.sectionMeshHooksAvailable());
        AdditionalExperiments.initialize();
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, context) -> {
            var root = ClientCommands.literal("astfps").requires(FabricClientCommandSource::attended)
                .executes(c -> reply(c.getSource(), "AstFPS: /astfps profile quality|balanced|maximum|restore, status, diagnose, memo, terrain, state-cache, label, benchmark start|stop"));
            var profiles = ClientCommands.literal("profile");
            for (var profile : AstFPSProfiles.Profile.values()) {
                profiles.then(ClientCommands.literal(profile.name().toLowerCase(Locale.ROOT)).executes(c -> {
                    if (RECORDER.isRecording()) return reply(c.getSource(), "Stop recording before switching profiles.");
                    return reply(c.getSource(), AstFPSProfiles.apply(Minecraft.getInstance(), profile));
                }));
            }
            profiles.then(ClientCommands.literal("restore").executes(c -> {
                if (RECORDER.isRecording()) return reply(c.getSource(), "Stop recording before restoring settings.");
                return reply(c.getSource(), AstFPSProfiles.restore(Minecraft.getInstance()));
            }));
            root.then(profiles);
            for (var experiment : AdditionalExperiments.ENTRIES) {
                root.then(ClientCommands.literal(experiment.command()).then(ClientCommands.argument("enabled", BoolArgumentType.bool()).executes(c -> {
                    boolean enabled = BoolArgumentType.getBool(c, "enabled");
                    if (RECORDER.isRecording()) return reply(c.getSource(), "Stop recording before switching experiments.");
                    if (enabled && !experiment.available().getAsBoolean()) return reply(c.getSource(), "This experiment requires its startup opt-in and compatible loaded modules.");
                    if (!experiment.gate().enable(enabled)) return reply(c.getSource(), "This experiment failed earlier; save diagnostics and restart before retrying.");
                    return reply(c.getSource(), experiment.command() + ": " + enabled);
                })));
            }
            root.then(ClientCommands.literal("status").executes(c -> {
                var source = c.getSource();
                reply(source, "Profile: " + AstFPSProfiles.current() + "; shader integration remains under development.");
                reply(source, "Experimental visibility memo: " + AstFPSRuntime.VISIBILITY_MEMO.enabled() + "; safe mode: " + AstFPSRuntime.safeMode());
                reply(source, "Original terrain batcher: " + AstFPSRuntime.TERRAIN_BATCHER.enabled() + "; frames/draws/batches: " + AstFPSRuntime.terrainBatchFrames + "/" + AstFPSRuntime.terrainSectionDraws + "/" + AstFPSRuntime.terrainGpuBatches);
                reply(source, "Terrain direct/indirect frames: " + AstFPSRuntime.terrainDirectFrames + "/" + AstFPSRuntime.terrainIndirectFrames + "; command records reused/allocated: " + AstFPSRuntime.terrainCommandRecordsReused + "/" + AstFPSRuntime.terrainCommandRecordsAllocated);
                reply(source, "Terrain section records reused/allocated: " + AstFPSRuntime.terrainSectionInfosReused + "/" + AstFPSRuntime.terrainSectionInfosAllocated);
                reply(source, "Terrain uniform callbacks reused/allocated: " + AstFPSRuntime.terrainUniformCallbacksReused + "/" + AstFPSRuntime.terrainUniformCallbacksAllocated);
                reply(source, "Section worker cache: " + AstFPSRuntime.SECTION_WORKER_CACHE.enabled() + "; jobs: " + AstFPSRuntime.sectionCacheJobs.sum() + "; model/fluid helpers reused: " + AstFPSRuntime.sectionModelHelpersReused.sum() + "/" + AstFPSRuntime.sectionFluidHelpersReused.sum());
                reply(source, "Section state cache: " + AstFPSRuntime.SECTION_STATE_CACHE.enabled() + "; hits/misses/bypasses: " + AstFPSRuntime.sectionStateHits.sum() + "/" + AstFPSRuntime.sectionStateMisses.sum() + "/" + AstFPSRuntime.sectionStateBypasses.sum());
                reply(source, "Section mesh workspace: " + AstFPSRuntime.SECTION_MESH_WORKSPACE.enabled() + "; jobs/maps/bits/queues reused: " + AstFPSRuntime.meshWorkspaceJobs.sum() + "/" + AstFPSRuntime.layerMapsReused.sum() + "/" + AstFPSRuntime.visibilityBitsetsReused.sum() + "/" + AstFPSRuntime.floodQueuesReused.sum());
                if (AstFPSRuntime.rendererConflict() != null) reply(source, "Terrain replacement bypassed for renderer: " + AstFPSRuntime.rendererConflict());
                reply(source, "Safe mode controls AstFPS hooks only; bundled modules use their own configuration.");
                for (String id : new String[]{"ferritecore", "modernfix", "jasione", "chunky", "immediatelyfast", "lithium", "sodium"}) {
                    var component = FabricLoader.getInstance().getModContainer(id);
                    reply(source, "Optimization component " + id + ": " + component.map(mod -> mod.getMetadata().getVersion().getFriendlyString()).orElse("not loaded"));
                }
                reply(source, "Memo hits/misses: " + AstFPSRuntime.visibilityHits + "/" + AstFPSRuntime.visibilityMisses + "; benchmark samples: " + RECORDER.count());
                reply(source, "World target cleanups: " + AstFPSRuntime.worldTargetCleanups + "; released references: " + AstFPSRuntime.releasedTargetReferences);
                if (AstFPSRuntime.VISIBILITY_MEMO.failure() != null) reply(source, "Disabled after error in " + AstFPSRuntime.VISIBILITY_MEMO.failure().stage() + "; /astfps diagnose for details.");
                return 1;
            }));
            root.then(ClientCommands.literal("memo")
                .then(ClientCommands.argument("enabled", BoolArgumentType.bool()).executes(c -> setMemo(c.getSource(), BoolArgumentType.getBool(c, "enabled")))));
            root.then(ClientCommands.literal("state-cache").then(ClientCommands.argument("enabled", BoolArgumentType.bool()).executes(c -> {
                boolean enabled = BoolArgumentType.getBool(c, "enabled");
                if (RECORDER.isRecording()) return reply(c.getSource(), "Stop recording before switching compilation caches.");
                if (enabled && !AstFPSRuntime.sectionStateHooksAvailable()) return reply(c.getSource(), "Restart with -Dastfps.enableSectionStateCache=true, safe mode off, and no conflicting renderer or dynamic block-state hook to opt in.");
                if (!AstFPSRuntime.SECTION_STATE_CACHE.enable(enabled)) return reply(c.getSource(), "Section state cache failed earlier; save /astfps diagnose and restart before retrying.");
                return reply(c.getSource(), "Experimental section state cache: " + enabled + ".");
            })));
            root.then(ClientCommands.literal("terrain").then(ClientCommands.argument("enabled", BoolArgumentType.bool()).executes(c -> {
                boolean enabled = BoolArgumentType.getBool(c, "enabled");
                if (RECORDER.isRecording()) return reply(c.getSource(), "Stop recording before switching terrain backends.");
                if (enabled && !AstFPSRuntime.terrainHooksAvailable()) return reply(c.getSource(), "Restart with -Dastfps.enableTerrainBatcher=true, safe mode off, and no other terrain renderer to opt in.");
                if (!AstFPSRuntime.TERRAIN_BATCHER.enable(enabled)) return reply(c.getSource(), "Terrain batcher failed earlier; save /astfps diagnose and restart before retrying.");
                return reply(c.getSource(), "Terrain submission: " + (enabled ? "AstFPS experimental" : "vanilla") + ". Graphics settings unchanged.");
            })));
            root.then(ClientCommands.literal("diagnose").executes(c -> diagnose(c.getSource())));
            root.then(ClientCommands.literal("mesh-workspace").then(ClientCommands.argument("enabled", BoolArgumentType.bool()).executes(c -> {
                boolean enabled = BoolArgumentType.getBool(c, "enabled");
                if (RECORDER.isRecording()) return reply(c.getSource(), "Stop recording before switching compilation storage.");
                if (enabled && !AstFPSRuntime.sectionMeshHooksAvailable()) return reply(c.getSource(), "Mesh workspace hooks require the startup opt-in and a compatible renderer.");
                if (!AstFPSRuntime.SECTION_MESH_WORKSPACE.enable(enabled)) return reply(c.getSource(), "Mesh workspace failed earlier; save diagnostics and restart before retrying.");
                return reply(c.getSource(), "Experimental mesh workspace: " + enabled + ".");
            })));
            root.then(ClientCommands.literal("worker-cache").then(ClientCommands.argument("enabled", BoolArgumentType.bool()).executes(c -> {
                boolean enabled = BoolArgumentType.getBool(c, "enabled");
                if (RECORDER.isRecording()) return reply(c.getSource(), "Stop recording before switching compilation helpers.");
                if (enabled && !AstFPSRuntime.sectionCacheHooksAvailable()) return reply(c.getSource(), "Worker helper hooks require the startup opt-in and a compatible renderer.");
                if (!AstFPSRuntime.SECTION_WORKER_CACHE.enable(enabled)) return reply(c.getSource(), "Worker helper cache failed earlier; save diagnostics and restart before retrying.");
                return reply(c.getSource(), "Experimental worker helper cache: " + enabled + ".");
            })));
            root.then(ClientCommands.literal("label").then(ClientCommands.argument("text", StringArgumentType.greedyString()).executes(c -> {
                if (RECORDER.isRecording()) return reply(c.getSource(), "Stop recording before changing the scene label.");
                String text = StringArgumentType.getString(c, "text");
                label = text.substring(0, Math.min(160, text.length()));
                return reply(c.getSource(), "Benchmark label: " + label);
            })));
            root.then(ClientCommands.literal("benchmark")
                .then(ClientCommands.literal("start").executes(c -> {
                    if (RECORDER.isRecording()) return reply(c.getSource(), "A benchmark is already recording; stop it first.");
                    benchmarkStartContext = BenchmarkContext.capture();
                    benchmarkStartRuntime = RuntimeMetrics.capture();
                    benchmarkTerrainFramesStart = AstFPSRuntime.terrainBatchFrames;
                    StageTimings.start();
                    RECORDER.start();
                    return reply(c.getSource(), "Recording frame-start intervals, including frame pacing. Run a fixed route, then /astfps benchmark stop.");
                }))
                .then(ClientCommands.literal("stop").executes(c -> export(c.getSource()))));
            dispatcher.register(root);
        });
        LOGGER.info("AstFPS initialized. No existing settings changed at startup.");
    }

    private int export(FabricClientCommandSource source) {
        FrameRecorder.Snapshot snapshot = RECORDER.stop();
        var stageTimings = StageTimings.snapshot(true);
        if (snapshot.intervals().length == 0) return reply(source, "No frame samples; start a benchmark first.");
        FrameStats stats = FrameStats.calculate(snapshot.intervals());
        var metadata = new LinkedHashMap<String, Object>();
        metadata.put("schemaVersion", 1);
        metadata.put("stageTimings", stageTimings);
        var endRuntime = RuntimeMetrics.capture();
        metadata.put("runtimeStart", benchmarkStartRuntime);
        metadata.put("runtimeEnd", endRuntime);
        metadata.put("garbageCollectionDeltas", RuntimeMetrics.collectionDeltas(benchmarkStartRuntime, endRuntime));
        var endContext = BenchmarkContext.capture();
        metadata.put("startContext", benchmarkStartContext);
        metadata.put("endContext", endContext);
        metadata.put("contextStable", benchmarkStartContext != null && benchmarkStartContext.equals(endContext));
        metadata.put("label", label);
        metadata.put("visibilityMemoEnabled", AstFPSRuntime.VISIBILITY_MEMO.enabled());
        metadata.put("terrainBatcherEnabled", AstFPSRuntime.TERRAIN_BATCHER.enabled());
        metadata.put("terrainBatchFrames", AstFPSRuntime.terrainBatchFrames);
        metadata.put("terrainFramesInCapture", AstFPSRuntime.terrainBatchFrames - benchmarkTerrainFramesStart);
        metadata.put("terrainSectionDraws", AstFPSRuntime.terrainSectionDraws);
        metadata.put("terrainGpuBatches", AstFPSRuntime.terrainGpuBatches);
        metadata.put("terrainDirectFrames", AstFPSRuntime.terrainDirectFrames);
        metadata.put("terrainIndirectFrames", AstFPSRuntime.terrainIndirectFrames);
        metadata.put("terrainCommandRecordsReused", AstFPSRuntime.terrainCommandRecordsReused);
        metadata.put("terrainCommandRecordsAllocated", AstFPSRuntime.terrainCommandRecordsAllocated);
        metadata.put("terrainSectionInfosReused", AstFPSRuntime.terrainSectionInfosReused);
        metadata.put("terrainSectionInfosAllocated", AstFPSRuntime.terrainSectionInfosAllocated);
        metadata.put("terrainUniformCallbacksReused", AstFPSRuntime.terrainUniformCallbacksReused);
        metadata.put("terrainUniformCallbacksAllocated", AstFPSRuntime.terrainUniformCallbacksAllocated);
        metadata.put("additionalExperiments", AdditionalExperiments.snapshot());
        metadata.put("sectionWorkerCacheEnabled", AstFPSRuntime.SECTION_WORKER_CACHE.enabled());
        captureSectionStates(metadata);
        metadata.put("sectionCacheJobs", AstFPSRuntime.sectionCacheJobs.sum());
        metadata.put("sectionModelHelpersReused", AstFPSRuntime.sectionModelHelpersReused.sum());
        metadata.put("sectionFluidHelpersReused", AstFPSRuntime.sectionFluidHelpersReused.sum());
        metadata.put("visibilityMemoHits", AstFPSRuntime.visibilityHits);
        metadata.put("visibilityMemoMisses", AstFPSRuntime.visibilityMisses);
        metadata.put("sampleCapReached", snapshot.capped());
        metadata.put("statistics", stats);
        metadata.put("measurement", "Intervals between frame starts, including pacing; not GPU timings or CPU-only render cost");
        Map<String, String> versions = new java.util.TreeMap<>();
        FabricLoader.getInstance().getAllMods().forEach(mod -> versions.put(mod.getMetadata().getId(), mod.getMetadata().getVersion().getFriendlyString()));
        metadata.put("mods", versions);
        metadata.put("frameIntervalsNanos", snapshot.intervals());
        Path directory = FabricLoader.getInstance().getGameDir().resolve("astfps-benchmarks");
        String name = "frames-" + Instant.now().toString().replace(':', '-') + ".json";
        Path destination = directory.resolve(name);
        reply(source, String.format(Locale.ROOT, "%.1f FPS average; %.2f ms p99; %.1f FPS 1%% low. Saving locally.", stats.averageFps(), stats.p99Millis(), stats.onePercentLowFps()));
        CompletableFuture.runAsync(() -> {
            try {
                Files.createDirectories(directory);
                Files.writeString(destination, new GsonBuilder().setPrettyPrinting().create().toJson(metadata));
                LOGGER.info("Benchmark saved: {}", destination);
            } catch (IOException e) { LOGGER.error("Unable to save benchmark {}", destination, e); }
        });
        return 1;
    }

    private int setMemo(FabricClientCommandSource source, boolean enabled) {
        if (RECORDER.isRecording()) return reply(source, "Stop recording before switching visibility memoization.");
        if (enabled && !AstFPSRuntime.memoHooksAvailable()) return reply(source, "Memo hooks were not installed. Restart with -Dastfps.enableVisibilityMemo=true and safe mode off to opt in.");
        if (enabled && AstFPSRuntime.safeMode()) return reply(source, "Safe mode disables optimization hooks. Remove -Dastfps.safeMode=true and restart to test this feature.");
        if (enabled && AstFPSRuntime.VISIBILITY_MEMO.failure() != null) return reply(source, "Feature previously failed and remains disabled. Save /astfps diagnose and restart before retrying.");
        try {
            AstFPSConfig.saveMemo(enabled);
            AstFPSRuntime.VISIBILITY_MEMO.enable(enabled);
            AstFPSRuntime.frameEpoch++;
            AstFPSRuntime.visibilityHits = 0;
            AstFPSRuntime.visibilityMisses = 0;
            return reply(source, "Experimental memo " + (enabled ? "enabled" : "disabled") + ". Compare the same scene on/off. No visual settings changed.");
        } catch (IOException | IllegalArgumentException e) {
            source.sendError(Component.literal("AstFPS: " + e.getMessage()));
            return 0;
        }
    }

    private static void captureSectionStates(Map<String, Object> target) {
        target.put("profile", AstFPSProfiles.current());
        target.put("sectionStateHooksAvailable", AstFPSRuntime.sectionStateHooksAvailable());
        target.put("sectionStateCacheEnabled", AstFPSRuntime.SECTION_STATE_CACHE.enabled());
        target.put("sectionStateCacheFailure", AstFPSRuntime.SECTION_STATE_CACHE.failure());
        target.put("sectionStateVerification", Boolean.getBoolean("astfps.verifySectionStateCache"));
        target.put("sectionStateJobs", AstFPSRuntime.sectionStateJobs.sum());
        target.put("sectionStateHits", AstFPSRuntime.sectionStateHits.sum());
        target.put("sectionStateMisses", AstFPSRuntime.sectionStateMisses.sum());
        target.put("sectionStateBypasses", AstFPSRuntime.sectionStateBypasses.sum());
        target.put("sectionStateMismatches", AstFPSRuntime.sectionStateMismatches.sum());
        target.put("sectionMeshHooksAvailable", AstFPSRuntime.sectionMeshHooksAvailable());
        target.put("sectionMeshWorkspaceEnabled", AstFPSRuntime.SECTION_MESH_WORKSPACE.enabled());
        target.put("sectionMeshWorkspaceFailure", AstFPSRuntime.SECTION_MESH_WORKSPACE.failure());
        target.put("meshWorkspaceJobs", AstFPSRuntime.meshWorkspaceJobs.sum());
        target.put("layerMapsReused", AstFPSRuntime.layerMapsReused.sum());
        target.put("visibilityBitsetsReused", AstFPSRuntime.visibilityBitsetsReused.sum());
        target.put("floodQueuesReused", AstFPSRuntime.floodQueuesReused.sum());
    }

    private static int reply(FabricClientCommandSource source, String text) {
        source.sendFeedback(Component.literal(text));
        return 1;
    }

    private int diagnose(FabricClientCommandSource source) {
        var report = new LinkedHashMap<String, Object>();
        report.put("schemaVersion", 1);
        report.put("stageTimings", StageTimings.snapshot(false));
        report.put("runtime", RuntimeMetrics.capture());
        report.put("time", Instant.now().toString());
        report.put("javaVersion", System.getProperty("java.version"));
        report.put("os", System.getProperty("os.name"));
        report.put("safeMode", AstFPSRuntime.safeMode());
        report.put("safeModeScope", "AstFPS original hooks only; does not disable bundled upstream modules");
        report.put("memoHooksAvailable", AstFPSRuntime.memoHooksAvailable());
        report.put("terrainHooksAvailable", AstFPSRuntime.terrainHooksAvailable());
        report.put("terrainBatcherEnabled", AstFPSRuntime.TERRAIN_BATCHER.enabled());
        report.put("terrainBatcherFailure", AstFPSRuntime.TERRAIN_BATCHER.failure());
        report.put("terrainRendererConflict", AstFPSRuntime.rendererConflict());
        report.put("terrainBatchFrames", AstFPSRuntime.terrainBatchFrames);
        report.put("terrainSectionDraws", AstFPSRuntime.terrainSectionDraws);
        report.put("terrainGpuBatches", AstFPSRuntime.terrainGpuBatches);
        report.put("terrainFallbacks", AstFPSRuntime.terrainFallbacks);
        report.put("terrainDirectFrames", AstFPSRuntime.terrainDirectFrames);
        report.put("terrainIndirectFrames", AstFPSRuntime.terrainIndirectFrames);
        report.put("terrainCommandRecordsReused", AstFPSRuntime.terrainCommandRecordsReused);
        report.put("terrainCommandRecordsAllocated", AstFPSRuntime.terrainCommandRecordsAllocated);
        report.put("terrainSectionInfosReused", AstFPSRuntime.terrainSectionInfosReused);
        report.put("terrainSectionInfosAllocated", AstFPSRuntime.terrainSectionInfosAllocated);
        report.put("terrainUniformCallbacksReused", AstFPSRuntime.terrainUniformCallbacksReused);
        report.put("terrainUniformCallbacksAllocated", AstFPSRuntime.terrainUniformCallbacksAllocated);
        report.put("additionalExperiments", AdditionalExperiments.snapshot());
        report.put("sectionWorkerCacheEnabled", AstFPSRuntime.SECTION_WORKER_CACHE.enabled());
        captureSectionStates(report);
        report.put("sectionWorkerCacheFailure", AstFPSRuntime.SECTION_WORKER_CACHE.failure());
        report.put("sectionCacheJobs", AstFPSRuntime.sectionCacheJobs.sum());
        report.put("sectionModelHelpersAllocated", AstFPSRuntime.sectionModelHelpersAllocated.sum());
        report.put("sectionModelHelpersReused", AstFPSRuntime.sectionModelHelpersReused.sum());
        report.put("sectionFluidHelpersAllocated", AstFPSRuntime.sectionFluidHelpersAllocated.sum());
        report.put("sectionFluidHelpersReused", AstFPSRuntime.sectionFluidHelpersReused.sum());
        report.put("hookReceipts", HookAudit.snapshot());
        report.put("visibilityMemoEnabled", AstFPSRuntime.VISIBILITY_MEMO.enabled());
        report.put("visibilityMemoFailure", AstFPSRuntime.VISIBILITY_MEMO.failure());
        report.put("cacheHits", AstFPSRuntime.visibilityHits);
        report.put("cacheMisses", AstFPSRuntime.visibilityMisses);
        report.put("worldTargetCleanups", AstFPSRuntime.worldTargetCleanups);
        report.put("releasedTargetReferences", AstFPSRuntime.releasedTargetReferences);
        Map<String, String> versions = new java.util.TreeMap<>();
        FabricLoader.getInstance().getAllMods().forEach(mod -> versions.put(mod.getMetadata().getId(), mod.getMetadata().getVersion().getFriendlyString()));
        report.put("loadedVersions", versions);
        Path destination = FabricLoader.getInstance().getGameDir().resolve("astfps-diagnostics")
            .resolve("diagnostic-" + Instant.now().toString().replace(':', '-') + ".json");
        try {
            Files.createDirectories(destination.getParent());
            Files.writeString(destination, new GsonBuilder().setPrettyPrinting().create().toJson(report));
            return reply(source, "Local diagnostic saved: " + destination + ". Startup failures: search latest.log for ASTFPS-HOOK-BEGIN / ASTFPS-HOOK-OK. Fallback launch: -Dastfps.safeMode=true");
        } catch (IOException error) {
            LOGGER.error("ASTFPS-DIAGNOSTIC-WRITE-FAILED {}", destination, error);
            source.sendError(Component.literal("Diagnostic write failed: " + error.getMessage()));
            return 0;
        }
    }

}
