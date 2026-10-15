package dev.adelantecodes.astfps.client.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import dev.adelantecodes.astfps.client.render.SectionFabricWorkspace;
import net.fabricmc.fabric.impl.client.indigo.renderer.aocalc.AoCalculator;
import net.fabricmc.fabric.impl.client.indigo.renderer.render.AltModelBlockRendererImpl;
import net.minecraft.client.renderer.block.BlockModelLighter;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = AltModelBlockRendererImpl.class, remap = false)
public abstract class SectionFabricAoFactoryMixin {
    @WrapOperation(method = "<init>", at = @At(value = "NEW",
            target = "net/fabricmc/fabric/impl/client/indigo/renderer/aocalc/AoCalculator"))
    private AoCalculator astfpsCompileAoScratch(BlockModelLighter.Cache cache, Operation<AoCalculator> original) {
        return SectionFabricWorkspace.acquire(this, cache, original);
    }
}
