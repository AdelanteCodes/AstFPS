package dev.adelantecodes.astfps.gpu;

import java.util.ArrayDeque;
import java.util.EnumMap;

/** Priority scheduler that limits background renderer work by estimated frame cost. */
public final class FrameBudgetScheduler<T> {
    public enum Priority { IMMEDIATE, VISIBLE, BACKGROUND }
    public record Scheduled<T>(T work, Priority priority, long estimatedNanos) { }

    private static final long DEFAULT_ESTIMATE_NANOS = 250_000L;
    private final EnumMap<Priority, ArrayDeque<T>> queues = new EnumMap<>(Priority.class);
    private final EnumMap<Priority, Long> estimates = new EnumMap<>(Priority.class);

    public FrameBudgetScheduler() {
        for (Priority priority : Priority.values()) {
            queues.put(priority, new ArrayDeque<>());
            estimates.put(priority, DEFAULT_ESTIMATE_NANOS);
        }
    }

    public synchronized void submit(T work, Priority priority) {
        if (work == null || priority == null) throw new IllegalArgumentException("work and priority are required");
        queues.get(priority).addLast(work);
    }

    public synchronized Scheduled<T> poll(long remainingBudgetNanos) {
        if (remainingBudgetNanos < 0) throw new IllegalArgumentException("budget cannot be negative");
        for (Priority priority : Priority.values()) {
            ArrayDeque<T> queue = queues.get(priority);
            if (queue.isEmpty()) continue;
            long estimate = estimates.get(priority);
            // Immediate work preserves player feedback even when it exceeds the background budget.
            if (priority != Priority.IMMEDIATE && estimate > remainingBudgetNanos) return null;
            return new Scheduled<>(queue.removeFirst(), priority, estimate);
        }
        return null;
    }

    public synchronized void record(Priority priority, long actualNanos) {
        if (priority == null || actualNanos <= 0) return;
        long previous = estimates.get(priority);
        // 1/8 EWMA: stable enough for budgets, responsive to world/resource-pack changes.
        estimates.put(priority, previous + ((actualNanos - previous) >> 3));
    }

    public synchronized int queued(Priority priority) { return queues.get(priority).size(); }
    public synchronized int size() {
        int total = 0;
        for (var queue : queues.values()) total += queue.size();
        return total;
    }
    public synchronized void clear() { queues.values().forEach(ArrayDeque::clear); }
}
