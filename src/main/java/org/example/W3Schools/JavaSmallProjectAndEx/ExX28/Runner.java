package org.example.W3Schools.JavaSmallProjectAndEx.ExX28;

import java.time.LocalDateTime;

public class Runner {
    public static void main(String[] args) {
        Reservation res = new Reservation("Papamelios Ilias", LocalDateTime.of(2026, 6, 10,11,5,1),ReservationStatus.PROCESSED, CustomerStatus.PENDING);
        Reservation res2 = new Reservation("Papas Ilias", LocalDateTime.of(2026, 6, 10,11,5,1),ReservationStatus.COMPETED, CustomerStatus.ARRIVED);

        ResortReservation resortres = new ResortReservation("Papas Ilias", LocalDateTime.of(2026, 6, 10,11,5,1),ReservationStatus.COMPETED, CustomerStatus.ARRIVED, 150);
        res2.checkReservationStatus(res2.getDate());

        System.out.println("Before modification: " + resortres);
        resortres.modifyReservationDetails();
        System.out.println("After modification: " + resortres);


    }
}
