package dev.adelantecodes.astfps.client.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.mojang.blaze3d.vertex.VertexSorting;
import dev.adelantecodes.astfps.client.render.SectionCompilationContext;
import net.minecraft.client.renderer.SectionBufferBuilderPack;
import net.minecraft.client.renderer.chunk.RenderSectionRegion;
import net.minecraft.client.renderer.chunk.SectionCompiler;
import net.minecraft.core.SectionPos;
import org.spongepowered.asm.mixin.Mixin;

/** One composable native compile wrapper; allocation/query hooks retain independent feature gates. */
@Mixin(SectionCompiler.class)
public abstract class SectionCompilationScopeMixin {
    @WrapMethod(method = "compile")
    private SectionCompiler.Results astfpsCompilationScope(SectionPos position, RenderSectionRegion region,
            VertexSorting sorting, SectionBufferBuilderPack builders, Operation<SectionCompiler.Results> original) {
        return SectionCompilationContext.compile(position, region, sorting, builders, original);
    }
}
