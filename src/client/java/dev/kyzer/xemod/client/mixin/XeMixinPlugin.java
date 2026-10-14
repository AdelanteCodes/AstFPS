package dev.kyzer.xemod.client.mixin;

import dev.kyzer.xemod.HookAudit;
import java.util.List;
import java.util.Set;
import org.objectweb.asm.tree.ClassNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

public final class XeMixinPlugin implements IMixinConfigPlugin {
    private static final Logger LOGGER = LoggerFactory.getLogger("Xe-Mod-Hooks");
    private static final boolean SAFE_MODE = Boolean.getBoolean("xe.safeMode");
    @Override public void onLoad(String mixinPackage) { LOGGER.info("XE-STARTUP package={} safeMode={}", mixinPackage, SAFE_MODE); }
    @Override public String getRefMapperConfig() { return null; }
    @Override public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        boolean apply = !(SAFE_MODE && mixinClassName.endsWith("FrustumMemoMixin"));
        if (!apply) HookAudit.record(mixinClassName, "disabled by xe.safeMode");
        return apply;
    }
    @Override public void acceptTargets(Set<String> targets, Set<String> others) { }
    @Override public List<String> getMixins() { return null; }
    @Override public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
        HookAudit.record(mixinClassName, "applying to " + targetClassName);
        LOGGER.info("XE-HOOK-BEGIN {} -> {}", mixinClassName, targetClassName);
    }
    @Override public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
        HookAudit.record(mixinClassName, "applied to " + targetClassName);
        LOGGER.info("XE-HOOK-OK {} -> {}", mixinClassName, targetClassName);
    }
}
