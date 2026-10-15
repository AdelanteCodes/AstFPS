package dev.adelantecodes.astfps.client.render;

/** Loaded only after the exact optional Fabric hook availability check passes. */
final class SectionCompilationFabricBridge {
    private SectionCompilationFabricBridge() { }
    static SectionCompilationParticipant create() { return new SectionFabricWorkspace(); }
}
