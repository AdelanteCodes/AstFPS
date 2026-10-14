package dev.adelantecodes.astfps.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import net.fabricmc.loader.api.FabricLoader;

public final class AstFPSConfig {
    private static final Gson JSON = new GsonBuilder().setPrettyPrinting().create();
    private static Path path() { return FabricLoader.getInstance().getConfigDir().resolve("astfps.json"); }

    public static boolean loadMemo() {
        try {
            if (!Files.exists(path())) return false;
            JsonObject config = JSON.fromJson(Files.readString(path()), JsonObject.class);
            return config != null && config.has("visibilityMemo") && config.get("visibilityMemo").getAsBoolean();
        } catch (IOException | RuntimeException ignored) { return false; }
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
