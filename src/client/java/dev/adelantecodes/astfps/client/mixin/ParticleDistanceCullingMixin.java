package dev.adelantecodes.astfps.client.mixin;
import dev.adelantecodes.astfps.client.V1Features;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.core.particles.ParticleOptions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/** Avoids constructing distant cosmetic particles; gameplay state remains untouched. */
@Mixin(ParticleEngine.class)
public abstract class ParticleDistanceCullingMixin {
    @Inject(method="createParticle",at=@At("HEAD"),cancellable=true)
    private void astfpsCullParticle(ParticleOptions options,double x,double y,double z,double dx,double dy,double dz,CallbackInfoReturnable<Particle> cir){
        double limit=switch(V1Features.culling()){case OFF->Double.POSITIVE_INFINITY;case CONSERVATIVE->128.0;case BALANCED->80.0;case AGGRESSIVE->48.0;};
        var camera=Minecraft.getInstance().getCameraEntity(); if(camera==null)return;
        var p=camera.position();double ox=x-p.x,oy=y-p.y,oz=z-p.z;if(ox*ox+oy*oy+oz*oz>limit*limit)cir.setReturnValue(null);
    }
}
