package org.example.W3Schools.JavaSmallProjectAndEx.ExX27;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CustomerOrder {
    static int LAST_ID = 1;
    private int orderId;
    private Customer customer;
    private LocalDateTime orderDate = LocalDateTime.now();

    public CustomerOrder(Customer customer, LocalDateTime orderDate) {
        orderId = LAST_ID++;
        this.customer = customer;
        this.orderDate = orderDate;
    }

    public void calculateDeliveryTime(){
        System.out.println("Calculating delivery time for order " + orderId + "...");
    }
}
