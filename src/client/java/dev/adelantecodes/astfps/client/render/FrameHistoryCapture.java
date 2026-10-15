package dev.adelantecodes.astfps.client.render;

import com.mojang.blaze3d.pipeline.RenderTarget;
import com.mojang.blaze3d.pipeline.TextureTarget;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.renderpearl.api.GpuFormat;
import dev.adelantecodes.astfps.client.AstFPSRuntime;

/** Two real world frames retained before GUI rendering; uses only the cross-vendor GPU API. */
public final class FrameHistoryCapture implements AutoCloseable {
    private final RenderTarget[] history = new RenderTarget[2];
    private int writeIndex;
    private int captured;
    private int width;
    private int height;
    private GpuFormat format;
    private GpuFormat depthFormat;

    public void capture(RenderTarget source) {
        RenderSystem.assertOnRenderThread();
        if (!FrameGenerationController.captureRequested() || source == null
                || source.getColorTexture() == null || source.getDepthTexture() == null
                || source.width <= 0 || source.height <= 0) {
            if (!FrameGenerationController.captureRequested()) close();
            return;
        }
        GpuFormat sourceFormat = source.getColorTexture().getFormat();
        GpuFormat sourceDepthFormat = source.getDepthTexture().getFormat();
        ensure(source.width, source.height, sourceFormat, sourceDepthFormat);
        history[writeIndex].copyColorFrom(source);
        history[writeIndex].copyDepthFrom(source);
        writeIndex ^= 1;
        captured = Math.min(2, captured + 1);
        AstFPSRuntime.frameHistoryCaptures++;
        FrameGenerationController.historyAvailable(captured == 2);
    }

    public boolean ready() { return captured == 2; }
    public RenderTarget previous() { return ready() ? history[writeIndex] : null; }
    public RenderTarget current() { return captured == 0 ? null : history[writeIndex ^ 1]; }
    public void presentPrevious(RenderTarget output) {
        if (ready()) output.copyColorFrom(previous());
    }
    public void presentCurrent(RenderTarget output) {
        RenderTarget current = current();
        if (current != null) output.copyColorFrom(current);
    }
    public void interpolate(RenderTarget output, int quarterStep) {
        if (!ready()) throw new IllegalStateException("Frame history is not ready");
        FrameInterpolationRenderer.render(previous(), current(), output, quarterStep);
    }

    /** Drops temporal continuity without reallocating GPU targets. */
    public void invalidate() {
        writeIndex = 0;
        captured = 0;
        FrameGenerationController.historyAvailable(false);
    }

    private void ensure(int newWidth, int newHeight, GpuFormat newFormat, GpuFormat newDepthFormat) {
        if (history[0] != null && width == newWidth && height == newHeight
                && format == newFormat && depthFormat == newDepthFormat) return;
        close();
        width = newWidth;
        height = newHeight;
        format = newFormat;
        depthFormat = newDepthFormat;
        history[0] = new TextureTarget("AstFPS frame history A", width, height, format, depthFormat);
        history[1] = new TextureTarget("AstFPS frame history B", width, height, format, depthFormat);
        AstFPSRuntime.frameHistoryReallocations++;
    }

    @Override public void close() {
        RenderSystem.assertOnRenderThread();
        for (int i = 0; i < history.length; i++) {
            if (history[i] != null) {
                history[i].destroyBuffers();
                history[i] = null;
            }
        }
        writeIndex = 0;
        captured = 0;
        width = height = 0;
        format = null;
        depthFormat = null;
        FrameGenerationController.historyAvailable(false);
    }
}
