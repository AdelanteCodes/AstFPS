package dev.kyzer.astfps.benchmark;

import com.google.gson.GsonBuilder;
import dev.kyzer.astfps.benchmark.mixin.CreateWorldInvoker;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.GraphicsPreset;
import net.minecraft.client.InactivityFpsLimit;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Screenshot;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.gui.screens.worldselection.CreateWorldScreen;
import net.minecraft.client.gui.screens.worldselection.WorldCreationUiState;
import net.minecraft.client.tutorial.TutorialSteps;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.animal.cow.Cow;
import net.minecraft.world.level.gamerules.GameRules;
import net.minecraft.world.level.levelgen.presets.WorldPresets;

/** Test-only automation. Runs the ordinary game loop, not Fabric's synchronized gametest loop. */
public final class BenchmarkClient implements ClientModInitializer {
    private static final String MODE = System.getProperty("astfps.benchmark.mode", "baseline");
    private static final long[] INTERVALS = new long[60_000];
    private static boolean started, creating, configured, measuring, completed;
    private static volatile boolean serverConfigured;
    private static long launchedAt, readyAt, stableAt, sampleAt, previous, hitsBefore, missesBefore;
    private static int count;

    @Override public void onInitializeClient() {
        ClientLifecycleEvents.CLIENT_STARTED.register(client -> {
            client.options.onboardAccessibility = false;
            client.options.tutorialStep = TutorialSteps.NONE;
            client.options.pauseOnLostFocus = false;
            client.options.applyGraphicsPreset(GraphicsPreset.FANCY);
            client.options.renderDistance().set(16);
            client.options.simulationDistance().set(8);
            client.options.enableVsync().set(false);
            client.options.framerateLimit().set(260);
            client.options.inactivityFpsLimit().set(InactivityFpsLimit.MINIMIZED);
            client.gui.setScreen(new TitleScreen());
            launchedAt = System.nanoTime();
            started = true;
            System.out.println("ASTFPS-BENCHMARK-START mode=" + MODE);
        });
    }

    public static void frame(Minecraft client) {
        if (!started || completed) return;
        long now = System.nanoTime();
        if (now - launchedAt > 600_000_000_000L) throw new IllegalStateException("Benchmark timed out before completion");
        if (!creating && client.gui.screen() instanceof TitleScreen && client.gui.overlay() == null) {
            creating = true;
            CreateWorldScreen.openFresh(client, () -> { throw new IllegalStateException("Benchmark world creation cancelled"); });
            CreateWorldScreen screen = (CreateWorldScreen) client.gui.screen();
            WorldCreationUiState settings = screen.getUiState();
            settings.setName("AstFPS comparison " + MODE);
            settings.setSeed("5600");
            settings.setGameMode(WorldCreationUiState.SelectedGameMode.CREATIVE);
            settings.setGenerateStructures(false);
            var flat = settings.getSettings().worldgenLoadContext().lookupOrThrow(Registries.WORLD_PRESET).getOrThrow(WorldPresets.FLAT);
            settings.setWorldType(new WorldCreationUiState.WorldTypeEntry(flat));
            settings.getGameRules().set(GameRules.ADVANCE_TIME, false, null);
            settings.getGameRules().set(GameRules.ADVANCE_WEATHER, false, null);
            settings.getGameRules().set(GameRules.SPAWN_MOBS, false, null);
            ((CreateWorldInvoker) screen).astfpsBenchmarkCreate();
            return;
        }
        if (client.level == null || client.player == null || client.gui.screen() != null || client.gui.overlay() != null) return;
        if (!configured) {
            configured = true;
            boolean installed = FabricLoader.getInstance().isModLoaded("astfps");
            if (installed != !MODE.equals("baseline")) throw new IllegalStateException("Wrong AstFPS presence for " + MODE);
            if (installed) setMemo(MODE.equals("memo"));
            var server = client.getSingleplayerServer();
            if (server == null) throw new IllegalStateException("Missing integrated server");
            server.execute(() -> {
                server.getCommands().performPrefixedCommand(server.createCommandSourceStack(), "tp @p 0.0 -60.0 0.0 180 0");
                server.getCommands().performPrefixedCommand(server.createCommandSourceStack(), "time set noon");
                for (int row = 0; row < 8; row++) {
                    for (int col = 0; col < 16; col++) {
                        Cow cow = new Cow(EntityTypes.COW, server.overworld());
                        cow.snapTo((col - 7.5) * 2, -60, -8 - row * 3);
                        cow.setNoAi(true);
                        cow.setNoGravity(true);
                        cow.setSilent(true);
                        server.overworld().addFreshEntity(cow);
                    }
                }
                serverConfigured = true;
            });
            readyAt = now;
            return;
        }
        if (!serverConfigured) return;
        if (!measuring) {
            // Wait for terrain work to settle, then allow JIT and graphics warm-up.
            if (client.levelRenderer.hasRenderedAllSections()) {
                if (stableAt == 0) stableAt = now;
            } else stableAt = 0;
            if (now - readyAt < 30_000_000_000L || stableAt == 0 || now - stableAt < 5_000_000_000L) return;
            if (Math.abs(client.player.getX()) > 0.1 || Math.abs(client.player.getZ()) > 0.1) throw new IllegalStateException("Player setup failed: " + client.player.position());
            measuring = true;
            sampleAt = previous = now;
            if (!MODE.equals("baseline")) {
                hitsBefore = runtimeCounter("visibilityHits");
                missesBefore = runtimeCounter("visibilityMisses");
            }
            System.out.println("ASTFPS-BENCHMARK-MEASURING mode=" + MODE);
            return;
        }
        long interval = now - previous;
        previous = now;
        if (interval > 0 && count < INTERVALS.length) INTERVALS[count++] = interval;
        if ((now - sampleAt >= 45_000_000_000L && count >= 120) || now - sampleAt >= 90_000_000_000L) finish(client);
    }

    private static void setMemo(boolean enabled) {
        try {
            Class<?> runtime = Class.forName("dev.kyzer.astfps.client.AstFPSRuntime");
            Object gate = runtime.getField("VISIBILITY_MEMO").get(null);
            gate.getClass().getMethod("enable", boolean.class).invoke(gate, enabled);
            if (gate.getClass().getMethod("failure").invoke(gate) != null) throw new IllegalStateException("AstFPS feature failed");
            if (!gate.getClass().getMethod("enabled").invoke(gate).equals(enabled)) throw new IllegalStateException("Wrong cache state");
        } catch (ReflectiveOperationException error) { throw new IllegalStateException(error); }
    }

    private static long runtimeCounter(String name) {
        try { return Class.forName("dev.kyzer.astfps.client.AstFPSRuntime").getField(name).getLong(null); }
        catch (ReflectiveOperationException error) { throw new IllegalStateException(error); }
    }

    private static void finish(Minecraft client) {
        completed = true;
        if (count < 60) throw new IllegalStateException("Insufficient benchmark samples: " + count);
        long[] intervals = Arrays.copyOf(INTERVALS, count);
        long[] sorted = intervals.clone();
        Arrays.sort(sorted);
        double total = 0, slowTotal = 0;
        for (long interval : intervals) total += interval;
        int slowCount = Math.max(1, (int) Math.ceil(count * 0.01));
        for (int i = count - slowCount; i < count; i++) slowTotal += sorted[i];
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("mode", MODE);
        result.put("minecraft", "26.3");
        result.put("modArtifact", "AstFPS-0.1.0-alpha.1.jar");
        result.put("renderDistance", client.options.renderDistance().get());
        result.put("simulationDistance", client.options.simulationDistance().get());
        result.put("width", client.getWindow().getScreenWidth());
        result.put("height", client.getWindow().getScreenHeight());
        result.put("vsync", client.options.enableVsync().get());
        result.put("fpsLimit", client.options.framerateLimit().get());
        result.put("graphicsPreset", client.options.graphicsPreset().get().toString());
        result.put("world", "flat seed 5600; fixed camera; 128 stationary cows; noon");
        result.put("cameraPosition", new double[]{client.player.getX(), client.player.getY(), client.player.getZ()});
        result.put("cameraAngles", new float[]{client.player.getYRot(), client.player.getXRot()});
        result.put("samples", count);
        result.put("averageFps", count * 1_000_000_000D / total);
        result.put("p99FrameTimeMs", sorted[(int) Math.ceil(count * 0.99) - 1] / 1_000_000D);
        result.put("onePercentLowFps", slowCount * 1_000_000_000D / slowTotal);
        result.put("intervalsNanos", intervals);
        Map<String, String> mods = new java.util.TreeMap<>();
        for (var mod : FabricLoader.getInstance().getAllMods()) mods.put(mod.getMetadata().getId(), mod.getMetadata().getVersion().getFriendlyString());
        result.put("loadedMods", mods);
        if (!MODE.equals("baseline")) {
            setMemo(MODE.equals("memo")); // also reject a failed feature before accepting the result
            result.put("visibilityHits", runtimeCounter("visibilityHits") - hitsBefore);
            result.put("visibilityMisses", runtimeCounter("visibilityMisses") - missesBefore);
        }
        result.put("limits", "GitHub hosted runner with Mesa software graphics; fixed synthetic scene; not home-PC or modpack FPS; no synchronized gametest framework");
        try {
            Files.writeString(client.gameDirectory.toPath().resolve("benchmark-result.json"), new GsonBuilder().setPrettyPrinting().create().toJson(result));
        } catch (java.io.IOException error) { throw new IllegalStateException(error); }
        System.out.println("ASTFPS-BENCHMARK-RESULT mode=" + MODE + " averageFps=" + result.get("averageFps") + " samples=" + count);
        Screenshot.grab(client, false);
        client.stop();
    }
}
