package dev.adelantecodes.astfps.client.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.ByteBufferBuilder;
import com.mojang.renderpearl.api.pipeline.PrimitiveTopology;
import com.mojang.renderpearl.api.vertex.VertexFormat;
import com.mojang.renderpearl.api.vertex.VertexFormatElement;
import dev.adelantecodes.astfps.client.AstFPSRuntime;
import dev.adelantecodes.astfps.client.render.SectionQuadFormatDescriptor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/** Preserve constructor validation, masks and private arrays; memo only pure native element lookups. */
@Mixin(BufferBuilder.class)
public abstract class SectionQuadFormatBuilderMixin {
    @Unique private SectionQuadFormatDescriptor astfpsQuadDescriptor;
    @Unique private VertexFormatElement[] astfpsQuadCapture;
    @Unique private int astfpsQuadCaptured;
    @Unique private int astfpsQuadAvoided;

    @WrapOperation(method = "<init>", at = @At(value = "INVOKE",
            target = "Lcom/mojang/renderpearl/api/vertex/VertexFormat;contains(Ljava/lang/String;)Z", ordinal = 0))
    private boolean astfpsPrepareQuadFormat(VertexFormat format, String name, Operation<Boolean> original) {
        boolean present = original.call(format, name);
        if (present && SectionQuadFormatDescriptor.eligible((BufferBuilder)(Object)this, format)) {
            astfpsQuadDescriptor = SectionQuadFormatDescriptor.lookup(format);
            if (astfpsQuadDescriptor == null) astfpsQuadCapture = new VertexFormatElement[8];
        }
        return present;
    }

    @WrapOperation(method = "<init>", at = @At(value = "INVOKE",
            target = "Lcom/mojang/renderpearl/api/vertex/VertexFormat;getElement(Ljava/lang/String;)Lcom/mojang/renderpearl/api/vertex/VertexFormatElement;", ordinal = 0))
    private VertexFormatElement astfpsQuadElement(VertexFormat format, String name,
            Operation<VertexFormatElement> original, @Local(name = "i") int index) {
        boolean matches = SectionQuadFormatDescriptor.matches(index, name);
        if (astfpsQuadDescriptor != null && matches) {
            astfpsQuadAvoided++;
            return astfpsQuadDescriptor.element(index);
        }
        VertexFormatElement element = original.call(format, name);
        if (astfpsQuadCapture != null && matches) {
            astfpsQuadCapture[index] = element;
            astfpsQuadCaptured |= 1 << index;
        }
        return element;
    }

    @Inject(method = "<init>", at = @At("RETURN"))
    private void astfpsCompleteQuadFormat(ByteBufferBuilder buffer, PrimitiveTopology topology,
            VertexFormat format, CallbackInfo ci) {
        if (astfpsQuadCaptured == 255) SectionQuadFormatDescriptor.publish(format, astfpsQuadCapture);
        if (astfpsQuadAvoided != 0) {
            AstFPSRuntime.quadFormatBuildersCached.increment();
            AstFPSRuntime.quadFormatElementLookupsAvoided.add(astfpsQuadAvoided);
        }
        astfpsQuadDescriptor = null;
        astfpsQuadCapture = null;
    }
}
