package dev.adelantecodes.astfps.client.mixin;

import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.FilePackResources;
import net.minecraft.server.packs.PackType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

/** Startup-gated construction of the native ZIP resource lookup path. */
@Mixin(FilePackResources.class)
public abstract class PackResourcePathMixin {
    /**
     * @author AstFPS contributors
     * @reason Preserve the three native String getters and separators without Formatter or its argument array.
     */
    @Overwrite
    private static String getPathFromLocation(PackType type, Identifier location) {
        return type.getDirectory() + "/" + location.getNamespace() + "/" + location.getPath();
    }
}
