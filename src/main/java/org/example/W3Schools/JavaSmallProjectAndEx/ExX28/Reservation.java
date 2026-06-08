package org.example.W3Schools.JavaSmallProjectAndEx.ExX28;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

enum ReservationStatus{
    PROCESSED, CANCELLED, COMPETED, BOOKED
}
enum CustomerStatus {
    CANCELLED, PENDING, ARRIVED
}
@Getter
@Setter

@NoArgsConstructor
@ToString
public class Reservation {
    Scanner sc = new Scanner(System.in);
    static int LAST_ID = 1;
    private int reservationId;
    private String customerName;
    private LocalDateTime date;
    private ReservationStatus status;
    private CustomerStatus cStatus;

    public Reservation(String customerName, LocalDateTime date, ReservationStatus status, CustomerStatus cStatus) {
        reservationId = LAST_ID++;
        this.customerName = customerName;
        this.date = date;
        this.status = status;
        this.cStatus = cStatus;
    }

    public void checkReservationStatus(LocalDateTime arrivalDate){

        checkVisitorArrival(arrivalDate, cStatus);
    }

    public void checkVisitorArrival(LocalDateTime arrivalDate, CustomerStatus status){
        if(date.equals(arrivalDate)){
            System.out.println("Visitor has come and the resevation is Processed");
            setStatus(ReservationStatus.PROCESSED);
        }
        if(status == CustomerStatus.CANCELLED){
            System.out.println("Customer cancelled the booking");
        } else if (status == CustomerStatus.ARRIVED){
            System.out.println("Customer has arrived! All good!");
        } else if(status == CustomerStatus.PENDING){
            System.out.println("Customer choice or payment is in PENDING status");
        }

    }

    public void modifyReservationDetails(){
        setCustomerName(sc.nextLine());
        setDate(LocalDateTime.now());
    }
}
