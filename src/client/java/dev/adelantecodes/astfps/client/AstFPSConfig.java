package dev.adelantecodes.astfps.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import net.fabricmc.loader.api.FabricLoader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import dev.adelantecodes.astfps.client.render.FrameGenerationController;

public final class AstFPSConfig {
    private static final Gson JSON = new GsonBuilder().setPrettyPrinting().create();
    // Captured once before mixins are selected. Saving a preference cannot install a mixin mid-session.
    private static final JsonObject STARTUP = readStartup();
    private static final Set<String> DEFAULT_OPTIMIZATIONS = Set.of(
        "astfps.enableVisibilityMemo", "astfps.enableZeroOffsetReuse", "astfps.enableWorldTargetCleanup",
        "astfps.enableTerrainBatcher", "astfps.enableSectionWorkerCache", "astfps.enableSectionStateCache",
        "astfps.enableSectionMeshWorkspace", "astfps.enableSectionQuadFormat", "astfps.enableSectionFabricWorkspace",
        "astfps.enableModelRotationScratch", "astfps.enableTabListCache", "astfps.enablePackResourcePath",
        "astfps.enableRendererIdentityIndex", "astfps.enableVarIntSize", "astfps.enableCompactIdentifiers",
        "astfps.enableFboLookupProbe", "astfps.enableZipEntryMissCache", "astfps.enableTextureSlotSuffixLookup",
        "astfps.enableMaximumBlockEntityDistance");
    private static Path path() { return FabricLoader.getInstance().getConfigDir().resolve("astfps.json"); }

    private static JsonObject readStartup() {
        try { return read(); } catch (IOException | RuntimeException ignored) { return new JsonObject(); }
    }

    private static JsonObject read() throws IOException {
        if (!Files.exists(path())) return new JsonObject();
        JsonObject result = JSON.fromJson(Files.readString(path()), JsonObject.class);
        if (result == null) throw new IOException("Configuration is empty; original preserved");
        return result;
    }

    public static boolean startupFlag(String property) {
        String explicit = System.getProperty(property);
        if (explicit != null) return Boolean.parseBoolean(explicit);
        Boolean saved = savedFlag(STARTUP, property);
        return saved != null ? saved : DEFAULT_OPTIMIZATIONS.contains(property);
    }

    private static Boolean savedFlag(JsonObject json, String property) {
        try {
            if (!json.has("optimizations") || !json.getAsJsonObject("optimizations").has(property)) return null;
            return json.getAsJsonObject("optimizations").get(property).getAsBoolean();
        } catch (RuntimeException ignored) { return null; }
    }

    public static Map<String, Boolean> preferences(Iterable<String> properties) {
        JsonObject saved = readStartup();
        Map<String, Boolean> result = new LinkedHashMap<>();
        for (String property : properties) {
            Boolean value = savedFlag(saved, property);
            result.put(property, value != null ? value : DEFAULT_OPTIMIZATIONS.contains(property));
        }
        return result;
    }

    public static void savePreferences(Map<String, Boolean> values) throws IOException {
        JsonObject json;
        try { json = read(); } catch (RuntimeException e) { throw new IOException("Invalid configuration; original preserved", e); }
        JsonObject options = json.has("optimizations") ? json.getAsJsonObject("optimizations") : new JsonObject();
        values.forEach(options::addProperty);
        json.add("optimizations", options);
        json.addProperty("schemaVersion", 2);
        write(json);
    }

    private static void write(JsonObject config) throws IOException {
        Path file = path();
        Files.createDirectories(file.getParent());
        if (Files.exists(file)) Files.copy(file, file.resolveSibling("astfps.json.backup"), StandardCopyOption.REPLACE_EXISTING);
        Path temporary = Files.createTempFile(file.getParent(), "astfps-", ".tmp");
        try {
            Files.writeString(temporary, JSON.toJson(config));
            Files.move(temporary, file, StandardCopyOption.REPLACE_EXISTING);
        } finally { Files.deleteIfExists(temporary); }
    }

    public static boolean loadMemo() {
        try {
            if (!Files.exists(path())) return startupFlag("astfps.enableVisibilityMemo");
            JsonObject config = JSON.fromJson(Files.readString(path()), JsonObject.class);
            return config == null || !config.has("visibilityMemo")
                ? startupFlag("astfps.enableVisibilityMemo")
                : config.get("visibilityMemo").getAsBoolean();
        } catch (IOException | RuntimeException ignored) { return startupFlag("astfps.enableVisibilityMemo"); }
    }

    public static AstFPSProfiles.Profile loadProfile() {
        try {
            if (!Files.exists(path())) return AstFPSProfiles.Profile.BALANCED;
            JsonObject config = read();
            return AstFPSProfiles.Profile.valueOf(config.has("profile")
                ? config.get("profile").getAsString() : "BALANCED");
        } catch (IOException | RuntimeException ignored) { return AstFPSProfiles.Profile.BALANCED; }
    }

    public static void saveProfile(AstFPSProfiles.Profile profile) throws IOException {
        JsonObject json;
        try { json = read(); } catch (RuntimeException e) { throw new IOException("Invalid configuration; original preserved", e); }
        json.addProperty("profile", profile.name());
        json.addProperty("schemaVersion", 3);
        write(json);
    }

    public static AstFPSProfiles.Profile loadWorldProfile(String key) {
        if (key == null) return null;
        try { JsonObject json=read(); if(!json.has("worldProfiles"))return null;
            String value=json.getAsJsonObject("worldProfiles").has(key)?json.getAsJsonObject("worldProfiles").get(key).getAsString():null;
            return value==null?null:AstFPSProfiles.Profile.valueOf(value);
        } catch(IOException|RuntimeException ignored){return null;}
    }
    public static void saveWorldProfile(String key,AstFPSProfiles.Profile profile)throws IOException{
        if(key==null)return;JsonObject json=read();JsonObject worlds=json.has("worldProfiles")?json.getAsJsonObject("worldProfiles"):new JsonObject();
        worlds.addProperty(key,profile.name());json.add("worldProfiles",worlds);json.addProperty("schemaVersion",5);write(json);
    }

    public static FrameGenerationController.Mode loadFrameGenerationMode() {
        try {
            JsonObject config = read();
            return FrameGenerationController.Mode.valueOf(config.has("frameGeneration")
                ? config.get("frameGeneration").getAsString() : "AUTO");
        } catch (IOException | RuntimeException ignored) {
            return FrameGenerationController.Mode.AUTO;
        }
    }

    public static void saveFrameGenerationMode(FrameGenerationController.Mode mode) throws IOException {
        JsonObject json;
        try { json = read(); } catch (RuntimeException e) { throw new IOException("Invalid configuration; original preserved", e); }
        json.addProperty("frameGeneration", mode.name());
        json.addProperty("schemaVersion", 4);
        write(json);
    }

    public static void loadV1Features() {
        JsonObject json;
        try { json = read(); } catch (IOException | RuntimeException ignored) { return; }
        try { if (json.has("lowRam")) V1Features.lowRam(V1Features.LowRamMode.valueOf(json.get("lowRam").getAsString())); } catch (RuntimeException ignored) { }
        // Stable V1 deliberately disables the earlier experimental spatial scaler.
        V1Features.upscaling(V1Features.UpscalingMode.OFF);
        try { if (json.has("culling")) V1Features.culling(V1Features.Level.valueOf(json.get("culling").getAsString())); } catch (RuntimeException ignored) { }
        try { if (json.has("chunkSmoothing")) V1Features.chunkSmoothing(V1Features.Level.valueOf(json.get("chunkSmoothing").getAsString())); } catch (RuntimeException ignored) { }
        try { if (json.has("frameGenQuality")) V1Features.frameGenQuality(V1Features.FrameGenQuality.valueOf(json.get("frameGenQuality").getAsString())); } catch (RuntimeException ignored) { }
        try { if (json.has("latency")) V1Features.latency(V1Features.LatencyMode.valueOf(json.get("latency").getAsString())); } catch (RuntimeException ignored) { }
        try { if (json.has("fullBright")) V1Features.fullBright(json.get("fullBright").getAsBoolean()); } catch (RuntimeException ignored) { }
        try { if (json.has("performanceOverlay")) V1Features.overlay(json.get("performanceOverlay").getAsBoolean()); } catch (RuntimeException ignored) { }
        try { if (json.has("perWorldProfiles")) V1Features.perWorldProfiles(json.get("perWorldProfiles").getAsBoolean()); } catch (RuntimeException ignored) { }
        try { if (json.has("compatibilityProtection")) V1Features.compatibilityProtection(json.get("compatibilityProtection").getAsBoolean()); } catch (RuntimeException ignored) { }
    }

    public static void saveV1Features() throws IOException {
        JsonObject json;
        try { json = read(); } catch (RuntimeException e) { throw new IOException("Invalid configuration; original preserved", e); }
        json.addProperty("lowRam", V1Features.lowRam().name());
        json.addProperty("culling", V1Features.culling().name());
        json.addProperty("chunkSmoothing", V1Features.chunkSmoothing().name());
        json.addProperty("frameGenQuality", V1Features.frameGenQuality().name());
        json.addProperty("latency", V1Features.latency().name());
        json.addProperty("fullBright", V1Features.fullBright());
        json.addProperty("performanceOverlay", V1Features.overlay());
        json.addProperty("perWorldProfiles", V1Features.perWorldProfiles());
        json.addProperty("compatibilityProtection", V1Features.compatibilityProtection());
        json.addProperty("schemaVersion", 5);
        write(json);
    }

    public static void saveMemo(boolean value) throws IOException {
        Path file = path();
        JsonObject config = new JsonObject();
        if (Files.exists(file)) {
            try {
                config = JSON.fromJson(Files.readString(file), JsonObject.class);
                if (config == null) throw new IOException("Configuration is empty; original preserved");
            } catch (RuntimeException e) { throw new IOException("Configuration is invalid; original preserved", e); }
            Files.copy(file, file.resolveSibling("astfps.json.backup"), StandardCopyOption.REPLACE_EXISTING);
        }
        config.addProperty("schemaVersion", 1);
        config.addProperty("visibilityMemo", value);
        Files.createDirectories(file.getParent());
        Path temporary = Files.createTempFile(file.getParent(), "astfps-", ".tmp");
        try {
            Files.writeString(temporary, JSON.toJson(config));
            Files.move(temporary, file, StandardCopyOption.REPLACE_EXISTING);
        } finally { Files.deleteIfExists(temporary); }
    }
}
