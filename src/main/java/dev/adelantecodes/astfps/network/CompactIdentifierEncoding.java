package dev.adelantecodes.astfps.network;

import java.util.function.Function;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.Identifier;

/** Optional protocol-equivalent omission of Minecraft's implicit default namespace. */
public final class CompactIdentifierEncoding {
    private static final String PREFIX = "minecraft:";
    private static final int MAX_NATIVE_STRING_LENGTH = 32767;
    private static final boolean ENABLED = hooksAvailable();

    private CompactIdentifierEncoding() { }

    public static boolean hooksAvailable() {
        return !Boolean.getBoolean("astfps.safeMode")
                && Boolean.getBoolean("astfps.enableCompactIdentifiers")
                && !FabricLoader.getInstance().isModLoaded("resourcetrimmer");
    }

    public static String compact(Identifier identifier, String encoded) {
        if (!ENABLED || identifier == null || encoded == null
                || !"minecraft".equals(identifier.getNamespace())
                || encoded.length() > MAX_NATIVE_STRING_LENGTH) return encoded;
        String path = identifier.getPath();
        // Preserve another encoder's noncanonical output and the native original-length error boundary.
        if (encoded.length() != PREFIX.length() + path.length()
                || !encoded.startsWith(PREFIX)
                || !encoded.regionMatches(PREFIX.length(), path, 0, path.length())) return encoded;
        return path;
    }

    public static Function<Identifier, String> wrap(Function<Identifier, String> original) {
        if (!ENABLED) return original;
        // Keep the original encoder's callbacks, failures and namespace policy before compacting.
        return identifier -> compact(identifier, original.apply(identifier));
    }
}
