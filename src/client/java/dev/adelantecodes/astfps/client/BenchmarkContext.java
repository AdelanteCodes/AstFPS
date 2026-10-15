package dev.adelantecodes.astfps.client;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Options;

/** Captured only at user-requested benchmark boundaries, never in a frame loop. */
public final class BenchmarkContext {
    private BenchmarkContext() { }
    public static Map<String, Object> capture() {
        Minecraft client = Minecraft.getInstance();
        var options = client.options;
        Map<String, Object> context = new LinkedHashMap<>();
        context.put("javaVersion", System.getProperty("java.version"));
        context.put("astfpsProfile", AstFPSProfiles.current());
        context.put("safeMode", AstFPSRuntime.safeMode());
        context.put("startupRequests", Map.of(
            "varIntSize", dev.adelantecodes.astfps.client.AstFPSConfig.startupFlag("astfps.enableVarIntSize"),
            "compactIdentifiers", dev.adelantecodes.astfps.client.AstFPSConfig.startupFlag("astfps.enableCompactIdentifiers"),
            "packResourcePath", dev.adelantecodes.astfps.client.AstFPSConfig.startupFlag("astfps.enablePackResourcePath"),
            "rendererIdentityIndex", dev.adelantecodes.astfps.client.AstFPSConfig.startupFlag("astfps.enableRendererIdentityIndex"),
            "fboLookupProbe", dev.adelantecodes.astfps.client.AstFPSConfig.startupFlag("astfps.enableFboLookupProbe"),
            "zipEntryMissCache", dev.adelantecodes.astfps.client.AstFPSConfig.startupFlag("astfps.enableZipEntryMissCache"),
            "textureSlotSuffixLookup", dev.adelantecodes.astfps.client.AstFPSConfig.startupFlag("astfps.enableTextureSlotSuffixLookup"),
            "maximumBlockEntityDistance", dev.adelantecodes.astfps.client.AstFPSConfig.startupFlag("astfps.enableMaximumBlockEntityDistance")));
        // Requests alone do not prove installation; receipts also show overlap/safe-mode vetoes.
        context.put("hookReceipts", dev.adelantecodes.astfps.HookAudit.snapshot());
        context.put("sectionStateCacheEnabled", AstFPSRuntime.SECTION_STATE_CACHE.enabled());
        context.put("sectionWorkerCacheEnabled", AstFPSRuntime.SECTION_WORKER_CACHE.enabled());
        context.put("sectionMeshWorkspaceEnabled", AstFPSRuntime.SECTION_MESH_WORKSPACE.enabled());
        for (var experiment : AdditionalExperiments.ENTRIES) context.put(experiment.command(), experiment.gate().enabled());
        context.put("terrainBatcherEnabled", AstFPSRuntime.TERRAIN_BATCHER.enabled());
        context.put("os", System.getProperty("os.name"));
        context.put("osArch", System.getProperty("os.arch"));
        context.put("availableProcessors", Runtime.getRuntime().availableProcessors());
        context.put("maxHeapBytes", Runtime.getRuntime().maxMemory());
        context.put("gpuImplementation", RenderSystem.getDevice().getClass().getName());
        context.put("framebufferWidth", client.getWindow().getWidth());
        context.put("framebufferHeight", client.getWindow().getHeight());
        context.put("renderDistance", options.renderDistance().get());
        context.put("effectiveRenderDistance", options.getEffectiveRenderDistance());
        context.put("simulationDistance", options.simulationDistance().get());
        context.put("fpsLimit", options.framerateLimit().get());
        context.put("fpsUnlimited", options.framerateLimit().get() >= Options.UNLIMITED_FRAMERATE_CUTOFF);
        context.put("preferredGraphicsBackend", options.preferredGraphicsBackend().get().name());
        context.put("graphicsPreset", options.graphicsPreset().get().name());
        context.put("cloudStatus", options.cloudStatus().get().name());
        context.put("cloudRange", options.cloudRange().get());
        context.put("weatherRadius", options.weatherRadius().get());
        context.put("cutoutLeaves", options.cutoutLeaves().get());
        context.put("improvedTransparency", options.improvedTransparency().get());
        context.put("ambientOcclusion", options.ambientOcclusion().get());
        context.put("entityShadows", options.entityShadows().get());
        context.put("mipmapLevels", options.mipmapLevels().get());
        context.put("textureFiltering", options.textureFiltering().get().name());
        context.put("maxAnisotropyBit", options.maxAnisotropyBit().get());
        context.put("biomeBlendRadius", options.biomeBlendRadius().get());
        context.put("chunkSectionFadeInTime", options.chunkSectionFadeInTime().get());
        context.put("prioritizeChunkUpdates", options.prioritizeChunkUpdates().get().name());
        context.put("vsync", options.enableVsync().get());
        context.put("fov", options.fov().get());
        context.put("entityDistance", options.entityDistanceScaling().get());
        context.put("particles", options.particles().get().name());
        context.put("resourcePacks", List.copyOf(options.resourcePacks));
        return context;
    }
}
