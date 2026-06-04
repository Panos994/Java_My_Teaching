package org.example.W3Schools.JavaSmallProjectAndEx.Exx26;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Seminar extends Event{
    private int numberOfSpeakers;

    public Seminar(String eventName, LocalDateTime date, String location, int numberOfSpeakers) {
        super(eventName, date, location);
        this.numberOfSpeakers = numberOfSpeakers;
    }

    @Override
    public void displayEventsDetails() {
        super.displayEventsDetails();
        System.out.println("Number of speakers: " + numberOfSpeakers);
    }
}
