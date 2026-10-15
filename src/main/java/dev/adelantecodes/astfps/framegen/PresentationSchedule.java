package dev.adelantecodes.astfps.framegen;

/** Alternates one real render with the requested number of generated presentations. */
public final class PresentationSchedule {
    public record Presentation(boolean renderRealWorld, int quarterStep) {
        public static Presentation real() { return new Presentation(true, 0); }
        public static Presentation generated(int quarterStep) { return new Presentation(false, quarterStep); }
    }

    private int generatedTotal;
    private int generatedIndex;

    public Presentation begin() {
        if (generatedIndex >= generatedTotal) {
            generatedTotal = 0;
            generatedIndex = 0;
            return Presentation.real();
        }
        int index = ++generatedIndex;
        int step = generatedTotal == 1 ? 2 : index;
        return Presentation.generated(step);
    }

    public void afterRealFrame(int generatedFrames) {
        if (generatedFrames != 0 && generatedFrames != 1 && generatedFrames != 3)
            throw new IllegalArgumentException("generatedFrames must be 0, 1 or 3");
        generatedTotal = generatedFrames;
        generatedIndex = 0;
    }

    public void reset() {
        generatedTotal = 0;
        generatedIndex = 0;
    }
}
