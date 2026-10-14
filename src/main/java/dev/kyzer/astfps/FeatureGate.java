package dev.kyzer.astfps;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.Instant;

/** A failing optimization is disabled; its caller must keep the vanilla fallback. */
public final class FeatureGate {
    private final String id;
    private volatile boolean enabled;
    private volatile Failure failure;

    public FeatureGate(String id) { this.id = id; }
    public String id() { return id; }
    public boolean enabled() { return enabled; }
    public Failure failure() { return failure; }

    public boolean enable(boolean requested) {
        if (requested && failure != null) return false;
        enabled = requested;
        return true;
    }

    public synchronized void disableAfterFailure(String stage, RuntimeException error) {
        enabled = false;
        if (failure != null) return;
        StringWriter trace = new StringWriter();
        error.printStackTrace(new PrintWriter(trace));
        failure = new Failure(id, stage, Instant.now().toString(), error.getClass().getName(), error.getMessage(), trace.toString());
    }

    public record Failure(String feature, String stage, String time, String exception, String message, String stackTrace) { }
}
