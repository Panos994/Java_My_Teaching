package org.example.W3Schools.JavaSmallProjectAndEx.ExX19;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReservationSystem {

    private List<Flight> availableFlights = new ArrayList<>();
    private List<Hotel> availableHotels  = new ArrayList<>();
    private List<Reservation> reservations = new ArrayList<>();

    public List<Flight> searchFlights(String destination){
        List<Flight> flights = new ArrayList<>();
        for(Flight f : availableFlights){
            if(f.getDestination().equalsIgnoreCase(destination)){
                flights.add(f);
            }

        }
        return flights;
    }
    public List<Hotel> searchHotels(String location){
        List<Hotel> res = new ArrayList<>();
        for(Hotel f : availableHotels){
            if(f.getLocation().equalsIgnoreCase(location)){
                res.add(f);
            }

        }
        return res;
    }

    public Reservation bookReservation(Flight f, Hotel hotel){
        Reservation r = new Reservation(f, hotel);
        reservations.add(r);

        System.out.println("Reservation booked successfully!");
        return r;
    }

    public void cancelReservation(Reservation reservation){
        if(reservations.remove(reservation)){
            System.out.println("Reservation cancelled successfully!");
        } else {
            System.out.println("Reservation not found!");
        }

    }

}
