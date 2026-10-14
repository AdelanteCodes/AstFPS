package dev.kyzer.xemod.client.mixin;

import dev.kyzer.xemod.client.XeRuntime;
import dev.kyzer.xemod.client.render.XeTerrainBatcher;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.chunk.ChunkSectionsToRender;
import net.minecraft.client.renderer.chunk.SectionRenderDispatcher;
import net.minecraft.client.renderer.state.OptionsRenderState;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureManager;
import org.joml.Matrix4fc;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LevelRenderer.class)
public abstract class TerrainBatchMixin {
    @Shadow private SectionRenderDispatcher sectionRenderDispatcher;
    @Shadow @Final private ObjectArrayList<SectionRenderDispatcher.RenderSection> visibleSections;
    @Shadow @Final private OptionsRenderState optionsRenderState;
    @Shadow @Final private TextureManager textureManager;

    @Inject(method = "prepareChunkRendersIndirect", at = @At("HEAD"), cancellable = true)
    private void xePrepareTerrain(Matrix4fc matrix, boolean orderedTransparency, CallbackInfoReturnable<ChunkSectionsToRender> callback) {
        if (!XeRuntime.TERRAIN_BATCHER.enabled()) return;
        try {
            var atlas = textureManager.getTexture(TextureAtlas.LOCATION_BLOCKS).getTextureView();
            callback.setReturnValue(XeTerrainBatcher.prepare(sectionRenderDispatcher, visibleSections, matrix,
                orderedTransparency, optionsRenderState.chunkSectionFadeInTime, atlas.getWidth(0), atlas.getHeight(0)));
        } catch (RuntimeException error) {
            XeRuntime.terrainFailure("LevelRenderer.prepareChunkRendersIndirect", error);
        }
    }
}
