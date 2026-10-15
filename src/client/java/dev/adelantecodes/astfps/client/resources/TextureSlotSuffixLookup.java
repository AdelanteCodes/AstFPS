package dev.adelantecodes.astfps.client.resources;

import dev.adelantecodes.astfps.FeatureGate;
import dev.adelantecodes.astfps.client.AstFPSRuntime;
import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.util.Map;
import net.minecraft.client.resources.model.sprite.Material;

/** Read-only native texture-slot lookup without allocating the suffix of a #reference. */
public final class TextureSlotSuffixLookup {
    public static final FeatureGate GATE = new FeatureGate("texture-slot-suffix");
    static { GATE.enable(hooksAvailable()); }

    private TextureSlotSuffixLookup() { }

    public static boolean hooksAvailable() {
        return !AstFPSRuntime.safeMode() && Boolean.getBoolean("astfps.enableTextureSlotSuffixLookup");
    }

    public static Material get(Map<String, Material> map, String reference) {
        if (!GATE.enabled() || map == null || reference == null || reference.isEmpty()
                || map.getClass() != Object2ObjectArrayMap.class
                || ((Object2ObjectArrayMap<?, ?>) map).defaultReturnValue() != null) {
            return map.get(reference.substring(1));
        }
        // Resolve private library layout only after startup, on an actual eligible map. A missing
        // layout uses the original operation; no library class receives a mixin or transformed fields.
        FieldAccess access = NativeAccess.FIELDS;
        if (access == null) return map.get(reference.substring(1));
        Object[] keys = (Object[]) access.keys.get(map);
        Object[] values = (Object[]) access.values.get(map);
        int size = (int) access.size.get(map);
        if (keys == null || values == null || size < 0 || size > keys.length || size > values.length) {
            return map.get(reference.substring(1));
        }
        int length = reference.length() - 1;
        // fastutil8.5.18 checks stored keys from last to first. Preserve that order and its null-key
        // handling. Custom raw keys must retain their own equals behavior through native get.
        for (int i = size - 1; i >= 0; i--) {
            Object key = keys[i];
            if (key == null) continue;
            if (!(key instanceof String name)) return map.get(reference.substring(1));
            if (name.length() == length && reference.regionMatches(1, name, 0, length)) {
                return (Material) values[i];
            }
        }
        return null;
    }

    private record FieldAccess(VarHandle keys, VarHandle values, VarHandle size) { }

    private static final class NativeAccess {
        private static final FieldAccess FIELDS = findFields();

        private static FieldAccess findFields() {
            try {
                var lookup = MethodHandles.privateLookupIn(Object2ObjectArrayMap.class, MethodHandles.lookup());
                return new FieldAccess(
                        lookup.findVarHandle(Object2ObjectArrayMap.class, "key", Object[].class),
                        lookup.findVarHandle(Object2ObjectArrayMap.class, "value", Object[].class),
                        lookup.findVarHandle(Object2ObjectArrayMap.class, "size", int.class));
            } catch (ReflectiveOperationException | SecurityException | LinkageError unavailable) {
                return null;
            }
        }
    }
}
