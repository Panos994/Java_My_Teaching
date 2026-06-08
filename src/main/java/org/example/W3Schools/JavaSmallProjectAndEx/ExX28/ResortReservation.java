package org.example.W3Schools.JavaSmallProjectAndEx.ExX28;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Scanner;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ResortReservation extends Reservation{
    private int roomNumber;

    public ResortReservation(String customerName, LocalDateTime date, ReservationStatus status, CustomerStatus cStatus, int roomNumber) {
        super(customerName, date, status, cStatus);
        this.roomNumber = roomNumber;
    }

    @Override
    public void modifyReservationDetails() {
        super.modifyReservationDetails();
        setRoomNumber(sc.nextInt());
        sc.nextLine();
    }
}
