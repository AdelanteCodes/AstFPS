package dev.adelantecodes.astfps;

import dev.adelantecodes.astfps.gpu.FrameBudgetScheduler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

final class FrameBudgetSchedulerTest {
    @Test void prioritizesImmediateThenVisibleThenBackground() {
        var scheduler = new FrameBudgetScheduler<String>();
        scheduler.submit("background", FrameBudgetScheduler.Priority.BACKGROUND);
        scheduler.submit("visible", FrameBudgetScheduler.Priority.VISIBLE);
        scheduler.submit("immediate", FrameBudgetScheduler.Priority.IMMEDIATE);
        assertEquals("immediate", scheduler.poll(0).work());
        assertEquals("visible", scheduler.poll(Long.MAX_VALUE).work());
        assertEquals("background", scheduler.poll(Long.MAX_VALUE).work());
    }

    @Test void budgetDefersNonImmediateWork() {
        var scheduler = new FrameBudgetScheduler<String>();
        scheduler.submit("visible", FrameBudgetScheduler.Priority.VISIBLE);
        assertNull(scheduler.poll(1));
        assertEquals(1, scheduler.size());
        assertEquals("visible", scheduler.poll(250_000).work());
    }

    @Test void learnedEstimateChangesAdmission() {
        var scheduler = new FrameBudgetScheduler<String>();
        scheduler.record(FrameBudgetScheduler.Priority.BACKGROUND, 2_250_000);
        scheduler.submit("job", FrameBudgetScheduler.Priority.BACKGROUND);
        assertNull(scheduler.poll(400_000));
        assertNotNull(scheduler.poll(500_000));
    }

    @Test void clearDropsAllQueues() {
        var scheduler = new FrameBudgetScheduler<String>();
        scheduler.submit("a", FrameBudgetScheduler.Priority.IMMEDIATE);
        scheduler.submit("b", FrameBudgetScheduler.Priority.BACKGROUND);
        scheduler.clear();
        assertEquals(0, scheduler.size());
    }
}
