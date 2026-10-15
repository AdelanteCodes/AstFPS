package dev.adelantecodes.astfps.client.render;

import com.mojang.blaze3d.pipeline.RenderTarget;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.renderpearl.api.commands.RenderPass;
import com.mojang.renderpearl.api.pipeline.BindGroupLayout;
import com.mojang.renderpearl.api.pipeline.ColorTargetState;
import com.mojang.renderpearl.api.pipeline.RenderPipeline;
import com.mojang.renderpearl.api.pipeline.UniformType;
import com.mojang.renderpearl.api.textures.FilterMode;
import java.util.Optional;
import java.util.OptionalDouble;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.resources.Identifier;
import dev.adelantecodes.astfps.client.AdaptiveRuntime;
import dev.adelantecodes.astfps.adaptive.AdaptivePolicy;
import dev.adelantecodes.astfps.client.AstFPSRuntime;

/** Fullscreen cross-vendor history compositor. Scheduling remains controlled separately. */
public final class FrameInterpolationRenderer {
    private static final BindGroupLayout HISTORY_TEXTURES = BindGroupLayout.builder()
        .withUniform("PreviousSampler", UniformType.COMBINED_IMAGE_SAMPLER)
        .withUniform("CurrentSampler", UniformType.COMBINED_IMAGE_SAMPLER)
        .withUniform("PreviousDepthSampler", UniformType.COMBINED_IMAGE_SAMPLER)
        .withUniform("CurrentDepthSampler", UniformType.COMBINED_IMAGE_SAMPLER)
        .build();
    private static final RenderPipeline QUARTER_FAST = pipeline("quarter_fast", 0.25f, 1);
    private static final RenderPipeline HALF_FAST = pipeline("half_fast", 0.50f, 1);
    private static final RenderPipeline THREE_QUARTER_FAST = pipeline("three_quarter_fast", 0.75f, 1);
    private static final RenderPipeline QUARTER_QUALITY = pipeline("quarter_quality", 0.25f, 2);
    private static final RenderPipeline HALF_QUALITY = pipeline("half_quality", 0.50f, 2);
    private static final RenderPipeline THREE_QUARTER_QUALITY = pipeline("three_quarter_quality", 0.75f, 2);

    private FrameInterpolationRenderer() { }

    /** Force static pipeline registration before the game's shader resource reload starts. */
    public static void register() { }

    public static void preflight() {
        RenderSystem.assertOnRenderThread();
        RenderSystem.getCompiledPipeline(QUARTER_FAST);
        RenderSystem.getCompiledPipeline(HALF_FAST);
        RenderSystem.getCompiledPipeline(THREE_QUARTER_FAST);
        RenderSystem.getCompiledPipeline(QUARTER_QUALITY);
        RenderSystem.getCompiledPipeline(HALF_QUALITY);
        RenderSystem.getCompiledPipeline(THREE_QUARTER_QUALITY);
    }

    private static RenderPipeline pipeline(String name, float weight, int radius) {
        return RenderPipelines.register(RenderPipeline.builder(RenderPipelines.POST_PROCESSING_SNIPPET)
            .withLocation(Identifier.fromNamespaceAndPath("astfps", "pipeline/frame_interpolation_" + name))
            .withVertexShader(Identifier.fromNamespaceAndPath("minecraft", "core/screenquad"))
            .withFragmentShader(Identifier.fromNamespaceAndPath("astfps", "core/frame_interpolate"))
            .withBindGroupLayout(HISTORY_TEXTURES)
            .withColorTargetState(ColorTargetState.DEFAULT)
            .withShaderDefine("ASTFPS_WEIGHT", weight)
            .withShaderDefine("ASTFPS_RADIUS", radius)
            .build());
    }

    public static void render(RenderTarget previous, RenderTarget current, RenderTarget output, int quarterStep) {
        RenderSystem.assertOnRenderThread();
        if (previous == null || current == null || output == null
                || previous.getDepthTextureView() == null || current.getDepthTextureView() == null)
            throw new IllegalArgumentException("history and output targets are required");
        var adaptive = AdaptiveRuntime.snapshot();
        boolean quality = adaptive.tier() == AdaptivePolicy.Tier.THROUGHPUT
            && (!Double.isFinite(adaptive.gpuUtilization()) || adaptive.gpuUtilization() < 72.0);
        if (quality) AstFPSRuntime.interpolationQualityFrames++;
        else AstFPSRuntime.interpolationFastFrames++;
        RenderPipeline pipeline = switch (quarterStep) {
            case 1 -> quality ? QUARTER_QUALITY : QUARTER_FAST;
            case 2 -> quality ? HALF_QUALITY : HALF_FAST;
            case 3 -> quality ? THREE_QUARTER_QUALITY : THREE_QUARTER_FAST;
            default -> throw new IllegalArgumentException("quarterStep must be 1, 2 or 3");
        };
        var encoder = RenderSystem.getDevice().createCommandEncoder();
        try (RenderPass pass = encoder.createRenderPass(() -> "AstFPS frame interpolation",
                output.getColorTextureView(), Optional.empty(), null, OptionalDouble.empty())) {
            pass.setPipeline(RenderSystem.getCompiledPipeline(pipeline));
            RenderSystem.bindDefaultUniforms(pass);
            var sampler = RenderSystem.getSamplerCache().getClampToEdge(FilterMode.LINEAR);
            pass.setUniform("PreviousSampler", previous.getColorTextureView(), sampler);
            pass.setUniform("CurrentSampler", current.getColorTextureView(), sampler);
            pass.setUniform("PreviousDepthSampler", previous.getDepthTextureView(), sampler);
            pass.setUniform("CurrentDepthSampler", current.getDepthTextureView(), sampler);
            pass.draw(0, 3, 0, 1);
        }
    }
}
