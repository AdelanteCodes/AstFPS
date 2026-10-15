package dev.adelantecodes.astfps;

import dev.adelantecodes.astfps.gpu.RegionArenaAllocator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

final class RegionArenaAllocatorTest {
    @Test void alignsAllocationsAndRejectsExhaustion() {
        var arena = new RegionArenaAllocator(256, 16);
        var first = arena.allocate(1);
        var second = arena.allocate(17);
        assertNotNull(first); assertNotNull(second);
        assertEquals(0, first.offset()); assertEquals(16, first.length());
        assertEquals(16, second.offset()); assertEquals(32, second.length());
        assertEquals(48, arena.used());
        assertNull(arena.allocate(225));
    }

    @Test void coalescesReleasedRanges() {
        var arena = new RegionArenaAllocator(128, 16);
        var a = arena.allocate(32); var b = arena.allocate(32); var c = arena.allocate(64);
        assertNotNull(a); assertNotNull(b); assertNotNull(c);
        assertTrue(arena.release(b)); assertTrue(arena.release(a));
        var merged = arena.allocate(64);
        assertNotNull(merged); assertEquals(0, merged.offset());
    }

    @Test void staleAndDoubleReleasesAreRejected() {
        var arena = new RegionArenaAllocator(64, 16);
        var handle = arena.allocate(16);
        assertTrue(arena.isLive(handle));
        assertTrue(arena.release(handle));
        assertFalse(arena.isLive(handle));
        assertFalse(arena.release(handle));
    }

    @Test void validatesConstructionAndRequests() {
        assertThrows(IllegalArgumentException.class, () -> new RegionArenaAllocator(0, 16));
        assertThrows(IllegalArgumentException.class, () -> new RegionArenaAllocator(64, 3));
        var arena = new RegionArenaAllocator(64, 16);
        assertThrows(IllegalArgumentException.class, () -> arena.allocate(0));
    }
}
