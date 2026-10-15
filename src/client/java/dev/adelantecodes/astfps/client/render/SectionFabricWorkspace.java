package dev.adelantecodes.astfps.client.render;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import dev.adelantecodes.astfps.client.AstFPSRuntime;
import java.lang.ref.WeakReference;
import net.fabricmc.fabric.impl.client.indigo.renderer.aocalc.AoCalculator;
import net.fabricmc.fabric.impl.client.indigo.renderer.render.AltModelBlockRendererImpl;
import net.minecraft.client.renderer.block.BlockModelLighter;

/** One weakly retained lighting scratch helper per compiling worker; all owning renderers stay fresh. */
public final class SectionFabricWorkspace implements SectionCompilationParticipant {
    private WeakReference<AoCalculator> retained = new WeakReference<>(null);
    private AoCalculator borrowed;
    private boolean claimed;
    private boolean poisoned;

    SectionFabricWorkspace() { }

    @Override public void begin() {
        claimed = false;
        poisoned = false;
    }

    @Override public void poison() { poisoned = true; }

    @Override public void finish() {
        try {
            if (borrowed != null) {
                ((SectionFabricAoAccess) borrowed).astfpsReleaseCompileReferences();
                if (!poisoned && retained.get() != borrowed) retained = new WeakReference<>(borrowed);
            }
        } catch (RuntimeException error) {
            poisoned = true;
            AstFPSRuntime.sectionFabricFailure("AoCalculator.cleanup", error);
        } catch (Error error) {
            poisoned = true;
            throw error;
        } finally {
            borrowed = null;
            if (poisoned) retained.clear();
            claimed = false;
        }
    }

    public static AoCalculator acquire(Object owner, BlockModelLighter.Cache lightCache, Operation<AoCalculator> original) {
        SectionCompilationParticipant participant = SectionCompilationContext.fabric();
        SectionFabricWorkspace workspace = participant instanceof SectionFabricWorkspace nativeWorkspace ? nativeWorkspace : null;
        if (workspace == null || workspace.claimed || workspace.poisoned
                || !AstFPSRuntime.SECTION_FABRIC_WORKSPACE.enabled()
                || owner.getClass() != AltModelBlockRendererImpl.class) {
            AstFPSRuntime.fabricAoHelpersBypassed.increment();
            return original.call(lightCache);
        }
        workspace.claimed = true;
        AoCalculator calculator = workspace.retained.get();
        if (calculator != null && calculator.getClass() == AoCalculator.class
                && calculator instanceof SectionFabricAoAccess access && access.astfpsLightCacheIdentity() == lightCache) {
            workspace.borrowed = calculator;
            AstFPSRuntime.fabricAoHelpersReused.increment();
            return calculator;
        }
        // Delegate the constructor chain and never cache another mod's implementation.
        calculator = original.call(lightCache);
        AstFPSRuntime.fabricAoHelpersAllocated.increment();
        if (calculator.getClass() == AoCalculator.class && calculator instanceof SectionFabricAoAccess) {
            workspace.borrowed = calculator;
        }
        return calculator;
    }
}
