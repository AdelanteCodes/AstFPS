package dev.adelantecodes.astfps;

/**
 * Reuses only an identical visibility query from the same frame and frustum state.
 * This stores a previously computed result; it never approximates visibility.
 */
public final class VisibilityMemo {
    private final Thread owner = Thread.currentThread();
    private volatile boolean shared;
    private static final int SLOTS = 256;
    private static final int MASK = SLOTS - 1;
    private final boolean[] valid = new boolean[SLOTS];
    private final long[] frame = new long[SLOTS];
    private final long[] bounds = new long[SLOTS * 6];
    private final boolean[] visible = new boolean[SLOTS];

    /** -1 means miss, 0 means a cached false, 1 means a cached true. */
    public int probe(long epoch, double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
        if (!exclusiveThread()) return -1;
        if (!Double.isFinite(minX) || !Double.isFinite(minY) || !Double.isFinite(minZ)
                || !Double.isFinite(maxX) || !Double.isFinite(maxY) || !Double.isFinite(maxZ)) return -1;
        long a = Double.doubleToRawLongBits(minX), b = Double.doubleToRawLongBits(minY);
        long c = Double.doubleToRawLongBits(minZ), d = Double.doubleToRawLongBits(maxX);
        long e = Double.doubleToRawLongBits(maxY), f = Double.doubleToRawLongBits(maxZ);
        int slot = slot(a, b, c, d, e, f);
        int base = slot * 6;
        if (valid[slot] && frame[slot] == epoch && bounds[base] == a && bounds[base + 1] == b
            && bounds[base + 2] == c && bounds[base + 3] == d && bounds[base + 4] == e
            && bounds[base + 5] == f) return visible[slot] ? 1 : 0;
        return -1;
    }

    public void store(long epoch, double minX, double minY, double minZ, double maxX, double maxY, double maxZ, boolean result) {
        if (!exclusiveThread()) return;
        // Nonfinite bounds can have engine-specific sentinel handling; always delegate those queries.
        if (!Double.isFinite(minX) || !Double.isFinite(minY) || !Double.isFinite(minZ)
                || !Double.isFinite(maxX) || !Double.isFinite(maxY) || !Double.isFinite(maxZ)) {
            return;
        }
        long a = Double.doubleToRawLongBits(minX), b = Double.doubleToRawLongBits(minY);
        long c = Double.doubleToRawLongBits(minZ), d = Double.doubleToRawLongBits(maxX);
        long e = Double.doubleToRawLongBits(maxY), f = Double.doubleToRawLongBits(maxZ);
        int slot = slot(a, b, c, d, e, f);
        int base = slot * 6;
        frame[slot] = epoch;
        bounds[base] = a; bounds[base + 1] = b; bounds[base + 2] = c;
        bounds[base + 3] = d; bounds[base + 4] = e; bounds[base + 5] = f;
        visible[slot] = result;
        valid[slot] = true;
    }

    public void invalidate() {
        if (owner != Thread.currentThread()) shared = true;
        java.util.Arrays.fill(valid, false);
    }

    private boolean exclusiveThread() {
        if (shared) return false;
        Thread current = Thread.currentThread();
        if (owner != current) { shared = true; return false; }
        return true;
    }

    private static int slot(long a, long b, long c, long d, long e, long f) {
        long hash = a * 0x9E3779B97F4A7C15L ^ Long.rotateLeft(b, 11) ^ Long.rotateLeft(c, 23)
            ^ Long.rotateLeft(d, 37) ^ Long.rotateLeft(e, 47) ^ Long.rotateLeft(f, 53);
        hash ^= hash >>> 33;
        hash *= 0xff51afd7ed558ccdL;
        return (int) hash & MASK;
    }
}
