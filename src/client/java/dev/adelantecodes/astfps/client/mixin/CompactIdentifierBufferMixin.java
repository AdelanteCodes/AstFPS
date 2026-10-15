package dev.adelantecodes.astfps.client.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import dev.adelantecodes.astfps.network.CompactIdentifierEncoding;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

/** Preserve native toString and writeUtf callbacks while omitting an implicit wire namespace. */
@Mixin(FriendlyByteBuf.class)
public abstract class CompactIdentifierBufferMixin {
    @ModifyExpressionValue(method = "writeIdentifier", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/resources/Identifier;toString()Ljava/lang/String;"))
    private String astfpsCompactIdentifierBuffer(String encoded, Identifier identifier) {
        return CompactIdentifierEncoding.compact(identifier, encoded);
    }
}
