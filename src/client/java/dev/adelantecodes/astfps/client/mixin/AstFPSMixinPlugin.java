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

public final class AstFPSMixinPlugin implements IMixinConfigPlugin {
    private static final Logger LOGGER = LoggerFactory.getLogger("AstFPS-Hooks");
    private static final boolean SAFE_MODE = Boolean.getBoolean("astfps.safeMode");
    @Override public void onLoad(String mixinPackage) { LOGGER.info("ASTFPS-STARTUP package={} safeMode={}", mixinPackage, SAFE_MODE); }
    @Override public String getRefMapperConfig() { return null; }
    @Override public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        boolean optimization = mixinClassName.endsWith("FrustumMemoMixin") || mixinClassName.endsWith("AabbZeroOffsetMixin")
            || mixinClassName.endsWith("WorldTargetCleanupMixin") || mixinClassName.endsWith("TerrainBatchMixin")
            || mixinClassName.endsWith("SectionWorkerCacheMixin");
        boolean apply = !(SAFE_MODE && optimization);
        if (mixinClassName.endsWith("SectionWorkerCacheMixin") && !AstFPSRuntime.sectionCacheHooksAvailable()) {
            HookAudit.record(mixinClassName, "disabled: requires astfps.enableSectionWorkerCache=true, safe mode off, and no conflicting renderer");
            return false;
        }
        if (mixinClassName.endsWith("TerrainBatchMixin") && !AstFPSRuntime.terrainHooksAvailable()) {
            HookAudit.record(mixinClassName, "disabled: requires astfps.enableTerrainBatcher=true, safe mode off, and no conflicting renderer");
            return false;
        }
        if (mixinClassName.endsWith("FrustumMemoMixin") && !Boolean.getBoolean("astfps.enableVisibilityMemo")) {
            HookAudit.record(mixinClassName, "disabled: experimental memo requires astfps.enableVisibilityMemo=true");
            return false;
        }
        if (mixinClassName.endsWith("AabbZeroOffsetMixin") && !Boolean.getBoolean("astfps.enableZeroOffsetReuse")) {
            HookAudit.record(mixinClassName, "disabled: experimental reuse requires astfps.enableZeroOffsetReuse=true");
            return false;
        }
        if (mixinClassName.endsWith("WorldTargetCleanupMixin") && !Boolean.getBoolean("astfps.enableWorldTargetCleanup")) {
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
