package dev.adelantecodes.astfps.gpu;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Driver-independent suballocator for persistent terrain arenas.
 * Handles carry generations so late async uploads cannot target recycled ranges.
 */
public final class RegionArenaAllocator {
    public record Handle(long id, int generation, long offset, long length) { }
    private record FreeRange(long offset, long length) { }
    private record Live(int generation, long offset, long length) { }

    private final long capacity;
    private final long alignment;
    private final ArrayList<FreeRange> free = new ArrayList<>();
    private final Map<Long, Live> live = new HashMap<>();
    private final Map<Long, Integer> generations = new HashMap<>();
    private long nextId = 1;
    private long used;

    public RegionArenaAllocator(long capacity, long alignment) {
        if (capacity <= 0) throw new IllegalArgumentException("capacity must be positive");
        if (alignment <= 0 || (alignment & (alignment - 1)) != 0)
            throw new IllegalArgumentException("alignment must be a positive power of two");
        this.capacity = capacity;
        this.alignment = alignment;
        free.add(new FreeRange(0, capacity));
    }

    public synchronized Handle allocate(long requestedLength) {
        if (requestedLength <= 0) throw new IllegalArgumentException("length must be positive");
        long length = align(requestedLength);
        for (int i = 0; i < free.size(); i++) {
            FreeRange range = free.get(i);
            long offset = align(range.offset());
            long padding = offset - range.offset();
            if (padding > range.length() || length > range.length() - padding) continue;
            free.remove(i);
            long prefix = padding;
            long suffixOffset = Math.addExact(offset, length);
            long suffix = range.length() - padding - length;
            if (prefix != 0) free.add(new FreeRange(range.offset(), prefix));
            if (suffix != 0) free.add(new FreeRange(suffixOffset, suffix));
            free.sort(Comparator.comparingLong(FreeRange::offset));
            long id = nextId++;
            int generation = generations.getOrDefault(id, 0) + 1;
            generations.put(id, generation);
            live.put(id, new Live(generation, offset, length));
            used = Math.addExact(used, length);
            return new Handle(id, generation, offset, length);
        }
        return null;
    }

    public synchronized boolean isLive(Handle handle) {
        if (handle == null) return false;
        Live allocation = live.get(handle.id());
        return allocation != null && allocation.generation() == handle.generation()
            && allocation.offset() == handle.offset() && allocation.length() == handle.length();
    }

    public synchronized boolean release(Handle handle) {
        if (!isLive(handle)) return false;
        live.remove(handle.id());
        used -= handle.length();
        free.add(new FreeRange(handle.offset(), handle.length()));
        coalesce();
        return true;
    }

    public synchronized long capacity() { return capacity; }
    public synchronized long used() { return used; }
    public synchronized long freeBytes() { return capacity - used; }
    public synchronized int liveAllocations() { return live.size(); }

    private long align(long value) {
        long mask = alignment - 1;
        return Math.addExact(value, mask) & ~mask;
    }

    private void coalesce() {
        free.sort(Comparator.comparingLong(FreeRange::offset));
        int write = 0;
        for (FreeRange range : free) {
            if (write != 0) {
                FreeRange previous = free.get(write - 1);
                if (previous.offset() + previous.length() == range.offset()) {
                    free.set(write - 1, new FreeRange(previous.offset(), previous.length() + range.length()));
                    continue;
                }
            }
            free.set(write++, range);
        }
        if (write < free.size()) free.subList(write, free.size()).clear();
    }
}
