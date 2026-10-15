package dev.adelantecodes.astfps.client.mixin;

import dev.adelantecodes.astfps.client.resources.TextureSlotSuffixLookup;
import java.util.Map;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.client.resources.model.sprite.TextureSlots;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

/** Startup opt-in; preserve native reference validation and every non-reference lookup. */
@Mixin(TextureSlots.class)
public abstract class TextureSlotSuffixMixin {
    @Shadow @Final private Map<String, Material> resolvedValues;
    @Shadow private static boolean isTextureReference(String name) { throw new AssertionError(); }

    /**
     * @author AstFPS contributors
     * @reason Avoid allocating a transient substring for native array-map texture references.
     */
    @Overwrite
    public Material getMaterial(String name) {
        if (!isTextureReference(name)) return resolvedValues.get(name);
        return TextureSlotSuffixLookup.get(resolvedValues, name);
    }
}
