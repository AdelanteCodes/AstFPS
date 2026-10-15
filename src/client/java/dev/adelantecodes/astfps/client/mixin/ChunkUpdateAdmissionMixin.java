package dev.adelantecodes.astfps.client.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import dev.adelantecodes.astfps.client.AstFPSRuntime;
import dev.adelantecodes.astfps.client.render.ChunkUpdateAdmission;
import net.minecraft.client.Camera;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.SectionUpdateTracker;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.extract.LevelExtractor;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/** Bounds region snapshots and async mesh jobs before they enter vanilla's persistent-buffer pipeline. */
@Mixin(LevelExtractor.class)
public abstract class ChunkUpdateAdmissionMixin {
    @Shadow @Final private LevelRenderer levelRenderer;
    @Unique private final ChunkUpdateAdmission astfpsChunkAdmission = new ChunkUpdateAdmission();

    @Inject(method = "extract", at = @At("HEAD"))
    private void astfpsBeginChunkBudget(DeltaTracker delta, Camera camera, float partialTick, CallbackInfo ci) {
        var dispatcher = levelRenderer.sectionRenderDispatcher();
        var position = camera.position();
        var forward = camera.forwardVector();
        astfpsChunkAdmission.begin(dispatcher == null ? 0 : dispatcher.getCompileQueueSize(),
            position.x, position.y, position.z, forward.x(), forward.z());
    }

    @WrapOperation(method = "extract", at = @At(value = "INVOKE",
        target = "Lnet/minecraft/client/SectionUpdateTracker$SectionDirtyState;isDirty()Z"))
    private boolean astfpsAdmitDirtySection(SectionUpdateTracker.SectionDirtyState dirty,
            Operation<Boolean> original) {
        if (!original.call(dirty)) return false;
        boolean admitted = astfpsChunkAdmission.admit(dirty.getSectionNode(), dirty.isDirtyFromPlayer());
        if (admitted) AstFPSRuntime.chunkUpdatesAdmitted++;
        else AstFPSRuntime.chunkUpdatesDeferredByBudget++;
        return admitted;
    }
}
