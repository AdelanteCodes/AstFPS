package dev.adelantecodes.astfps.client;

import com.google.gson.JsonObject;
import dev.adelantecodes.astfps.FrameStats;
import dev.adelantecodes.astfps.client.render.FrameGenerationController;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.util.Arrays;
import java.util.LinkedHashMap;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.Minecraft;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** One-shot unattended benchmark, enabled only by an explicit local request file. */
public final class AutoBenchmark {
    private enum Phase { WAITING, WARMUP, SAMPLE, COMPLETE }
    private static final Logger LOGGER = LoggerFactory.getLogger("AstFPS-Benchmark");
    private static final Path REQUEST = FabricLoader.getInstance().getConfigDir().resolve("astfps-auto-benchmark.json");
    private static final long[] INTERVALS = new long[120_000];
    private static Phase phase = Phase.WAITING;
    private static long lastActiveFrame, warmupElapsed, sampleElapsed;
    private static int count;
    private static int warmupSeconds = 30, sampleSeconds = 60;
    private static String label = "unnamed";
    private static long nativeStart, generatedStart;
    private static boolean loaded;

    private AutoBenchmark() { }

    public static void frame(Minecraft minecraft, long now) {
        if (phase == Phase.COMPLETE) return;
        if (!loaded) load();
        if (phase == Phase.COMPLETE) return;
        if (minecraft.level == null || minecraft.gui.screen() != null || minecraft.gui.overlay() != null) {
            lastActiveFrame = 0;
            return;
        }
        if (phase == Phase.WAITING) { phase = Phase.WARMUP; lastActiveFrame = now; return; }
        long interval = lastActiveFrame == 0 ? 0 : now - lastActiveFrame;
        lastActiveFrame = now;
        if (phase == Phase.WARMUP) {
            warmupElapsed += interval;
            if (warmupElapsed < warmupSeconds * 1_000_000_000L) return;
            phase = Phase.SAMPLE; sampleElapsed = 0; count = 0;
            nativeStart = AstFPSRuntime.nativeWorldFramesPresented;
            generatedStart = AstFPSRuntime.generatedWorldFramesPresented;
            LOGGER.info("ASTFPS-BENCHMARK-BEGIN label={} sampleSeconds={}", label, sampleSeconds);
            return;
        }
        if (phase != Phase.SAMPLE) return;
        if (interval > 0 && count < INTERVALS.length) { INTERVALS[count++] = interval; sampleElapsed += interval; }
        if (sampleElapsed >= sampleSeconds * 1_000_000_000L || count == INTERVALS.length) finish();
    }

    private static void load() {
        loaded = true;
        try {
            if (!Files.exists(REQUEST)) { phase = Phase.COMPLETE; return; }
            JsonObject json = new com.google.gson.Gson().fromJson(Files.readString(REQUEST), JsonObject.class);
            if (json == null || !json.has("enabled") || !json.get("enabled").getAsBoolean()) {
                phase = Phase.COMPLETE; return;
            }
            label = json.has("label") ? json.get("label").getAsString() : label;
            warmupSeconds = clamp(json.has("warmupSeconds") ? json.get("warmupSeconds").getAsInt() : 30, 5, 300);
            sampleSeconds = clamp(json.has("sampleSeconds") ? json.get("sampleSeconds").getAsInt() : 60, 10, 600);
            var mode = FrameGenerationController.Mode.valueOf(json.has("mode")
                ? json.get("mode").getAsString().toUpperCase() : "OFF");
            FrameGenerationController.request(mode);
            AstFPSConfig.saveFrameGenerationMode(mode);
        } catch (Exception error) {
            phase = Phase.COMPLETE;
            LOGGER.error("Invalid auto benchmark request; benchmark disabled", error);
        }
    }

    private static void finish() {
        phase = Phase.COMPLETE;
        try {
            long[] values = Arrays.copyOf(INTERVALS, count);
            FrameStats stats = FrameStats.calculate(values);
            double seconds = sampleElapsed / 1_000_000_000.0;
            long nativeFrames = AstFPSRuntime.nativeWorldFramesPresented - nativeStart;
            long generatedFrames = AstFPSRuntime.generatedWorldFramesPresented - generatedStart;
            var report = new LinkedHashMap<String, Object>();
            report.put("label", label);
            report.put("time", Instant.now().toString());
            report.put("warmupSeconds", warmupSeconds);
            report.put("sampleSecondsActual", seconds);
            report.put("statistics", stats);
            report.put("presentationFrames", count);
            report.put("presentationFps", count / seconds);
            report.put("nativeWorldFrames", nativeFrames);
            report.put("nativeWorldFps", nativeFrames / seconds);
            report.put("generatedWorldFrames", generatedFrames);
            report.put("generatedWorldFps", generatedFrames / seconds);
            report.put("frameGenerationDecision", FrameGenerationController.decision());
            report.put("adaptivePolicy", AdaptiveRuntime.snapshot());
            report.put("stutters", AdaptiveRuntime.stutters());
            report.put("syntheticWorldExtractionsSkipped", AstFPSRuntime.syntheticWorldExtractionsSkipped);
            report.put("intervalsNanos", values);
            Path directory = FabricLoader.getInstance().getGameDir().resolve("astfps-benchmarks");
            Files.createDirectories(directory);
            Path output = directory.resolve("auto-" + safe(label) + "-" + System.currentTimeMillis() + ".json");
            Files.writeString(output, SafeJson.pretty().toJson(report));
            JsonObject request = new com.google.gson.Gson().fromJson(Files.readString(REQUEST), JsonObject.class);
            request.addProperty("enabled", false);
            Files.writeString(REQUEST, SafeJson.pretty().toJson(request));
            LOGGER.info("ASTFPS-BENCHMARK-COMPLETE {}", output);
        } catch (Exception error) {
            LOGGER.error("Unable to save automatic benchmark", error);
        }
    }

    private static int clamp(int value, int low, int high) { return Math.max(low, Math.min(high, value)); }
    private static String safe(String value) { return value.replaceAll("[^A-Za-z0-9._-]", "_").substring(0, Math.min(80, value.length())); }
}
