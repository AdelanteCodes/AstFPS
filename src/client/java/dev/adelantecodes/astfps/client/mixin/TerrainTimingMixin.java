package dev.adelantecodes.astfps.client.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import dev.adelantecodes.astfps.StageTimings;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.chunk.ChunkSectionsToRender;
import org.joml.Matrix4fc;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(LevelRenderer.class)
public abstract class TerrainTimingMixin {
    @WrapMethod(method = "prepareChunkRenders")
    private ChunkSectionsToRender astfpsTimeDirect(Matrix4fc matrix, boolean ordered,
            Operation<ChunkSectionsToRender> original) {
        return astfpsTime(StageTimings.Stage.TERRAIN_DIRECT, matrix, ordered, original);
    }
    @WrapMethod(method = "prepareChunkRendersIndirect")
    private ChunkSectionsToRender astfpsTimeIndirect(Matrix4fc matrix, boolean ordered,
            Operation<ChunkSectionsToRender> original) {
        return astfpsTime(StageTimings.Stage.TERRAIN_INDIRECT, matrix, ordered, original);
    }
    @org.spongepowered.asm.mixin.Unique
    private static ChunkSectionsToRender astfpsTime(StageTimings.Stage stage, Matrix4fc matrix, boolean ordered,
            Operation<ChunkSectionsToRender> original) {
        var sample = StageTimings.begin(stage);
        boolean successful = false;
        try {
            var result = original.call(matrix, ordered);
            successful = true;
            return result;
        } finally { StageTimings.end(stage, sample, successful); }
    }
}
