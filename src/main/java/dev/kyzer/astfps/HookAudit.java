package dev.kyzer.astfps;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/** Startup receipts remain available even before client initialization. */
public final class HookAudit {
    private static final Map<String, String> HOOKS = new ConcurrentHashMap<>();
    private HookAudit() { }
    public static void record(String hook, String state) { HOOKS.put(hook, state); }
    public static Map<String, String> snapshot() { return Map.copyOf(HOOKS); }
}
