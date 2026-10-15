package dev.adelantecodes.astfps.client.render;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.renderpearl.api.device.DeviceFeatures;
import com.mojang.renderpearl.api.device.DeviceInfo;

/** Vendor-neutral selection based only on capabilities reported by Minecraft's GPU abstraction. */
public final class RendererBackendSelector {
    public enum Tier { COMPATIBILITY, MULTI_DRAW, PERSISTENT_INDIRECT }

    public record Selection(Tier tier, String device, String vendor, String backend,
                            boolean persistentMapping, boolean multiDrawIndirect,
                            boolean shaderDrawParameters, String reason) { }

    private static volatile Selection selection = new Selection(Tier.COMPATIBILITY,
        "not initialized", "unknown", "unknown", false, false, false,
        "GPU capabilities have not been queried on the render thread yet");

    private RendererBackendSelector() { }

    public static void detect() {
        RenderSystem.assertOnRenderThread();
        DeviceInfo info = RenderSystem.getDevice().getDeviceInfo();
        DeviceFeatures features = info.features();
        Tier tier;
        String reason;
        if (features.persistentMapping() && features.multiDrawIndirect()
                && features.shaderDrawParameters()) {
            tier = Tier.PERSISTENT_INDIRECT;
            reason = "persistent mapping, indirect multi-draw and shader draw parameters available";
        } else if (features.multiDrawIndirect() || features.multiDrawDirectInterleaved()
                || features.multiDrawDirectSeparate()) {
            tier = Tier.MULTI_DRAW;
            reason = "multi-draw available; persistent indirect requirements incomplete";
        } else {
            tier = Tier.COMPATIBILITY;
            reason = "advanced draw features unavailable; retaining compatible submission path";
        }
        selection = new Selection(tier, info.name(), info.vendorName(), info.backendName(),
            features.persistentMapping(), features.multiDrawIndirect(),
            features.shaderDrawParameters(), reason);
    }

    public static Selection current() { return selection; }
}
