package dev.adelantecodes.astfps.client;

/** Runtime-selectable, vendor-neutral V1 features. Values are deliberately small and serializable. */
public final class V1Features {
    public enum LowRamMode { OFF, AUTO, ON; public LowRamMode next() { return values()[(ordinal() + 1) % values().length]; } }
    public enum UpscalingMode {
        OFF(1.0f), QUALITY(0.77f), BALANCED(0.67f), PERFORMANCE(0.58f), AUTO(0.0f);
        private final float scale;
        UpscalingMode(float scale) { this.scale = scale; }
        public float scale() { return scale; }
        public UpscalingMode next() { return values()[(ordinal() + 1) % values().length]; }
    }
    public enum Level { OFF, CONSERVATIVE, BALANCED, AGGRESSIVE; public Level next() { return values()[(ordinal() + 1) % values().length]; } }
    public enum FrameGenQuality { FAST, AUTO, QUALITY; public FrameGenQuality next() { return values()[(ordinal() + 1) % values().length]; } }
    public enum LatencyMode { STANDARD, AUTO, LOW; public LatencyMode next() { return values()[(ordinal() + 1) % values().length]; } }

    private static volatile LowRamMode lowRam = LowRamMode.AUTO;
    private static volatile UpscalingMode upscaling = UpscalingMode.OFF;
    private static volatile Level culling = Level.BALANCED;
    private static volatile Level chunkSmoothing = Level.BALANCED;
    private static volatile FrameGenQuality frameGenQuality = FrameGenQuality.AUTO;
    private static volatile LatencyMode latency = LatencyMode.AUTO;
    private static volatile boolean fullBright;
    private static volatile boolean overlay = true;
    private static volatile boolean perWorldProfiles = true;
    private static volatile boolean compatibilityProtection = true;

    private V1Features() { }
    public static LowRamMode lowRam() { return lowRam; }
    public static void lowRam(LowRamMode value) { lowRam = value; }
    public static UpscalingMode upscaling() { return upscaling; }
    public static void upscaling(UpscalingMode value) { upscaling = value; }
    public static Level culling() { return culling; }
    public static void culling(Level value) { culling = value; }
    public static Level chunkSmoothing() { return chunkSmoothing; }
    public static void chunkSmoothing(Level value) { chunkSmoothing = value; }
    public static FrameGenQuality frameGenQuality() { return frameGenQuality; }
    public static void frameGenQuality(FrameGenQuality value) { frameGenQuality = value; }
    public static LatencyMode latency() { return latency; }
    public static void latency(LatencyMode value) { latency = value; }
    public static boolean fullBright() { return fullBright; }
    public static void fullBright(boolean value) { fullBright = value; }
    public static boolean overlay() { return overlay; }
    public static void overlay(boolean value) { overlay = value; }
    public static boolean perWorldProfiles() { return perWorldProfiles; }
    public static void perWorldProfiles(boolean value) { perWorldProfiles = value; }
    public static boolean compatibilityProtection() { return compatibilityProtection; }
    public static void compatibilityProtection(boolean value) { compatibilityProtection = value; }
}
