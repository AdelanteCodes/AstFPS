package dev.adelantecodes.astfps.client.mixin;

import dev.adelantecodes.astfps.client.render.SectionFabricAoAccess;
import java.util.Arrays;
import java.util.BitSet;
import net.fabricmc.fabric.impl.client.indigo.renderer.aocalc.AoCalculator;
import net.minecraft.client.renderer.block.BlockAndTintGetter;
import net.minecraft.client.renderer.block.BlockModelLighter;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

/** Cleanup runs only on AstFPS's borrowed, exact-class helper, after the whole compile finishes. */
@Mixin(value = AoCalculator.class, remap = false)
public abstract class SectionFabricAoAccessMixin implements SectionFabricAoAccess {
    @Shadow @Final private BlockModelLighter.Cache lightCache;
    @Shadow private BlockAndTintGetter level;
    @Shadow private BlockState state;
    @Shadow private BlockPos pos;
    @Shadow @Final private BitSet completionFlags;
    @Shadow @Final private float[] w;
    @Shadow @Final public float[] ao;
    @Shadow @Final public int[] light;

    @Override public BlockModelLighter.Cache astfpsLightCacheIdentity() { return lightCache; }

    @Override public void astfpsReleaseCompileReferences() {
        level = null;
        state = null;
        pos = null;
        completionFlags.clear();
        Arrays.fill(w, 0);
        Arrays.fill(ao, 0);
        Arrays.fill(light, 0);
    }
}
