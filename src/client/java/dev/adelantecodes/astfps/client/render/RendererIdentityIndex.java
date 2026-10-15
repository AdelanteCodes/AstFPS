package dev.adelantecodes.astfps.client.render;

import com.google.common.collect.ImmutableMap;
import dev.adelantecodes.astfps.FeatureGate;
import dev.adelantecodes.astfps.client.AstFPSRuntime;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.BiConsumer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.entity.BlockEntityType;

/** Reload-only indexing of native identity-key renderer maps; no per-lookup mixin or cache scope. */
public final class RendererIdentityIndex {
    public static final FeatureGate GATE = new FeatureGate("renderer-identity-index");
    public static final LongAdder indexedMaps = new LongAdder();
    public static final LongAdder indexedEntries = new LongAdder();
    static { GATE.enable(hooksAvailable()); }

    private RendererIdentityIndex() { }

    public static boolean hooksAvailable() {
        return !AstFPSRuntime.safeMode() && dev.adelantecodes.astfps.client.AstFPSConfig.startupFlag("astfps.enableRendererIdentityIndex")
                && AstFPSRuntime.rendererConflict() == null
                && !FabricLoader.getInstance().isModLoaded("badoptimizations")
                && !FabricLoader.getInstance().isModLoaded("entity-view-distance");
    }

    public static <K, V> Map<K, V> index(Map<K, V> original, Class<?> nativeKeyClass) {
        if (!GATE.enabled() || (nativeKeyClass != EntityType.class && nativeKeyClass != BlockEntityType.class)
                || !(original instanceof ImmutableMap<?, ?>) || original.isEmpty()
                || !original.getClass().getName().equals("com.google.common.collect.RegularImmutableMap")) {
            return original;
        }
        IdentityHashMap<K, V> index = new IdentityHashMap<>(original.size());
        for (Map.Entry<K, V> entry : original.entrySet()) {
            // Exact native classes inherit Object equality/hashCode; subclasses may not.
            if (entry.getKey() == null || entry.getKey().getClass() != nativeKeyClass) return original;
            index.put(entry.getKey(), entry.getValue());
        }
        Map<K, V> result = Collections.unmodifiableMap(new IndexedMap<>(original, index, nativeKeyClass));
        indexedMaps.increment();
        indexedEntries.add(original.size());
        return result;
    }

    private static final class IndexedMap<K, V> extends AbstractMap<K, V> {
        private final Map<K, V> original;
        private final IdentityHashMap<K, V> index;
        private final Class<?> nativeKeyClass;

        private IndexedMap(Map<K, V> original, IdentityHashMap<K, V> index, Class<?> nativeKeyClass) {
            this.original = original;
            this.index = index;
            this.nativeKeyClass = nativeKeyClass;
        }

        private boolean nativeKey(Object key) { return key != null && key.getClass() == nativeKeyClass; }

        @Override public V get(Object key) {
            return nativeKey(key) ? index.get(key) : original.get(key);
        }

        @Override public V getOrDefault(Object key, V defaultValue) {
            return nativeKey(key) ? index.getOrDefault(key, defaultValue) : original.getOrDefault(key, defaultValue);
        }

        @Override public boolean containsKey(Object key) {
            return nativeKey(key) ? index.containsKey(key) : original.containsKey(key);
        }

        @Override public boolean containsValue(Object value) { return original.containsValue(value); }
        @Override public int size() { return original.size(); }
        @Override public boolean isEmpty() { return original.isEmpty(); }
        @Override public Set<Map.Entry<K, V>> entrySet() { return original.entrySet(); }
        @Override public void forEach(BiConsumer<? super K, ? super V> action) { original.forEach(action); }
    }
}
