package dev.adelantecodes.astfps.client.mixin;

import dev.adelantecodes.astfps.network.CompactIdentifierEncoding;
import java.util.function.Function;
import net.minecraft.resources.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

/** Keep Identifier.parse and the native codec; wrap only its default-namespace string encoder. */
@Mixin(Identifier.class)
public abstract class CompactIdentifierCodecMixin {
    @ModifyArg(method = "<clinit>", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/network/codec/StreamCodec;map(Ljava/util/function/Function;Ljava/util/function/Function;)Lnet/minecraft/network/codec/StreamCodec;"),
            index = 1)
    private static Function<Identifier, String> astfpsCompactIdentifierCodec(Function<Identifier, String> original) {
        return CompactIdentifierEncoding.wrap(original);
    }
}
