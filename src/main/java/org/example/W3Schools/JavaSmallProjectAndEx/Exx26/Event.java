package org.example.W3Schools.JavaSmallProjectAndEx.Exx26;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Event {

    private String eventName;
    private LocalDateTime date;
    private String location;


    public void displayEventsDetails()
    {
        System.out.printf("%s |||| %s |||| %s\n", eventName, date, location);
    }

}
