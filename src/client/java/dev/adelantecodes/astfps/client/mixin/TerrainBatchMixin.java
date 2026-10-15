package dev.adelantecodes.astfps.client.mixin;

import dev.adelantecodes.astfps.client.AstFPSRuntime;
import dev.adelantecodes.astfps.client.render.AstFPSTerrainBatcher;
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
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LevelRenderer.class)
public abstract class TerrainBatchMixin {
    @Shadow private SectionRenderDispatcher sectionRenderDispatcher;
    @Shadow @Final private ObjectArrayList<SectionRenderDispatcher.RenderSection> visibleSections;
    @Shadow @Final private OptionsRenderState optionsRenderState;
    @Shadow @Final private TextureManager textureManager;
    @Unique private AstFPSTerrainBatcher.Workspace astfpsWorkspace;

    @Inject(method = "prepareChunkRendersIndirect", at = @At("HEAD"), cancellable = true)
    private void astfpsPrepareTerrain(Matrix4fc matrix, boolean orderedTransparency, CallbackInfoReturnable<ChunkSectionsToRender> callback) {
        astfpsPrepare(true, matrix, orderedTransparency, callback);
    }

    @Inject(method = "prepareChunkRenders", at = @At("HEAD"), cancellable = true)
    private void astfpsPrepareDirectTerrain(Matrix4fc matrix, boolean orderedTransparency, CallbackInfoReturnable<ChunkSectionsToRender> callback) {
        astfpsPrepare(false, matrix, orderedTransparency, callback);
    }

    @Unique
    private void astfpsPrepare(boolean indirect, Matrix4fc matrix, boolean orderedTransparency, CallbackInfoReturnable<ChunkSectionsToRender> callback) {
        if (!AstFPSRuntime.TERRAIN_BATCHER.enabled()) return;
        try {
            if (astfpsWorkspace == null) astfpsWorkspace = new AstFPSTerrainBatcher.Workspace();
            var atlas = textureManager.getTexture(TextureAtlas.LOCATION_BLOCKS).getTextureView();
            long allocatedBefore = astfpsWorkspace.uniformCallbacksAllocated();
            long reusedBefore = astfpsWorkspace.uniformCallbacksReused();
            try {
                callback.setReturnValue(AstFPSTerrainBatcher.prepare(astfpsWorkspace, indirect, sectionRenderDispatcher, visibleSections, matrix,
                    orderedTransparency, optionsRenderState.chunkSectionFadeInTime, atlas.getWidth(0), atlas.getHeight(0)));
            } finally {
                AstFPSRuntime.terrainUniformCallbacksAllocated += astfpsWorkspace.uniformCallbacksAllocated() - allocatedBefore;
                AstFPSRuntime.terrainUniformCallbacksReused += astfpsWorkspace.uniformCallbacksReused() - reusedBefore;
            }
        } catch (RuntimeException error) {
            astfpsWorkspace = null;
            AstFPSRuntime.terrainFailure(indirect ? "LevelRenderer.prepareChunkRendersIndirect" : "LevelRenderer.prepareChunkRenders", error);
        }
    }

    @Inject(method = "close", at = @At("RETURN"))
    private void astfpsReleaseWorkspace(CallbackInfo callback) { astfpsWorkspace = null; }
}
