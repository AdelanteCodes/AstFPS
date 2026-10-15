package dev.adelantecodes.astfps.client.render;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.renderpearl.backend.opengl.FrameBufferAttachment;
import com.mojang.renderpearl.backend.opengl.FrameBufferCache;
import com.mojang.renderpearl.backend.opengl.GlTexture;
import com.mojang.renderpearl.backend.opengl.GlTextureView;
import dev.adelantecodes.astfps.FeatureGate;
import dev.adelantecodes.astfps.client.AstFPSRuntime;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import java.util.ArrayList;
import java.util.List;
import net.fabricmc.loader.api.FabricLoader;

/** Allocation-free native FBO-key lookup after bounded warmup; never creates/deletes/binds an FBO. */
public final class FboLookupProbe {
    public static final FeatureGate GATE = new FeatureGate("fbo-lookup-probe");
    public static long hits, misses, bypasses;
    public static final int MAX_COLOR_ATTACHMENTS = 16;
    private static final int MAX_DATA_LENGTH = (MAX_COLOR_ATTACHMENTS + 1) * 2;
    static { GATE.enable(hooksAvailable()); }

    private final FrameBufferCache.CacheKey key = new FrameBufferCache.CacheKey(List.of(), null, 0);
    private final FboLookupKeyAccess access;
    // Exact-length arrays preserve native Arrays.equals/hashCode, including null attachment slots.
    private final int[][] dataByLength = new int[MAX_DATA_LENGTH + 1][];
    private boolean reading;
    private int result;

    public FboLookupProbe() {
        access = key instanceof FboLookupKeyAccess keyAccess ? keyAccess : null;
        if (access != null) access.astfpsMarkLookupProbe();
    }

    public static boolean hooksAvailable() {
        return !AstFPSRuntime.safeMode() && dev.adelantecodes.astfps.client.AstFPSConfig.startupFlag("astfps.enableFboLookupProbe")
                && AstFPSRuntime.rendererConflict() == null && !FabricLoader.getInstance().isModLoaded("lomka");
    }

    private static boolean nativeList(List<?> attachments) {
        Class<?> type = attachments.getClass();
        if (type == ArrayList.class) return true;
        return switch (type.getName()) {
            case "java.util.Arrays$ArrayList", "java.util.ImmutableCollections$ListN",
                    "java.util.ImmutableCollections$List12", "java.util.Collections$SingletonList",
                    "java.util.Collections$EmptyList", "com.google.common.collect.RegularImmutableList",
                    "com.google.common.collect.SingletonImmutableList" -> true;
            default -> false;
        };
    }

    private static boolean nativeAttachment(FrameBufferAttachment attachment) {
        return attachment == null || attachment.getClass() == GlTexture.class || attachment.getClass() == GlTextureView.class;
    }

    public boolean find(Object2IntMap<FrameBufferCache.CacheKey> cache, List<FrameBufferAttachment> colors,
            FrameBufferAttachment depth, int mipOffset) {
        if (!GATE.enabled() || !RenderSystem.isOnRenderThread() || reading || access == null
                || cache.getClass() != Object2IntOpenHashMap.class || colors == null || !nativeList(colors)
                || !nativeAttachment(depth)) {
            bypasses++;
            return false;
        }
        int count = colors.size();
        if (count > MAX_COLOR_ATTACHMENTS) {
            bypasses++;
            return false;
        }
        reading = true;
        try {
            int length = (count + (depth != null ? 1 : 0)) * 2;
            int[] data = dataByLength[length];
            if (data == null) dataByLength[length] = data = new int[length];
            int hash = 1;
            for (int i = 0; i < count; i++) {
                FrameBufferAttachment attachment = colors.get(i);
                if (!nativeAttachment(attachment)) {
                    bypasses++;
                    return false;
                }
                int id = attachment == null ? 0 : attachment.glId();
                int mip = attachment == null ? 0 : attachment.fboMipLevel() + mipOffset;
                data[i * 2] = id;
                data[i * 2 + 1] = mip;
                hash = 31 * (31 * hash + id) + mip;
            }
            if (depth != null) {
                int id = depth.glId();
                int mip = depth.fboMipLevel() + mipOffset;
                data[count * 2] = id;
                data[count * 2 + 1] = mip;
                hash = 31 * (31 * hash + id) + mip;
            }
            access.astfpsSetLookupData(data, hash);
            int value = cache.getInt(key);
            // Zero is the native default return value, but a stored zero is still a cache hit.
            if (value == cache.defaultReturnValue() && !cache.containsKey(key)) {
                misses++;
                return false;
            }
            result = value;
            hits++;
            return true;
        } finally {
            reading = false;
        }
    }

    public int result() { return result; }
}
