package dev.kyzer.xemod.client;

public final class XeRuntime {
    private XeRuntime() { }
    public static volatile boolean visibilityMemoEnabled;
    public static volatile long frameEpoch;
    public static long visibilityHits;
    public static long visibilityMisses;
}
