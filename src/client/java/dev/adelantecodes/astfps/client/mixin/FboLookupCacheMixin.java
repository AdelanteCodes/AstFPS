package dev.adelantecodes.astfps.client.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.renderpearl.backend.opengl.DirectStateAccess;
import com.mojang.renderpearl.backend.opengl.FrameBufferAttachment;
import com.mojang.renderpearl.backend.opengl.FrameBufferCache;
import dev.adelantecodes.astfps.client.render.FboLookupProbe;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import java.util.List;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FrameBufferCache.class)
public abstract class FboLookupCacheMixin {
    @Shadow @Final private Object2IntMap<FrameBufferCache.CacheKey> cache;
    @Unique private FboLookupProbe astfpsFboProbe;

    @Inject(method = "getFbo(Lcom/mojang/renderpearl/backend/opengl/DirectStateAccess;Ljava/util/List;Lcom/mojang/renderpearl/backend/opengl/FrameBufferAttachment;I)I",
            at = @At("HEAD"), cancellable = true)
    private void astfpsFindExistingFbo(DirectStateAccess dsa, List<FrameBufferAttachment> colors,
            FrameBufferAttachment depth, int mipOffset, CallbackInfoReturnable<Integer> ci) {
        if (!FboLookupProbe.GATE.enabled() || !RenderSystem.isOnRenderThread()
                || ((Object)this).getClass() != FrameBufferCache.class) return;
        try {
            if (astfpsFboProbe == null) astfpsFboProbe = new FboLookupProbe();
            if (astfpsFboProbe.find(cache, colors, depth, mipOffset)) ci.setReturnValue(astfpsFboProbe.result());
        } catch (RuntimeException error) {
            // Only pure Java lookup ran; native creation/association/destruction has not started.
            FboLookupProbe.GATE.disableAfterFailure("FrameBufferCache lookup probe", error);
            astfpsFboProbe = null;
        }
    }
}
