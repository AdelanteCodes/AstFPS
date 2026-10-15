package dev.adelantecodes.astfps.client.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import dev.adelantecodes.astfps.client.render.SectionMeshWorkspace;
import java.util.EnumMap;
import net.minecraft.client.renderer.chunk.SectionCompiler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

/** Keep vanilla compilation and Fabric renderer callbacks; pool only their local collection storage. */
@Mixin(SectionCompiler.class)
public abstract class SectionMeshWorkspaceCompilerMixin {
    // Results owns a different EnumMap allocated in Results.<init>; that map must never be pooled.
    @SuppressWarnings("rawtypes")
    @WrapOperation(method = "compile", at = @At(value = "NEW", target = "java/util/EnumMap", ordinal = 0))
    private EnumMap astfpsMeshLayerMap(Class keyType, Operation<EnumMap> original) {
        return SectionMeshWorkspace.layers(keyType, original);
    }
}
