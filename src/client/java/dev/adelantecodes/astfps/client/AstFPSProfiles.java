package dev.adelantecodes.astfps.client;

import java.util.Locale;
import net.minecraft.client.CloudStatus;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Options;
import net.minecraft.server.level.ParticleStatus;

/** Session profiles. Call from the client thread; deliberately never saves options to disk. */
public final class AstFPSProfiles {
    public enum Profile { QUALITY, BALANCED, MAXIMUM }

    private static Baseline baseline;
    private static String selected = "baseline";

    private AstFPSProfiles() { }

    public static String current() {
        return selected;
    }

    public static boolean maximum() { return "maximum".equals(selected); }

    public static String apply(Minecraft minecraft, Profile profile) {
        if (minecraft == null || profile == null) {
            return "Cannot apply profile: client or profile unavailable.";
        }
        if (!minecraft.isSameThread()) {
            return "Cannot apply profile outside the client thread.";
        }
        Options options = minecraft.options;
        if (baseline == null || baseline.owner() != options) {
            baseline = Baseline.capture(options);
        }
        // Apply each final value once: restoring first can trigger two terrain rebuilds.
        boolean quality = profile == Profile.QUALITY;
        boolean maximum = profile == Profile.MAXIMUM;
        options.cloudStatus().set(maximum ? CloudStatus.OFF : baseline.clouds());
        options.particles().set(maximum ? ParticleStatus.MINIMAL : baseline.particles());
        options.entityShadows().set(quality || (!maximum && baseline.shadows()));
        options.entityDistanceScaling().set(maximum
                ? Math.min(baseline.entityDistance(), 0.75) : baseline.entityDistance());
        options.biomeBlendRadius().set(quality ? Math.max(baseline.biomeBlend(), 2)
                : maximum ? 0 : baseline.biomeBlend());
        options.weatherRadius().set(maximum
                ? Math.min(baseline.weatherRadius(), 3) : baseline.weatherRadius());
        options.ambientOcclusion().set(quality || baseline.ambientOcclusion());
        options.cutoutLeaves().set(quality || (!maximum && baseline.cutoutLeaves()));
        options.improvedTransparency().set(quality || (!maximum && baseline.improvedTransparency()));
        // Native option owns renderer invalidation and server distance notification.
        // Preserve lower distances; never change simulation distance or resolution.
        options.renderDistance().set(maximum
                ? Math.min(baseline.renderDistance(), 8) : baseline.renderDistance());
        selected = profile.name().toLowerCase(Locale.ROOT);
        return switch (profile) {
            case QUALITY -> "Quality: high-fidelity native lighting, leaves, transparency and shadows; shader integration pending. Session settings only.";
            case BALANCED -> "Balanced: original visual settings restored. Session settings only.";
            case MAXIMUM -> "Maximum: clouds and entity shadows off; faster leaves/transparency, minimal particles, no biome blending, reduced weather/entity distance and terrain distance capped at 8 chunks. Compatible native chest/shulker rendering is capped at 32 blocks when its hook is available. Session settings only.";
        };
    }

    public static String restore(Minecraft minecraft) {
        if (minecraft == null) {
            return "Cannot restore profile: client unavailable.";
        }
        if (!minecraft.isSameThread()) {
            return "Cannot restore profile outside the client thread.";
        }
        if (baseline == null || baseline.owner() != minecraft.options) {
            baseline = null;
            selected = "baseline";
            return "No captured visual settings to restore.";
        }
        baseline.restore();
        baseline = null;
        selected = "baseline";
        return "Original visual settings restored. Vanilla may retain its Custom preset label.";
    }

    private record Baseline(Options owner, CloudStatus clouds, ParticleStatus particles,
                            boolean shadows, double entityDistance, int biomeBlend, int weatherRadius,
                            boolean ambientOcclusion, boolean cutoutLeaves,
                            boolean improvedTransparency, int renderDistance) {
        static Baseline capture(Options options) {
            return new Baseline(options, options.cloudStatus().get(), options.particles().get(),
                    options.entityShadows().get(), options.entityDistanceScaling().get(),
                    options.biomeBlendRadius().get(), options.weatherRadius().get(), options.ambientOcclusion().get(),
                    options.cutoutLeaves().get(), options.improvedTransparency().get(), options.renderDistance().get());
        }

        void restore() {
            owner.cloudStatus().set(clouds);
            owner.particles().set(particles);
            owner.entityShadows().set(shadows);
            owner.entityDistanceScaling().set(entityDistance);
            owner.biomeBlendRadius().set(biomeBlend);
            owner.weatherRadius().set(weatherRadius);
            owner.ambientOcclusion().set(ambientOcclusion);
            owner.cutoutLeaves().set(cutoutLeaves);
            owner.improvedTransparency().set(improvedTransparency);
            owner.renderDistance().set(renderDistance);
            // The preset listener reapplies many unrelated settings. Leave its label alone.
        }
    }
}
