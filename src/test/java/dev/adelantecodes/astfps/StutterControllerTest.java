package dev.adelantecodes.astfps;

import dev.adelantecodes.astfps.adaptive.StutterController;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

final class StutterControllerTest {
    @Test void classifiesDominantSignalsInSafeOrder() {
        var controller = new StutterController();
        assertEquals(StutterController.Cause.GC, controller.sample(40_000_000, 99, 100, 8, 1));
        assertEquals(StutterController.Cause.CHUNK_BACKLOG, controller.sample(40_000_000, 99, 100, 8, 1));
        assertEquals(StutterController.Cause.GPU_SATURATION, controller.sample(40_000_000, 99, 0, 8, 1));
        assertEquals(3, controller.snapshot().counts().values().stream().mapToLong(Long::longValue).sum());
    }
}
