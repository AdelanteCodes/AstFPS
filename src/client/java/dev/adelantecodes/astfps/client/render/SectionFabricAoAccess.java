package dev.adelantecodes.astfps.client.render;

import net.minecraft.client.renderer.block.BlockModelLighter;

/** Private AstFPS contract for the exact, pinned Indigo helper. */
public interface SectionFabricAoAccess {
    BlockModelLighter.Cache astfpsLightCacheIdentity();
    void astfpsReleaseCompileReferences();
}
