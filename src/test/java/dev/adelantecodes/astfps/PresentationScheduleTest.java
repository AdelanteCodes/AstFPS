package dev.adelantecodes.astfps;

import dev.adelantecodes.astfps.framegen.PresentationSchedule;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

final class PresentationScheduleTest {
    @Test void schedulesTwoTimesSequence() {
        var schedule = new PresentationSchedule();
        assertTrue(schedule.begin().renderRealWorld());
        schedule.afterRealFrame(1);
        var generated = schedule.begin();
        assertFalse(generated.renderRealWorld());
        assertEquals(2, generated.quarterStep());
        assertTrue(schedule.begin().renderRealWorld());
    }

    @Test void schedulesFourTimesSequence() {
        var schedule = new PresentationSchedule();
        schedule.afterRealFrame(3);
        assertEquals(1, schedule.begin().quarterStep());
        assertEquals(2, schedule.begin().quarterStep());
        assertEquals(3, schedule.begin().quarterStep());
        assertTrue(schedule.begin().renderRealWorld());
    }

    @Test void resetForcesRealFrame() {
        var schedule = new PresentationSchedule();
        schedule.afterRealFrame(3);
        schedule.begin();
        schedule.reset();
        assertTrue(schedule.begin().renderRealWorld());
    }
}
