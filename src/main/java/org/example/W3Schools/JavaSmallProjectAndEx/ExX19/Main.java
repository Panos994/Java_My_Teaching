package org.example.W3Schools.JavaSmallProjectAndEx.ExX19;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        ReservationSystem resSys = new ReservationSystem();

        Flight f = new Flight("AE456", "Abu Dabi", LocalDateTime.now(), LocalDateTime.now().plusHours(3));
        Hotel h = new Hotel("Azores 5 stars", "Azores", 1400);

        Reservation r = resSys.bookReservation(f, h);

        System.out.println("Flight booked: " + f.getFlightNumber());
        System.out.println("Hotel booked: " + h.getName());

        System.out.println(resSys);

        resSys.cancelReservation(r);

        System.out.println(resSys);
    }
}
