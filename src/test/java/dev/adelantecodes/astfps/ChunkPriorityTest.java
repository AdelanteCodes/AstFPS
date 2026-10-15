package dev.adelantecodes.astfps;

import dev.adelantecodes.astfps.adaptive.ChunkPriority;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

final class ChunkPriorityTest {
    @Test void nearbyAndForwardWorkWins() {
        assertEquals(1, ChunkPriority.admissionCost(2, 0, 2, 0, 1));
        assertEquals(1, ChunkPriority.admissionCost(0, 0, 8, 0, 1));
        assertEquals(2, ChunkPriority.admissionCost(0, 0, -8, 0, 1));
        assertEquals(3, ChunkPriority.admissionCost(0, 0, -16, 0, 1));
    }
}
