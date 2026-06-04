package org.example.W3Schools.JavaSmallProjectAndEx.Exx26;

import java.time.LocalDateTime;

public class Runner {
    public static void main(String[] args) {
        EventSchedule evs = new EventSchedule();

        Event ev1 = new Event("Java Workshop", LocalDateTime.of(2026, 6,15,9,10), "Athens, Bucurestiou 134, TK 13444");
        Event ev2 = new Event("PLSQL Workshop", LocalDateTime.of(2026, 6,11,9,10), "Athens, Bucurestiou 134, TK 13444");
        Event ev3 = new Event("Python Workshop", LocalDateTime.of(2026, 6,12,9,10), "Athens, Bucurestiou 134, TK 13444");
        Event ev4 = new Event("Duplicate Java Workshop", LocalDateTime.of(2026, 6,15,9,10), "Athens, Bucurestiou 134, TK 13444"); // Ίδια ημερομηνία με ev1
        evs.addEvent(ev1);
        evs.addEvent(ev2);
        evs.addEvent(ev3);
        evs.addEvent(ev4);

        ev1.displayEventsDetails();
        ev2.displayEventsDetails();
        ev3.displayEventsDetails();
        ev4.displayEventsDetails();

        evs.checkScheduleConflicts(ev1);
        System.out.println("-----------------------------");
        evs.checkScheduleConflicts(ev2);
        System.out.println("-----------------------------");
        evs.checkScheduleConflicts(ev4);
        System.out.println("-----------------------------");
        System.out.println("All events:");
        evs.displayAllEventDetails();
    }
}
