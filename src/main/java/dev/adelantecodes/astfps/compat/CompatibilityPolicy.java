package dev.adelantecodes.astfps.compat;

import java.util.Set;

/** Explicit subsystem isolation: one overlap never disables unrelated optimization work. */
public final class CompatibilityPolicy {
    public enum Subsystem { TERRAIN_SUBMISSION, CHUNK_COMPILATION, FRAME_GENERATION, VISIBILITY, ENTITY_DISTANCE }
    private static final Set<String> RENDERERS = Set.of(
        "sodium", "iris", "nvidium", "vulkanmod", "vulkanflow", "meshelium", "optifine", "optifabric");

    private CompatibilityPolicy() { }

    public static String conflict(Subsystem subsystem, Set<String> loaded) {
        if (subsystem == Subsystem.TERRAIN_SUBMISSION || subsystem == Subsystem.CHUNK_COMPILATION
                || subsystem == Subsystem.FRAME_GENERATION || subsystem == Subsystem.ENTITY_DISTANCE)
            for (String id : RENDERERS) if (loaded.contains(id)) return id;
        if (subsystem == Subsystem.ENTITY_DISTANCE && loaded.contains("entity-view-distance"))
            return "entity-view-distance";
        if (subsystem == Subsystem.VISIBILITY && loaded.contains("entityculling")) return "entityculling";
        return null;
    }
}
