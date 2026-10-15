package dev.adelantecodes.astfps;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.Instant;

/** A failing optimization is disabled; its caller must keep the vanilla fallback. */
public final class FeatureGate {
    private final String id;
    private volatile boolean enabled;
    private volatile Failure failure;
    private volatile boolean failed;

    public FeatureGate(String id) { this.id = id; }
    public String id() { return id; }
    public boolean enabled() { return enabled; }
    public Failure failure() { return failure; }

    public synchronized boolean enable(boolean requested) {
        if (requested && failed) return false;
        enabled = requested;
        return true;
    }

    public synchronized void disableAfterFailure(String stage, Throwable error) {
        enabled = false;
        if (failed) return;
        failed = true;
        StringWriter trace = new StringWriter();
        error.printStackTrace(new PrintWriter(trace));
        failure = new Failure(id, stage, Instant.now().toString(), error.getClass().getName(), error.getMessage(), trace.toString());
    }

    public record Failure(String feature, String stage, String time, String exception, String message, String stackTrace) { }
}
