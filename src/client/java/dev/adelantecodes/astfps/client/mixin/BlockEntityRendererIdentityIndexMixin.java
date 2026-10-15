package dev.adelantecodes.astfps.client.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import dev.adelantecodes.astfps.client.render.RendererIdentityIndex;
import java.util.Map;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(BlockEntityRenderDispatcher.class)
public abstract class BlockEntityRendererIdentityIndexMixin {
    @ModifyExpressionValue(method = "onResourceManagerReload", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/client/renderer/blockentity/BlockEntityRenderers;createEntityRenderers(Lnet/minecraft/client/renderer/blockentity/BlockEntityRendererProvider$Context;)Ljava/util/Map;"))
    private Map<BlockEntityType<?>, BlockEntityRenderer<?, ?>> astfpsIndexBlockEntityTypes(Map<BlockEntityType<?>, BlockEntityRenderer<?, ?>> original) {
        return RendererIdentityIndex.index(original, BlockEntityType.class);
    }
}
