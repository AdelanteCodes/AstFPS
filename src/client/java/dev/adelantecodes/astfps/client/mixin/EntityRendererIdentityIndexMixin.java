package dev.adelantecodes.astfps.client.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import dev.adelantecodes.astfps.client.render.RendererIdentityIndex;
import java.util.Map;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.world.entity.EntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(EntityRenderDispatcher.class)
public abstract class EntityRendererIdentityIndexMixin {
    @ModifyExpressionValue(method = "onResourceManagerReload", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/client/renderer/entity/EntityRenderers;createEntityRenderers(Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;)Ljava/util/Map;"))
    private Map<EntityType<?>, EntityRenderer<?, ?>> astfpsIndexEntityTypes(Map<EntityType<?>, EntityRenderer<?, ?>> original) {
        return RendererIdentityIndex.index(original, EntityType.class);
    }
}
