package dev.adelantecodes.astfps.client.mixin;
import dev.adelantecodes.astfps.client.V1Features;
import net.minecraft.client.renderer.LightmapRenderStateExtractor;
import net.minecraft.client.renderer.state.LightmapRenderState;
import org.joml.Vector3f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/** Client-only lightmap override. It never changes blocks, packets, effects, or saved worlds. */
@Mixin(LightmapRenderStateExtractor.class)
public abstract class FullBrightLightmapMixin {
    private static final Vector3f ASTFPS_WHITE = new Vector3f(1.0f, 1.0f, 1.0f);
    @Inject(method="extract",at=@At("TAIL"))
    private void astfpsFullBright(LightmapRenderState state,float partialTick,CallbackInfo ci){
        if(!V1Features.fullBright()) return;
        state.ambientColor=ASTFPS_WHITE; state.darknessEffectScale=0.0f;
        state.bossOverlayWorldDarkening=0.0f; state.brightness=1.0f; state.needsUpdate=true;
    }
}
