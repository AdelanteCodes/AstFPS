package dev.adelantecodes.astfps.client.render;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import dev.adelantecodes.astfps.client.AstFPSRuntime;
import net.minecraft.client.renderer.chunk.RenderSectionRegion;
import net.minecraft.core.BlockPos;
import net.minecraft.core.SectionPos;
import net.minecraft.world.level.block.state.BlockState;

/** Original compile-scoped lookup memo. Retained arrays contain no states between jobs. */
public final class SectionStateCache {
    private static final int EDGE = 20;
    private static final boolean VERIFY = Boolean.getBoolean("astfps.verifySectionStateCache");
    private final BlockState[] states = new BlockState[EDGE * EDGE * EDGE];
    // One bit per occupied slot: 125 longs / 1,000 payload bytes instead of
    // 8,000 shorts / 16,000 bytes. Worker confined, cleared after every job.
    private final long[] touched = new long[(states.length + 63) >>> 6];
    private int originX, originY, originZ;
    private RenderSectionRegion region;
    private boolean reading;
    private long hits, misses, bypasses, mismatches;

    SectionStateCache() { }

    void begin(SectionPos position, RenderSectionRegion region) {
        this.region = region;
        originX = position.minBlockX() - 2;
        originY = position.minBlockY() - 2;
        originZ = position.minBlockZ() - 2;
    }

    void finish() {
        discard();
        if (hits != 0) AstFPSRuntime.sectionStateHits.add(hits);
        if (misses != 0) AstFPSRuntime.sectionStateMisses.add(misses);
        if (bypasses != 0) AstFPSRuntime.sectionStateBypasses.add(bypasses);
        if (mismatches != 0) AstFPSRuntime.sectionStateMismatches.add(mismatches);
        hits = misses = bypasses = mismatches = 0;
    }

    public void discard() {
        for (int word = 0; word < touched.length; word++) {
            long bits = touched[word];
            while (bits != 0) {
                states[(word << 6) + Long.numberOfTrailingZeros(bits)] = null;
                bits &= bits - 1;
            }
            touched[word] = 0;
        }
        region = null;
        reading = false;
    }

    public static BlockState get(RenderSectionRegion region, BlockPos position, Operation<BlockState> original) {
        SectionStateCache cache = SectionCompilationContext.state();
        if (cache == null) {
            AstFPSRuntime.sectionStateBypasses.increment();
            return original.call(position);
        }
        return cache.read(region, position, original);
    }

    private BlockState read(RenderSectionRegion source, BlockPos position, Operation<BlockState> original) {
        // get() already checked the current global scope; do not add a second ThreadLocal lookup on hits.
        if (source != region || source.getClass() != RenderSectionRegion.class || reading) {
            bypasses++;
            return original.call(position);
        }
        int x = position.getX() - originX;
        int y = position.getY() - originY;
        int z = position.getZ() - originZ;
        if (x < 0 || y < 0 || z < 0 || x >= EDGE || y >= EDGE || z >= EDGE) {
            bypasses++;
            return original.call(position);
        }
        int index = (y * EDGE + z) * EDGE + x;
        BlockState cached = states[index];
        if (cached != null && !VERIFY) {
            hits++;
            return cached;
        }
        reading = true;
        BlockState actual;
        try {
            actual = original.call(position);
        } finally {
            reading = false;
        }
        // Hooks may mutate a MutableBlockPos, disable the gate, or enter another compile.
        if (position.getX() != x + originX || position.getY() != y + originY || position.getZ() != z + originZ
                || source != region || !SectionCompilationContext.borrowing(SectionCompilationContext.STATE) || !AstFPSRuntime.SECTION_STATE_CACHE.enabled()) return actual;
        if (cached != null) {
            if (cached != actual) {
                mismatches++;
                discard();
                AstFPSRuntime.sectionStateFailure("RenderSectionRegion.getBlockState verification",
                        new IllegalStateException("Compile-local block-state result changed"));
            } else hits++;
            return actual;
        }
        misses++;
        if (actual != null) {
            touched[index >>> 6] |= 1L << (index & 63);
            states[index] = actual;
        }
        return actual;
    }
}
