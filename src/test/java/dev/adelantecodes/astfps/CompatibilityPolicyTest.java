package dev.adelantecodes.astfps;

import dev.adelantecodes.astfps.compat.CompatibilityPolicy;
import java.util.Set;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

final class CompatibilityPolicyTest {
    @Test void isolatesNonRendererOverlaps() {
        Set<String> loaded = Set.of("entity-view-distance");
        assertEquals("entity-view-distance", CompatibilityPolicy.conflict(
            CompatibilityPolicy.Subsystem.ENTITY_DISTANCE, loaded));
        assertNull(CompatibilityPolicy.conflict(CompatibilityPolicy.Subsystem.TERRAIN_SUBMISSION, loaded));
    }

    @Test void rendererReplacementProtectsGraphicsSubsystems() {
        assertEquals("sodium", CompatibilityPolicy.conflict(
            CompatibilityPolicy.Subsystem.FRAME_GENERATION, Set.of("sodium")));
        assertEquals("sodium", CompatibilityPolicy.conflict(
            CompatibilityPolicy.Subsystem.TERRAIN_SUBMISSION, Set.of("sodium")));
        assertNull(CompatibilityPolicy.conflict(
            CompatibilityPolicy.Subsystem.VISIBILITY, Set.of("sodium")));
    }
}
