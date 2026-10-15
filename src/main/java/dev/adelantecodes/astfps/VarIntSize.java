package dev.adelantecodes.astfps;

/** Exact unsigned-bit-width calculation for Minecraft's signed-int VarInt wire representation. */
public final class VarIntSize {
    private VarIntSize() { }

    public static int of(int value) {
        // Keep the native single-byte case as a single mask/branch.
        if ((value & -128) == 0) return 1;
        // The remaining value is nonzero. Negative values use all 32 bits and therefore five bytes.
        // ceil(bitWidth / 7) equals the native seven-bit boundary loop, including Integer.MIN_VALUE.
        return (38 - Integer.numberOfLeadingZeros(value)) / 7;
    }
}
