package dev.kyzer.xemod.client;

import com.google.gson.GsonBuilder;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import dev.kyzer.xemod.FrameRecorder;
import dev.kyzer.xemod.FrameStats;
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
        XeRuntime.visibilityMemoEnabled = XeConfig.loadMemo();
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, context) -> {
            var root = ClientCommands.literal("xe").requires(FabricClientCommandSource::attended)
                .executes(c -> reply(c.getSource(), "Xe-Mod: /xe status, memo true|false, label, benchmark start|stop"));
            root.then(ClientCommands.literal("status").executes(c -> {
                var source = c.getSource();
                reply(source, "Vanilla visuals preserved. Experimental visibility memo: " + XeRuntime.visibilityMemoEnabled);
                reply(source, "Memo hits/misses: " + XeRuntime.visibilityHits + "/" + XeRuntime.visibilityMisses + "; benchmark samples: " + RECORDER.count());
                return 1;
            }));
            root.then(ClientCommands.literal("memo")
                .then(ClientCommands.argument("enabled", BoolArgumentType.bool()).executes(c -> setMemo(c.getSource(), BoolArgumentType.getBool(c, "enabled")))));
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
        metadata.put("visibilityMemoEnabled", XeRuntime.visibilityMemoEnabled);
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
        try {
            XeConfig.saveMemo(enabled);
            XeRuntime.visibilityMemoEnabled = enabled;
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

}
