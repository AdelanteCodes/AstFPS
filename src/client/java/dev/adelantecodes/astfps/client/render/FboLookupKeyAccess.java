package dev.adelantecodes.astfps.client.render;

/** Access is used exclusively on AstFPS's private, never-inserted native lookup key. */
public interface FboLookupKeyAccess {
    void astfpsMarkLookupProbe();
    void astfpsSetLookupData(int[] data, int hash);
}
