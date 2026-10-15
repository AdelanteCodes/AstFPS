package dev.adelantecodes.astfps;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryUsage;
import java.util.LinkedHashMap;
import java.util.Map;

/** Boundary-only JVM observations. Heap used includes uncollected garbage; none is an RSS measurement. */
public final class RuntimeMetrics {
    private RuntimeMetrics() { }
    public static Map<String, Object> capture() {
        var result = new LinkedHashMap<String, Object>();
        var memory = ManagementFactory.getMemoryMXBean();
        result.put("heap", memory(memory.getHeapMemoryUsage()));
        result.put("nonHeap", memory(memory.getNonHeapMemoryUsage()));
        result.put("uptimeMillis", ManagementFactory.getRuntimeMXBean().getUptime());
        result.put("threads", ManagementFactory.getThreadMXBean().getThreadCount());
        var collectors = new LinkedHashMap<String, Object>();
        for (var collector : ManagementFactory.getGarbageCollectorMXBeans()) {
            var data = new LinkedHashMap<String, Object>();
            data.put("collections", collector.getCollectionCount());
            data.put("approximateCollectionMillis", collector.getCollectionTime());
            collectors.put(collector.getName(), data);
        }
        result.put("garbageCollectors", collectors);
        result.put("scope", "JVM heap/nonheap and approximate collector counters at capture boundaries; not process resident RAM, GPU memory, live-object sizing or exclusive frame costs. No garbage collection is forced.");
        return result;
    }
    private static Map<String, Long> memory(MemoryUsage usage) {
        return Map.of("usedBytes", usage.getUsed(), "committedBytes", usage.getCommitted(), "maxBytes", usage.getMax());
    }
    public static Map<String, Object> collectionDeltas(Map<String, Object> start, Map<String, Object> end) {
        var result = new LinkedHashMap<String, Object>();
        if (start == null) return result;
        if (!(start.get("garbageCollectors") instanceof Map<?, ?> before)
                || !(end.get("garbageCollectors") instanceof Map<?, ?> after)) return result;
        for (var entry : after.entrySet()) {
            if (!(entry.getKey() instanceof String name) || !(entry.getValue() instanceof Map<?, ?> last)
                    || !(before.get(name) instanceof Map<?, ?> first)) continue;
            var delta = new LinkedHashMap<String, Object>();
            for (String field : new String[]{"collections", "approximateCollectionMillis"}) {
                if (first.get(field) instanceof Number initial && last.get(field) instanceof Number current) {
                    long a = initial.longValue(), b = current.longValue();
                    delta.put(field, a >= 0 && b >= a ? b - a : null);
                }
            }
            result.put(name, delta);
        }
        return result;
    }
}
