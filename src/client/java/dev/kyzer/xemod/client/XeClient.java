package dev.kyzer.xemod.client;

import com.google.gson.GsonBuilder;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import dev.kyzer.xemod.FrameRecorder;
import dev.kyzer.xemod.FrameStats;
import dev.kyzer.xemod.HookAudit;
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

public final class XeClient implements ClientModInitializer {
    public static final FrameRecorder RECORDER = new FrameRecorder();
    private static final Logger LOGGER = LoggerFactory.getLogger("Xe-Mod");
    private String label = "unlabelled";

    @Override public void onInitializeClient() {
        XeRuntime.VISIBILITY_MEMO.enable(XeRuntime.memoHooksAvailable() && XeConfig.loadMemo());
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, context) -> {
            var root = ClientCommands.literal("xe").requires(FabricClientCommandSource::attended)
                .executes(c -> reply(c.getSource(), "Xe-Mod: /xe status, diagnose, memo true|false, label, benchmark start|stop"));
            root.then(ClientCommands.literal("status").executes(c -> {
                var source = c.getSource();
                reply(source, "Experimental visibility memo: " + XeRuntime.VISIBILITY_MEMO.enabled() + "; safe mode: " + XeRuntime.safeMode());
                reply(source, "Safe mode controls Xe-Mod hooks only; bundled modules use their own configuration.");
                for (String id : new String[]{"ferritecore", "modernfix", "jasione", "chunky", "immediatelyfast", "lithium", "sodium"}) {
                    var component = FabricLoader.getInstance().getModContainer(id);
                    reply(source, "Optimization component " + id + ": " + component.map(mod -> mod.getMetadata().getVersion().getFriendlyString()).orElse("not loaded"));
                }
                reply(source, "Memo hits/misses: " + XeRuntime.visibilityHits + "/" + XeRuntime.visibilityMisses + "; benchmark samples: " + RECORDER.count());
                reply(source, "World target cleanups: " + XeRuntime.worldTargetCleanups + "; released references: " + XeRuntime.releasedTargetReferences);
                if (XeRuntime.VISIBILITY_MEMO.failure() != null) reply(source, "Disabled after error in " + XeRuntime.VISIBILITY_MEMO.failure().stage() + "; /xe diagnose for details.");
                return 1;
            }));
            root.then(ClientCommands.literal("memo")
                .then(ClientCommands.argument("enabled", BoolArgumentType.bool()).executes(c -> setMemo(c.getSource(), BoolArgumentType.getBool(c, "enabled")))));
            root.then(ClientCommands.literal("diagnose").executes(c -> diagnose(c.getSource())));
            root.then(ClientCommands.literal("label").then(ClientCommands.argument("text", StringArgumentType.greedyString()).executes(c -> {
                String text = StringArgumentType.getString(c, "text");
                label = text.substring(0, Math.min(160, text.length()));
                return reply(c.getSource(), "Benchmark label: " + label);
            })));
            root.then(ClientCommands.literal("benchmark")
                .then(ClientCommands.literal("start").executes(c -> {
                    if (RECORDER.isRecording()) return reply(c.getSource(), "A benchmark is already recording; stop it first.");
                    RECORDER.start();
                    return reply(c.getSource(), "Recording frame-start intervals, including frame pacing. Run a fixed route, then /xe benchmark stop.");
                }))
                .then(ClientCommands.literal("stop").executes(c -> export(c.getSource()))));
            dispatcher.register(root);
        });
        LOGGER.info("Xe-Mod initialized. No existing settings changed at startup.");
    }

    private int export(FabricClientCommandSource source) {
        FrameRecorder.Snapshot snapshot = RECORDER.stop();
        if (snapshot.intervals().length == 0) return reply(source, "No frame samples; start a benchmark first.");
        FrameStats stats = FrameStats.calculate(snapshot.intervals());
        var metadata = new LinkedHashMap<String, Object>();
        metadata.put("schemaVersion", 1);
        metadata.put("label", label);
        metadata.put("visibilityMemoEnabled", XeRuntime.VISIBILITY_MEMO.enabled());
        metadata.put("visibilityMemoHits", XeRuntime.visibilityHits);
        metadata.put("visibilityMemoMisses", XeRuntime.visibilityMisses);
        metadata.put("sampleCapReached", snapshot.capped());
        metadata.put("statistics", stats);
        metadata.put("measurement", "Intervals between frame starts, including pacing; not GPU timings or CPU-only render cost");
        Map<String, String> versions = new java.util.TreeMap<>();
        FabricLoader.getInstance().getAllMods().forEach(mod -> versions.put(mod.getMetadata().getId(), mod.getMetadata().getVersion().getFriendlyString()));
        metadata.put("mods", versions);
        metadata.put("frameIntervalsNanos", snapshot.intervals());
        Path directory = FabricLoader.getInstance().getGameDir().resolve("xe-benchmarks");
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
        if (enabled && !XeRuntime.memoHooksAvailable()) return reply(source, "Memo hooks were not installed. Restart with -Dxe.enableVisibilityMemo=true and safe mode off to opt in.");
        if (enabled && XeRuntime.safeMode()) return reply(source, "Safe mode disables optimization hooks. Remove -Dxe.safeMode=true and restart to test this feature.");
        if (enabled && XeRuntime.VISIBILITY_MEMO.failure() != null) return reply(source, "Feature previously failed and remains disabled. Save /xe diagnose and restart before retrying.");
        try {
            XeConfig.saveMemo(enabled);
            XeRuntime.VISIBILITY_MEMO.enable(enabled);
            XeRuntime.frameEpoch++;
            XeRuntime.visibilityHits = 0;
            XeRuntime.visibilityMisses = 0;
            return reply(source, "Experimental memo " + (enabled ? "enabled" : "disabled") + ". Compare the same scene on/off. No visual settings changed.");
        } catch (IOException | IllegalArgumentException e) {
            source.sendError(Component.literal("Xe-Mod: " + e.getMessage()));
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
        report.put("safeMode", XeRuntime.safeMode());
        report.put("safeModeScope", "Xe-Mod original hooks only; does not disable bundled upstream modules");
        report.put("memoHooksAvailable", XeRuntime.memoHooksAvailable());
        report.put("hookReceipts", HookAudit.snapshot());
        report.put("visibilityMemoEnabled", XeRuntime.VISIBILITY_MEMO.enabled());
        report.put("visibilityMemoFailure", XeRuntime.VISIBILITY_MEMO.failure());
        report.put("cacheHits", XeRuntime.visibilityHits);
        report.put("cacheMisses", XeRuntime.visibilityMisses);
        report.put("worldTargetCleanups", XeRuntime.worldTargetCleanups);
        report.put("releasedTargetReferences", XeRuntime.releasedTargetReferences);
        Map<String, String> versions = new java.util.TreeMap<>();
        FabricLoader.getInstance().getAllMods().forEach(mod -> versions.put(mod.getMetadata().getId(), mod.getMetadata().getVersion().getFriendlyString()));
        report.put("loadedVersions", versions);
        Path destination = FabricLoader.getInstance().getGameDir().resolve("xe-diagnostics")
            .resolve("diagnostic-" + Instant.now().toString().replace(':', '-') + ".json");
        try {
            Files.createDirectories(destination.getParent());
            Files.writeString(destination, new GsonBuilder().setPrettyPrinting().create().toJson(report));
            return reply(source, "Local diagnostic saved: " + destination + ". Startup failures: search latest.log for XE-HOOK-BEGIN / XE-HOOK-OK. Fallback launch: -Dxe.safeMode=true");
        } catch (IOException error) {
            LOGGER.error("XE-DIAGNOSTIC-WRITE-FAILED {}", destination, error);
            source.sendError(Component.literal("Diagnostic write failed: " + error.getMessage()));
            return 0;
        }
    }

}
