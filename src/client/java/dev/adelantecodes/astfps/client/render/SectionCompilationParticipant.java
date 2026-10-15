package dev.adelantecodes.astfps.client.render;

/** Native-only lifecycle boundary; optional implementations must be linked lazily. */
public interface SectionCompilationParticipant {
    void begin();
    void poison();
    void finish();
}
