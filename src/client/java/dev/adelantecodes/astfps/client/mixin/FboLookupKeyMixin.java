package dev.adelantecodes.astfps.client.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.renderpearl.backend.opengl.FrameBufferAttachment;
import com.mojang.renderpearl.backend.opengl.FrameBufferCache;
import dev.adelantecodes.astfps.client.render.FboLookupKeyAccess;
import dev.adelantecodes.astfps.client.render.FboLookupProbe;
import java.util.List;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(FrameBufferCache.CacheKey.class)
public abstract class FboLookupKeyMixin implements FboLookupKeyAccess {
    @Shadow @Final @Mutable private int[] data;
    @Shadow @Final @Mutable private int hash;
    @Shadow @Final public List<FrameBufferAttachment> associatedAttachments;
    @Unique private boolean astfpsPrivateLookupProbe;

    @Override public void astfpsMarkLookupProbe() {
        if (!RenderSystem.isOnRenderThread() || !associatedAttachments.isEmpty()) {
            throw new IllegalStateException("Only an empty, private render-thread FBO lookup key may be marked");
        }
        astfpsPrivateLookupProbe = true;
    }

    @Override public void astfpsSetLookupData(int[] values, int hashCode) {
        if (!astfpsPrivateLookupProbe || !RenderSystem.isOnRenderThread()
                || values.length > (FboLookupProbe.MAX_COLOR_ATTACHMENTS + 1) * 2 || (values.length & 1) != 0) {
            throw new IllegalStateException("Invalid FBO lookup probe ownership or key length");
        }
        data = values;
        hash = hashCode;
    }
}
