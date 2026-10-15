package dev.adelantecodes.astfps.client.render;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.mojang.blaze3d.vertex.VertexSorting;
import dev.adelantecodes.astfps.StageTimings;
import dev.adelantecodes.astfps.client.AstFPSRuntime;
import net.minecraft.client.renderer.SectionBufferBuilderPack;
import net.minecraft.client.renderer.chunk.RenderSectionRegion;
import net.minecraft.client.renderer.chunk.SectionCompiler;
import net.minecraft.core.SectionPos;

/** One worker-local lifecycle for all independently gated native compilation optimizations. */
public final class SectionCompilationContext {
    public static final int WORKER = 1, STATE = 2, MESH = 4, QUAD = 8, FABRIC = 16;
    private static final ThreadLocal<SectionCompilationContext> LOCAL = new ThreadLocal<>();
    private int depth;
    private int enrolled;
    private int initialized;
    private SectionWorkerCache worker;
    private SectionStateCache state;
    private SectionMeshWorkspace mesh;
    // No optional renderer types in this class's fields, method descriptors or generic signatures.
    private SectionCompilationParticipant fabric;

    private SectionCompilationContext() { }

    private static boolean enabled(int feature) {
        return switch (feature) {
            case WORKER -> AstFPSRuntime.SECTION_WORKER_CACHE.enabled();
            case STATE -> AstFPSRuntime.SECTION_STATE_CACHE.enabled();
            case MESH -> AstFPSRuntime.SECTION_MESH_WORKSPACE.enabled();
            case QUAD -> AstFPSRuntime.SECTION_QUAD_FORMAT.enabled();
            case FABRIC -> AstFPSRuntime.SECTION_FABRIC_WORKSPACE.enabled();
            default -> false;
        };
    }

    private boolean active(int feature) {
        return depth == 1 && (enrolled & initialized & feature) != 0 && enabled(feature);
    }

    public static boolean borrowing(int feature) {
        SectionCompilationContext context = LOCAL.get();
        return context != null && context.active(feature);
    }

    public static SectionWorkerCache worker() {
        SectionCompilationContext context = LOCAL.get();
        return context != null && context.active(WORKER) ? context.worker : null;
    }

    public static SectionStateCache state() {
        SectionCompilationContext context = LOCAL.get();
        return context != null && context.active(STATE) ? context.state : null;
    }

    public static SectionMeshWorkspace mesh() {
        SectionCompilationContext context = LOCAL.get();
        return context != null && context.active(MESH) ? context.mesh : null;
    }

    public static SectionCompilationParticipant fabric() {
        SectionCompilationContext context = LOCAL.get();
        return context != null && context.active(FABRIC) ? context.fabric : null;
    }

    private static int requested() {
        int mask = 0;
        for (int bit = WORKER; bit <= FABRIC; bit <<= 1) if (enabled(bit)) mask |= bit;
        // This guard must precede touching the optional bridge or implementation.
        if ((mask & FABRIC) != 0 && !AstFPSRuntime.sectionFabricHooksAvailable()) mask &= ~FABRIC;
        return mask;
    }

    private void begin(SectionPos position, RenderSectionRegion region) {
        if ((enrolled & WORKER) != 0) {
            if (worker == null) worker = new SectionWorkerCache();
            initialized |= WORKER;
        }
        if ((enrolled & STATE) != 0) {
            if (state == null) state = new SectionStateCache();
            initialized |= STATE;
            state.begin(position, region);
        }
        if ((enrolled & MESH) != 0) {
            if (mesh == null) mesh = new SectionMeshWorkspace();
            initialized |= MESH;
            mesh.begin();
        }
        if ((enrolled & QUAD) != 0) initialized |= QUAD;
        if ((enrolled & FABRIC) != 0) {
            if (fabric == null) fabric = SectionCompilationFabricBridge.create();
            initialized |= FABRIC;
            fabric.begin();
        }
    }

    public static SectionCompiler.Results compile(SectionPos position, RenderSectionRegion region,
            VertexSorting sorting, SectionBufferBuilderPack builders, Operation<SectionCompiler.Results> original) {
        StageTimings.Sample sample = StageTimings.begin(StageTimings.Stage.SECTION_COMPILE);
        SectionCompilationContext context = LOCAL.get();
        boolean outer = context == null || context.depth == 0;
        int mask = outer ? requested() : context.enrolled;
        if (context == null && mask != 0) {
            context = new SectionCompilationContext();
            LOCAL.set(context);
        }
        boolean entered = context != null && (!outer || mask != 0);
        boolean successful = false;
        Throwable primary = null;
        try {
            if (entered) {
                context.depth++;
                if (outer) {
                    context.enrolled = mask;
                    context.initialized = 0;
                    context.begin(position, region);
                }
            }
            SectionCompiler.Results result = original.call(position, region, sorting, builders);
            successful = true;
            if (entered && outer) context.recordJobs();
            return result;
        } catch (RuntimeException | Error error) {
            successful = false;
            primary = error;
            if (entered) context.failed(error);
            throw error;
        } finally {
            Error cleanupFatal = null;
            if (entered) {
                try {
                    if (outer) cleanupFatal = context.finish(primary);
                } finally {
                    context.depth--;
                    if (outer) {
                        context.enrolled = 0;
                        context.initialized = 0;
                    }
                }
            }
            try {
                StageTimings.end(StageTimings.Stage.SECTION_COMPILE, sample, successful && cleanupFatal == null);
            } catch (RuntimeException | Error timing) {
                if (primary != null) suppress(primary, timing);
                else if (cleanupFatal != null) suppress(cleanupFatal, timing);
                else throw timing;
            }
            if (cleanupFatal != null) throw cleanupFatal;
        }
    }

    private void recordJobs() {
        if ((enrolled & WORKER) != 0) AstFPSRuntime.sectionCacheJobs.increment();
        if ((enrolled & STATE) != 0) AstFPSRuntime.sectionStateJobs.increment();
        if ((enrolled & MESH) != 0) AstFPSRuntime.meshWorkspaceJobs.increment();
        if ((enrolled & FABRIC) != 0) AstFPSRuntime.fabricWorkspaceJobs.increment();
    }

    private void failed(Throwable primary) {
        // A compile error is not causal evidence against a particular feature. Disable enrolled paths conservatively.
        for (int bit = WORKER; bit <= FABRIC; bit <<= 1) {
            if ((enrolled & bit) == 0) continue;
            try {
                disable(bit);
                if (bit == WORKER && worker != null) worker.discard();
                if (bit == STATE && state != null) state.discard();
                if (bit == MESH && mesh != null) mesh.poison();
                if (bit == FABRIC && fabric != null) fabric.poison();
                failure(bit, "SectionCompiler.compile (enrolled scope; cause unassigned)", primary);
            } catch (RuntimeException | Error cleanup) {
                suppress(primary, cleanup);
            }
        }
    }

    private Error finish(Throwable primary) {
        Error fatal = null;
        for (int bit = FABRIC; bit >= WORKER; bit >>= 1) {
            if ((initialized & bit) == 0) continue;
            try {
                if (bit == FABRIC) fabric.finish();
                if (bit == MESH) mesh.finish();
                if (bit == STATE) state.finish();
            } catch (RuntimeException | Error cleanup) {
                disable(bit);
                if (primary != null) suppress(primary, cleanup);
                else if (cleanup instanceof Error error) {
                    if (fatal == null) fatal = error;
                    else suppress(fatal, error);
                }
                // Do not retain a partially cleaned feature, and do not skip the remaining cleanup.
                if (bit == FABRIC) fabric = null;
                if (bit == MESH) mesh = null;
                if (bit == STATE) state = null;
                {
                    try { failure(bit, "SectionCompiler.cleanup", cleanup); }
                    catch (RuntimeException | Error logging) {
                        if (primary != null) suppress(primary, logging);
                        else if (fatal != null) suppress(fatal, logging);
                    }
                }
            }
        }
        return fatal;
    }

    private static void failure(int bit, String stage, Throwable error) {
        if (!(error instanceof RuntimeException runtime)) {
            switch (bit) {
                case WORKER -> AstFPSRuntime.SECTION_WORKER_CACHE.disableAfterFailure(stage, error);
                case STATE -> AstFPSRuntime.SECTION_STATE_CACHE.disableAfterFailure(stage, error);
                case MESH -> AstFPSRuntime.SECTION_MESH_WORKSPACE.disableAfterFailure(stage, error);
                case QUAD -> AstFPSRuntime.SECTION_QUAD_FORMAT.disableAfterFailure(stage, error);
                case FABRIC -> AstFPSRuntime.SECTION_FABRIC_WORKSPACE.disableAfterFailure(stage, error);
                default -> { }
            }
            return;
        }
        switch (bit) {
            case WORKER -> AstFPSRuntime.sectionCacheFailure(stage, runtime);
            case STATE -> AstFPSRuntime.sectionStateFailure(stage, runtime);
            case MESH -> AstFPSRuntime.sectionMeshFailure(stage, runtime);
            case QUAD -> AstFPSRuntime.sectionQuadFormatFailure(stage, runtime);
            case FABRIC -> AstFPSRuntime.sectionFabricFailure(stage, runtime);
            default -> { }
        }
    }

    private static void disable(int bit) {
        switch (bit) {
            case WORKER -> AstFPSRuntime.SECTION_WORKER_CACHE.enable(false);
            case STATE -> AstFPSRuntime.SECTION_STATE_CACHE.enable(false);
            case MESH -> AstFPSRuntime.SECTION_MESH_WORKSPACE.enable(false);
            case QUAD -> AstFPSRuntime.SECTION_QUAD_FORMAT.enable(false);
            case FABRIC -> AstFPSRuntime.SECTION_FABRIC_WORKSPACE.enable(false);
            default -> { }
        }
    }

    private static void suppress(Throwable primary, Throwable extra) {
        if (primary == extra) return;
        try { primary.addSuppressed(extra); }
        catch (RuntimeException | Error ignored) { /* Preserve the original error even under memory pressure. */ }
    }
}
