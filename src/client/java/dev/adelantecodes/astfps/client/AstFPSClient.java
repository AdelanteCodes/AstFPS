package dev.adelantecodes.astfps.client;

import com.google.gson.GsonBuilder;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import dev.adelantecodes.astfps.FrameRecorder;
import dev.adelantecodes.astfps.FrameStats;
import dev.adelantecodes.astfps.HookAudit;
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
import net.minecraft.network.chat.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class AstFPSClient implements ClientModInitializer {
    public static final FrameRecorder RECORDER = new FrameRecorder();
    private static final Logger LOGGER = LoggerFactory.getLogger("AstFPS");
    private String label = "unlabelled";
    private Map<String, Object> benchmarkStartContext;
    private long benchmarkTerrainFramesStart;

    @Override public void onInitializeClient() {
        AstFPSRuntime.VISIBILITY_MEMO.enable(AstFPSRuntime.memoHooksAvailable() && AstFPSConfig.loadMemo());
        AstFPSRuntime.TERRAIN_BATCHER.enable(AstFPSRuntime.terrainHooksAvailable());
        AstFPSRuntime.SECTION_WORKER_CACHE.enable(AstFPSRuntime.sectionCacheHooksAvailable());
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, context) -> {
            var root = ClientCommands.literal("astfps").requires(FabricClientCommandSource::attended)
                .executes(c -> reply(c.getSource(), "AstFPS: /astfps status, diagnose, memo true|false, label, benchmark start|stop"));
            root.then(ClientCommands.literal("status").executes(c -> {
                var source = c.getSource();
                reply(source, "Experimental visibility memo: " + AstFPSRuntime.VISIBILITY_MEMO.enabled() + "; safe mode: " + AstFPSRuntime.safeMode());
                reply(source, "Original terrain batcher: " + AstFPSRuntime.TERRAIN_BATCHER.enabled() + "; frames/draws/batches: " + AstFPSRuntime.terrainBatchFrames + "/" + AstFPSRuntime.terrainSectionDraws + "/" + AstFPSRuntime.terrainGpuBatches);
                reply(source, "Terrain direct/indirect frames: " + AstFPSRuntime.terrainDirectFrames + "/" + AstFPSRuntime.terrainIndirectFrames + "; command records reused/allocated: " + AstFPSRuntime.terrainCommandRecordsReused + "/" + AstFPSRuntime.terrainCommandRecordsAllocated);
                reply(source, "Terrain section records reused/allocated: " + AstFPSRuntime.terrainSectionInfosReused + "/" + AstFPSRuntime.terrainSectionInfosAllocated);
                reply(source, "Section worker cache: " + AstFPSRuntime.SECTION_WORKER_CACHE.enabled() + "; jobs: " + AstFPSRuntime.sectionCacheJobs.sum() + "; model/fluid helpers reused: " + AstFPSRuntime.sectionModelHelpersReused.sum() + "/" + AstFPSRuntime.sectionFluidHelpersReused.sum());
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
            root.then(ClientCommands.literal("terrain").then(ClientCommands.argument("enabled", BoolArgumentType.bool()).executes(c -> {
                boolean enabled = BoolArgumentType.getBool(c, "enabled");
                if (RECORDER.isRecording()) return reply(c.getSource(), "Stop recording before switching terrain backends.");
                if (enabled && !AstFPSRuntime.terrainHooksAvailable()) return reply(c.getSource(), "Restart with -Dastfps.enableTerrainBatcher=true, safe mode off, and no other terrain renderer to opt in.");
                if (!AstFPSRuntime.TERRAIN_BATCHER.enable(enabled)) return reply(c.getSource(), "Terrain batcher failed earlier; save /astfps diagnose and restart before retrying.");
                return reply(c.getSource(), "Terrain submission: " + (enabled ? "AstFPS experimental" : "vanilla") + ". Graphics settings unchanged.");
            })));
            root.then(ClientCommands.literal("diagnose").executes(c -> diagnose(c.getSource())));
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
                    benchmarkTerrainFramesStart = AstFPSRuntime.terrainBatchFrames;
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
        if (snapshot.intervals().length == 0) return reply(source, "No frame samples; start a benchmark first.");
        FrameStats stats = FrameStats.calculate(snapshot.intervals());
        var metadata = new LinkedHashMap<String, Object>();
        metadata.put("schemaVersion", 1);
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
        metadata.put("sectionWorkerCacheEnabled", AstFPSRuntime.SECTION_WORKER_CACHE.enabled());
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

    private static int reply(FabricClientCommandSource source, String text) {
        source.sendFeedback(Component.literal(text));
        return 1;
    }

    private int diagnose(FabricClientCommandSource source) {
        var report = new LinkedHashMap<String, Object>();
        report.put("schemaVersion", 1);
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
        report.put("sectionWorkerCacheEnabled", AstFPSRuntime.SECTION_WORKER_CACHE.enabled());
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
