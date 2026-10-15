package dev.adelantecodes.astfps.client.mixin;

import dev.adelantecodes.astfps.HookAudit;
import dev.adelantecodes.astfps.client.AstFPSRuntime;
import java.util.List;
import java.util.Set;
import org.objectweb.asm.tree.ClassNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;
import dev.adelantecodes.astfps.compat.CompatibilityPolicy;

public final class AstFPSMixinPlugin implements IMixinConfigPlugin {
    private static final Logger LOGGER = LoggerFactory.getLogger("AstFPS-Hooks");
    private static final boolean SAFE_MODE = Boolean.getBoolean("astfps.safeMode");
    @Override public void onLoad(String mixinPackage) { LOGGER.info("ASTFPS-STARTUP package={} safeMode={}", mixinPackage, SAFE_MODE); }
    @Override public String getRefMapperConfig() { return null; }
    @Override public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        if (mixinClassName.endsWith("FrameHistoryCaptureMixin") || mixinClassName.endsWith("SyntheticExtractionSkipMixin")) {
            boolean enabled = !SAFE_MODE && AstFPSRuntime.subsystemConflict(CompatibilityPolicy.Subsystem.FRAME_GENERATION) == null;
            HookAudit.record(mixinClassName, enabled
                ? "enabled: cross-vendor frame history and interpolation"
                : "disabled: safe mode or conflicting renderer");
            return enabled;
        }
        if (mixinClassName.endsWith("EntityDistanceCullingMixin")) {
            boolean enabled = !SAFE_MODE && AstFPSRuntime.subsystemConflict(CompatibilityPolicy.Subsystem.ENTITY_DISTANCE) == null;
            HookAudit.record(mixinClassName, enabled ? "enabled: conservative entity distance policy" : "disabled: safe mode or entity/render overlap");
            return enabled;
        }
        if (mixinClassName.endsWith("ChunkUpdateAdmissionMixin") || mixinClassName.endsWith("ChunkCompileSchedulingMixin")) {
            boolean enabled = !SAFE_MODE && AstFPSRuntime.subsystemConflict(CompatibilityPolicy.Subsystem.CHUNK_COMPILATION) == null;
            HookAudit.record(mixinClassName, enabled ? "enabled: adaptive native chunk pipeline" : "disabled: safe mode or chunk-renderer overlap");
            return enabled;
        }
        if (mixinClassName.endsWith("FrustumMemoMixin")) {
            boolean enabled = !SAFE_MODE && dev.adelantecodes.astfps.client.AstFPSConfig.startupFlag("astfps.enableVisibilityMemo")
                && AstFPSRuntime.subsystemConflict(CompatibilityPolicy.Subsystem.VISIBILITY) == null;
            HookAudit.record(mixinClassName, enabled ? "enabled: exact per-frame visibility memo" : "disabled: safe mode, preference, or visibility overlap");
            return enabled;
        }
        if (mixinClassName.endsWith("FboLookupKeyMixin") || mixinClassName.endsWith("FboLookupCacheMixin")) {
            // Avoid loading the helper's native CacheKey field type before its mixin is prepared.
            boolean enabled = !SAFE_MODE && dev.adelantecodes.astfps.client.AstFPSConfig.startupFlag("astfps.enableFboLookupProbe")
                && AstFPSRuntime.rendererConflict() == null
                && !net.fabricmc.loader.api.FabricLoader.getInstance().isModLoaded("lomka");
            HookAudit.record(mixinClassName, enabled ? "enabled: FBO lookup probe" : "disabled: FBO startup gate or overlap");
            return enabled;
        }
        if (mixinClassName.endsWith("TextureSlotSuffixMixin")) {
            boolean enabled = !SAFE_MODE && dev.adelantecodes.astfps.client.AstFPSConfig.startupFlag("astfps.enableTextureSlotSuffixLookup");
            HookAudit.record(mixinClassName, enabled ? "enabled: texture reference suffix lookup" : "disabled: texture lookup startup gate");
            return enabled;
        }
        if (mixinClassName.endsWith("ZipEntryMissCacheMixin")) {
            boolean enabled = !SAFE_MODE && dev.adelantecodes.astfps.client.AstFPSConfig.startupFlag("astfps.enableZipEntryMissCache")
                && !net.fabricmc.loader.api.FabricLoader.getInstance().isModLoaded("packforge")
                && !net.fabricmc.loader.api.FabricLoader.getInstance().isModLoaded("quick-pack");
            HookAudit.record(mixinClassName, enabled ? "enabled: bounded ZIP miss cache" : "disabled: ZIP startup gate or overlap");
            return enabled;
        }
        if (mixinClassName.endsWith("MaximumBlockEntityDistanceMixin")) {
            boolean enabled = !SAFE_MODE && dev.adelantecodes.astfps.client.AstFPSConfig.startupFlag("astfps.enableMaximumBlockEntityDistance")
                && AstFPSRuntime.rendererConflict() == null
                && !net.fabricmc.loader.api.FabricLoader.getInstance().isModLoaded("entity-view-distance");
            HookAudit.record(mixinClassName, enabled ? "enabled: Maximum-profile native container distance cap" : "disabled: distance startup gate or overlap");
            return enabled;
        }
        if (mixinClassName.endsWith("PlayerTabSnapshotMixin")) {
            boolean enabled = AstFPSRuntime.tabCacheHooksAvailable();
            HookAudit.record(mixinClassName, enabled ? "enabled: bounded tab sorting cache" : "disabled: tab startup gate or overlap");
            return enabled;
        }
        if (mixinClassName.endsWith("PackResourcePathMixin")) {
            boolean enabled = !SAFE_MODE && dev.adelantecodes.astfps.client.AstFPSConfig.startupFlag("astfps.enablePackResourcePath")
                && !net.fabricmc.loader.api.FabricLoader.getInstance().isModLoaded("packforge")
                && !net.fabricmc.loader.api.FabricLoader.getInstance().isModLoaded("quick-pack");
            HookAudit.record(mixinClassName, enabled ? "enabled: direct pack resource path construction" : "disabled: pack path startup gate or overlap");
            return enabled;
        }
        if (mixinClassName.endsWith("RendererIdentityIndexMixin")) {
            boolean enabled = dev.adelantecodes.astfps.client.render.RendererIdentityIndex.hooksAvailable();
            HookAudit.record(mixinClassName, enabled ? "enabled: reload-time renderer identity index" : "disabled: renderer index startup gate or overlap");
            return enabled;
        }
        if (mixinClassName.endsWith("VarIntSizeMixin")) {
            boolean enabled = !SAFE_MODE && dev.adelantecodes.astfps.client.AstFPSConfig.startupFlag("astfps.enableVarIntSize")
                && !net.fabricmc.loader.api.FabricLoader.getInstance().isModLoaded("krypton");
            HookAudit.record(mixinClassName, enabled ? "enabled: exact VarInt size experiment" : "disabled: VarInt startup gate or Krypton overlap");
            return enabled;
        }
        if (mixinClassName.contains("CompactIdentifier")) {
            boolean enabled = !SAFE_MODE && dev.adelantecodes.astfps.client.AstFPSConfig.startupFlag("astfps.enableCompactIdentifiers")
                && !net.fabricmc.loader.api.FabricLoader.getInstance().isModLoaded("resourcetrimmer");
            HookAudit.record(mixinClassName, enabled ? "enabled: compact identifier experiment" : "disabled: identifier startup gate or overlap");
            return enabled;
        }
        boolean optimization = mixinClassName.endsWith("FrustumMemoMixin") || mixinClassName.endsWith("AabbZeroOffsetMixin")
            || mixinClassName.endsWith("WorldTargetCleanupMixin") || mixinClassName.endsWith("TerrainBatchMixin")
            || mixinClassName.endsWith("EntityDistanceCullingMixin") || mixinClassName.endsWith("ChunkCompileSchedulingMixin")
            || mixinClassName.endsWith("EntityVisibilityExtractionMixin") || mixinClassName.endsWith("EntityVisibilityClockMixin")
            || mixinClassName.endsWith("ChunkUpdateAdmissionMixin")
            || mixinClassName.endsWith("SectionWorkerCacheMixin") || mixinClassName.endsWith("SectionStateCacheMixin")
            || mixinClassName.endsWith("RegionStateCacheMixin") || mixinClassName.contains("SectionMeshWorkspace")
            || mixinClassName.contains("SectionQuadFormat") || mixinClassName.contains("SectionFabric")
            || mixinClassName.endsWith("ModelRotationScratchMixin") || mixinClassName.endsWith("SectionCompilationScopeMixin");
        boolean apply = !(SAFE_MODE && optimization);
        if (mixinClassName.endsWith("SectionCompilationScopeMixin")) {
            boolean compileHooks = AstFPSRuntime.sectionCacheHooksAvailable() || AstFPSRuntime.sectionStateHooksAvailable()
                || AstFPSRuntime.sectionMeshHooksAvailable() || AstFPSRuntime.sectionQuadFormatHooksAvailable()
                || AstFPSRuntime.sectionFabricHooksAvailable() || (!SAFE_MODE && Boolean.getBoolean("astfps.profileStages"));
            if (!compileHooks) {
                HookAudit.record(mixinClassName, "disabled: no compilation experiment or timing opted in");
                return false;
            }
        }
        if (mixinClassName.endsWith("TerrainTimingMixin")) {
            if (SAFE_MODE || !Boolean.getBoolean("astfps.profileStages")) {
                HookAudit.record(mixinClassName, "disabled: optional method timing requires astfps.profileStages=true and safe mode off");
                return false;
            }
        }
        if (mixinClassName.contains("SectionMeshWorkspace") && !AstFPSRuntime.sectionMeshHooksAvailable()) {
            HookAudit.record(mixinClassName, "disabled: requires astfps.enableSectionMeshWorkspace=true, safe mode off, and no conflicting renderer");
            return false;
        }
        if (mixinClassName.contains("SectionQuadFormat") && !AstFPSRuntime.sectionQuadFormatHooksAvailable()) {
            HookAudit.record(mixinClassName, "disabled: native BLOCK format setup cache requires its startup opt-in and compatible renderer");
            return false;
        }
        if (mixinClassName.contains("SectionFabric") && !AstFPSRuntime.sectionFabricHooksAvailable()) {
            HookAudit.record(mixinClassName, "disabled: Indigo helper cache requires its startup opt-in, exact inspected Fabric versions and compatible renderer");
            return false;
        }
        if (mixinClassName.endsWith("ModelRotationScratchMixin") && !AstFPSRuntime.modelRotationHooksAvailable()) {
            HookAudit.record(mixinClassName, "disabled: model rotation scratch requires startup opt-in and no overlapping rotation helper mod");
            return false;
        }
        if (mixinClassName.endsWith("RegionStateCacheMixin")
                && !AstFPSRuntime.sectionStateHooksAvailable()) {
            HookAudit.record(mixinClassName, "disabled: requires astfps.enableSectionStateCache=true, safe mode off, no conflicting renderer or known dynamic region-state hook");
            return false;
        }
        if (mixinClassName.endsWith("SectionWorkerCacheMixin") && !AstFPSRuntime.sectionCacheHooksAvailable()) {
            HookAudit.record(mixinClassName, "disabled: requires astfps.enableSectionWorkerCache=true, safe mode off, and no conflicting renderer");
            return false;
        }
        if (mixinClassName.endsWith("TerrainBatchMixin") && !AstFPSRuntime.terrainHooksAvailable()) {
            HookAudit.record(mixinClassName, "disabled: requires astfps.enableTerrainBatcher=true, safe mode off, and no conflicting renderer");
            return false;
        }
        if (mixinClassName.endsWith("FrustumMemoMixin") && !dev.adelantecodes.astfps.client.AstFPSConfig.startupFlag("astfps.enableVisibilityMemo")) {
            HookAudit.record(mixinClassName, "disabled: experimental memo requires astfps.enableVisibilityMemo=true");
            return false;
        }
        if (mixinClassName.endsWith("AabbZeroOffsetMixin") && !dev.adelantecodes.astfps.client.AstFPSConfig.startupFlag("astfps.enableZeroOffsetReuse")) {
            HookAudit.record(mixinClassName, "disabled: experimental reuse requires astfps.enableZeroOffsetReuse=true");
            return false;
        }
        if (mixinClassName.endsWith("WorldTargetCleanupMixin") && !dev.adelantecodes.astfps.client.AstFPSConfig.startupFlag("astfps.enableWorldTargetCleanup")) {
            HookAudit.record(mixinClassName, "disabled: optional cleanup requires astfps.enableWorldTargetCleanup=true");
            return false;
        }
        if (mixinClassName.endsWith("AabbZeroOffsetMixin") && Boolean.getBoolean("astfps.disableZeroOffsetReuse")) {
            HookAudit.record(mixinClassName, "disabled by astfps.disableZeroOffsetReuse");
            return false;
        }
        if (mixinClassName.endsWith("WorldTargetCleanupMixin") && Boolean.getBoolean("astfps.disableWorldTargetCleanup")) {
            HookAudit.record(mixinClassName, "disabled by astfps.disableWorldTargetCleanup");
            return false;
        }
        if (!apply) HookAudit.record(mixinClassName, "disabled by astfps.safeMode");
        return apply;
    }
    @Override public void acceptTargets(Set<String> targets, Set<String> others) { }
    @Override public List<String> getMixins() { return null; }
    @Override public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
        HookAudit.record(mixinClassName, "applying to " + targetClassName);
        LOGGER.info("ASTFPS-HOOK-BEGIN {} -> {}", mixinClassName, targetClassName);
    }
    @Override public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
        HookAudit.record(mixinClassName, "applied to " + targetClassName);
        LOGGER.info("ASTFPS-HOOK-OK {} -> {}", mixinClassName, targetClassName);
    }
}
