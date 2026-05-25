package org.example.W3Schools.JavaSmallProjectAndEx.ExX19;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Flight {
    private String flightNumber;
    private String destination;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
