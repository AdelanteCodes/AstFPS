package dev.adelantecodes.astfps.client;

import dev.adelantecodes.astfps.FeatureGate;
import dev.adelantecodes.astfps.client.render.ModelRotationWorkspace;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BooleanSupplier;

/** Shared startup, command and diagnostic descriptions for independently gated experiments. */
public final class AdditionalExperiments {
    public record Entry(String command, FeatureGate gate, BooleanSupplier available) { }
    public static final List<Entry> ENTRIES = List.of(
        new Entry("quad-format", AstFPSRuntime.SECTION_QUAD_FORMAT, AstFPSRuntime::sectionQuadFormatHooksAvailable),
        new Entry("fabric-workspace", AstFPSRuntime.SECTION_FABRIC_WORKSPACE, AstFPSRuntime::sectionFabricHooksAvailable),
        new Entry("model-rotation", AstFPSRuntime.MODEL_ROTATION_SCRATCH, AstFPSRuntime::modelRotationHooksAvailable),
        new Entry("tab-list", AstFPSRuntime.TAB_LIST_CACHE, AstFPSRuntime::tabCacheHooksAvailable));
    private AdditionalExperiments() { }
    public static void initialize() {
        for (Entry entry : ENTRIES) entry.gate().enable(entry.available().getAsBoolean());
    }
    public static Map<String, Object> snapshot() {
        ModelRotationWorkspace.flushCurrentThreadCounters();
        var report = new LinkedHashMap<String, Object>();
        for (Entry entry : ENTRIES) {
            var state = new LinkedHashMap<String, Object>();
            state.put("installedByStartupConditions", entry.available().getAsBoolean());
            state.put("enabled", entry.gate().enabled());
            state.put("failure", entry.gate().failure());
            report.put(entry.command(), state);
        }
        report.put("quadFormatBuildersCached", AstFPSRuntime.quadFormatBuildersCached.sum());
        report.put("quadFormatElementLookupsAvoided", AstFPSRuntime.quadFormatElementLookupsAvoided.sum());
        report.put("fabricWorkspaceJobs", AstFPSRuntime.fabricWorkspaceJobs.sum());
        report.put("fabricAoHelpersAllocated", AstFPSRuntime.fabricAoHelpersAllocated.sum());
        report.put("fabricAoHelpersReused", AstFPSRuntime.fabricAoHelpersReused.sum());
        report.put("fabricAoHelpersBypassed", AstFPSRuntime.fabricAoHelpersBypassed.sum());
        report.put("modelRotationJobs", AstFPSRuntime.modelRotationJobs.sum());
        report.put("modelRotationMatricesReused", AstFPSRuntime.modelRotationMatricesReused.sum());
        report.put("modelRotationVectorsReused", AstFPSRuntime.modelRotationVectorsReused.sum());
        report.put("tabCacheHits", AstFPSRuntime.tabCacheHits.sum());
        report.put("tabCacheMisses", AstFPSRuntime.tabCacheMisses.sum());
        report.put("tabCacheBypasses", AstFPSRuntime.tabCacheBypasses.sum());
        report.put("tabCacheInvalidations", AstFPSRuntime.tabCacheInvalidations.sum());
        report.put("modelScratchCounterScope", "Current-thread residual counters flushed at snapshot; other threads may retain up to 63 unflushed outer calls. Factory substitutions are not measured heap allocations.");
        return report;
    }
}
