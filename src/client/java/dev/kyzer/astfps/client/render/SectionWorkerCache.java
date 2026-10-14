package dev.kyzer.astfps.client.render;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import dev.kyzer.astfps.client.AstFPSRuntime;
import java.lang.ref.WeakReference;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.renderer.block.FluidRenderer;
import net.minecraft.client.renderer.block.FluidStateModelSet;
import net.minecraft.client.renderer.block.ModelBlockRenderer;

/** Worker-local weak cache; contains no strong renderer/model/world reference. */
public final class SectionWorkerCache {
    private WeakReference<ModelBlockRenderer> model = new WeakReference<>(null);
    private WeakReference<FluidRenderer> fluid = new WeakReference<>(null);
    private WeakReference<BlockColors> colors = new WeakReference<>(null);
    private boolean ao;
    private boolean cull;
    private int depth;
    public void enter() { depth++; }
    public void leave() { depth--; }
    public void discard() { model.clear(); fluid.clear(); colors.clear(); }
    public ModelBlockRenderer model(boolean ambientOcclusion, boolean cull, BlockColors colors, Operation<ModelBlockRenderer> original) {
        if (depth != 1) return original.call(ambientOcclusion, cull, colors);
        var renderer = model.get();
        if (renderer != null && this.colors.get() == colors && ao == ambientOcclusion && this.cull == cull) {
            AstFPSRuntime.sectionModelHelpersReused.increment(); return renderer;
        }
        renderer = original.call(ambientOcclusion, cull, colors);
        if (renderer.getClass() == ModelBlockRenderer.class) {
            model = new WeakReference<>(renderer); this.colors = new WeakReference<>(colors);
            ao = ambientOcclusion; this.cull = cull;
        } else model.clear();
        AstFPSRuntime.sectionModelHelpersAllocated.increment(); return renderer;
    }
    public FluidRenderer fluid(FluidStateModelSet models, Operation<FluidRenderer> original) {
        if (depth != 1) return original.call(models);
        var renderer = fluid.get();
        if (renderer != null && renderer.fluidModels == models) {
            AstFPSRuntime.sectionFluidHelpersReused.increment(); return renderer;
        }
        renderer = original.call(models);
        if (renderer.getClass() == FluidRenderer.class) fluid = new WeakReference<>(renderer);
        else fluid.clear();
        AstFPSRuntime.sectionFluidHelpersAllocated.increment(); return renderer;
    }
}
