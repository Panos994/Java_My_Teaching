package org.example.W3Schools.JavaSmallProjectAndEx.Exx26;

import lombok.*;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class EventSchedule {

    private List<Event> events;

    public EventSchedule() {
        this.events = new ArrayList<>();
    }
    public void addEvent(Event event){
        events.add(event);
    }

    public void removeEvent(Event event){
        events.remove(event);
    }
    public void checkScheduleConflicts(Event checkingEvent){
        for(Event event : events){
            if(event == checkingEvent) continue; // αγνόησε το ίδιο event
            if(event.getDate().equals(checkingEvent.getDate())){
                System.out.println("Conflict detected: " + event.getEventName() + " conflicts with " + checkingEvent.getEventName());
            } else if (event.getDate().isAfter(checkingEvent.getDate())) {
                System.out.println("No conflict: " + event.getEventName() + " is scheduled after " + checkingEvent.getEventName());
            } else {
                System.out.println("No conflict: " + event.getEventName() + " is scheduled before " + checkingEvent.getEventName());
            }
        }
    }

    public void displayAllEventDetails(){
        for(Event e : events){
            e.displayEventsDetails();
            System.out.println("-----------------------------");
        }
    }
}
