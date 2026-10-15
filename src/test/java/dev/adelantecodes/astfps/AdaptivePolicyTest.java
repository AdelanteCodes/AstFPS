package dev.adelantecodes.astfps;

import dev.adelantecodes.astfps.adaptive.AdaptivePolicy;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

final class AdaptivePolicyTest {
    @Test void dropsQuicklyUnderSustainedPressureAndRecoversSlowly() {
        var policy = new AdaptivePolicy();
        AdaptivePolicy.Snapshot value = null;
        for (int i = 0; i < 20; i++) value = policy.sample(30_000_000, 98, 900, 1000, 8, 80);
        assertEquals(AdaptivePolicy.Tier.CONSERVATIVE, value.tier());
        for (int i = 0; i < 100; i++) value = policy.sample(8_000_000, 35, 300, 1000, 8, 0);
        assertEquals(AdaptivePolicy.Tier.CONSERVATIVE, value.tier());
        for (int i = 0; i < 300; i++) value = policy.sample(8_000_000, 35, 300, 1000, 8, 0);
        assertNotEquals(AdaptivePolicy.Tier.CONSERVATIVE, value.tier());
    }

    @Test void memoryPressureShrinksCachesAndWork() {
        var policy = new AdaptivePolicy();
        var value = policy.sample(16_000_000, 50, 900, 1000, 16, 0);
        assertTrue(value.memoryPressure());
        assertEquals(25, value.cacheScalePercent());
        assertTrue(value.chunkJobsPerFrame() <= 4);
    }

    @Test void measuredCompileCostReducesAdmissions() {
        var fast = new AdaptivePolicy();
        var slow = new AdaptivePolicy();
        for (int i = 0; i < 20; i++) {
            fast.recordChunkCompile(100_000);
            slow.recordChunkCompile(4_000_000);
        }
        AdaptivePolicy.Snapshot fastSnapshot = null, slowSnapshot = null;
        for (int i = 0; i < 8; i++) {
            fastSnapshot = fast.sample(8_000_000, 50, 300, 1000, 16, 0);
            slowSnapshot = slow.sample(8_000_000, 50, 300, 1000, 16, 0);
        }
        assertTrue(fastSnapshot.chunkJobsPerFrame() > slowSnapshot.chunkJobsPerFrame());
    }
}
