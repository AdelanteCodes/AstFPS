package dev.adelantecodes.astfps.client.render;

import dev.adelantecodes.astfps.client.AstFPSRuntime;
import net.minecraft.util.Util;

/** Shares one monotonic millisecond sample across a single entity-extraction pass. */
public final class EntityVisibilityClock {
    private static final ThreadLocal<State> STATE = ThreadLocal.withInitial(State::new);

    private EntityVisibilityClock() { }

    public static void enter() {
        State state = STATE.get();
        if (state.depth++ == 0) state.millis = Util.getMillis();
    }

    public static void leave() {
        State state = STATE.get();
        if (--state.depth == 0) STATE.remove();
    }

    public static long millis() {
        State state = STATE.get();
        if (state.depth == 0) return Util.getMillis();
        AstFPSRuntime.entityVisibilityClockReadsAvoided++;
        return state.millis;
    }

    private static final class State {
        private int depth;
        private long millis;
    }
}
