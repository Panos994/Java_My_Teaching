package org.example.W3Schools.JavaSmallProjectAndEx.ExX28;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class RailwayReservation extends Reservation{
    private String seatNumber;

    public RailwayReservation(String customerName, LocalDateTime date, ReservationStatus status, CustomerStatus cStatus, String seatNumber) {
        super(customerName, date, status, cStatus);
        this.seatNumber = seatNumber;
    }

    @Override
    public void modifyReservationDetails() {
        super.modifyReservationDetails();
        setSeatNumber(sc.nextLine());
    }
}
