package dev.adelantecodes.astfps.client.mixin;

import dev.adelantecodes.astfps.VarIntSize;
import net.minecraft.network.VarInt;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

/** Startup-gated pure size calculation; packet encoding, decoding and ByteBuf ownership stay native. */
@Mixin(VarInt.class)
public abstract class VarIntSizeMixin {
    /**
     * @author AstFPS contributors
     * @reason Calculate the same seven-bit wire length without the repeated mask/shift loop.
     */
    @Overwrite
    public static int getByteSize(int value) {
        return VarIntSize.of(value);
    }
}
