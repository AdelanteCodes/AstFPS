package dev.adelantecodes.astfps.client.render;

import it.unimi.dsi.fastutil.ints.IntArrayFIFOQueue;
import java.util.NoSuchElementException;

/** FIFO semantics with no shrink on dequeue; native growth remains available for unusual hooks. */
final class SectionMeshWorkspaceQueue extends IntArrayFIFOQueue {
    SectionMeshWorkspaceQueue() {
        // Native VisGraph marks each of 4096 cells before enqueue, so 4097 ring slots suffice.
        super(4097);
    }

    @Override
    public void enqueue(int value) {
        int next = end + 1 == length ? 0 : end + 1;
        if (next == start) {
            // Preserve arbitrary queue input instead of failing after an algorithm has started.
            super.enqueue(value);
            return;
        }
        array[end] = value;
        end = next;
    }

    @Override
    public int dequeueInt() {
        if (start == end) throw new NoSuchElementException();
        int value = array[start];
        start = start + 1 == length ? 0 : start + 1;
        return value;
    }
}
