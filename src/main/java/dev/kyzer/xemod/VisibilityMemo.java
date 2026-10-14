package dev.kyzer.xemod;

/**
 * Reuses only an identical visibility query from the same frame and frustum state.
 * This stores a previously computed result; it never approximates visibility.
 */
public final class VisibilityMemo {
    private final Thread owner = Thread.currentThread();
    private volatile boolean shared;
    private boolean valid;
    private long frame;
    private double x0, y0, z0, x1, y1, z1;
    private boolean visible;

    /** -1 means miss, 0 means a cached false, 1 means a cached true. */
    public int probe(long epoch, double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
        if (!exclusiveThread()) return -1;
        if (valid && frame == epoch && x0 == minX && y0 == minY && z0 == minZ
            && x1 == maxX && y1 == maxY && z1 == maxZ) return visible ? 1 : 0;
        return -1;
    }

    public void store(long epoch, double minX, double minY, double minZ, double maxX, double maxY, double maxZ, boolean result) {
        if (!exclusiveThread()) return;
        frame = epoch;
        x0 = minX; y0 = minY; z0 = minZ;
        x1 = maxX; y1 = maxY; z1 = maxZ;
        visible = result;
        valid = true;
    }

    public void invalidate() {
        if (owner != Thread.currentThread()) shared = true;
        valid = false;
    }

    private boolean exclusiveThread() {
        if (shared) return false;
        Thread current = Thread.currentThread();
        if (owner != current) { shared = true; return false; }
        return true;
    }
}
