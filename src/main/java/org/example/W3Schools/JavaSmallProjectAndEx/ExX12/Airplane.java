package org.example.W3Schools.JavaSmallProjectAndEx.ExX12;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
enum Status{
    ON_BOARD, NOT_BOARD_YET, DELAYED
}
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Airplane {
    private int flightNumber;
    private String destination;
    private LocalDateTime departureTime;
    private Status status;


    public void checkStatus(){
        switch (status) {
            case DELAYED -> System.out.println("Flight " + flightNumber + " to " + destination + " is delayed.");
            case ON_BOARD -> System.out.println("Flight " + flightNumber + " to " + destination + " is on board.");
            case NOT_BOARD_YET -> System.out.println("Flight " + flightNumber + " to " + destination + " has not boarded yet.");
            default -> System.out.println("Unknown status for flight " + flightNumber + " to " + destination + ".");
        };
    }

    public boolean isDelayed(LocalDateTime actualDepartureTime){
        boolean delayed = actualDepartureTime.isAfter(this.departureTime);
        this.status = delayed ? Status.DELAYED : Status.NOT_BOARD_YET;
        return delayed;
    }

}
