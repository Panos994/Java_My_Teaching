package org.example.W3Schools.JavaSmallProjectAndEx.Exx26;

import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor

@ToString
public class MusicalPerformance extends Event{
    private List<Performer> performerList;

    public MusicalPerformance(String eventName, LocalDateTime date, String location) {
        super(eventName, date, location);
        performerList = new ArrayList<>();
    }


}
