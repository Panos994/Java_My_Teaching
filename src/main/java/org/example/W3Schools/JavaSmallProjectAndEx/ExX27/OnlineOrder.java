package org.example.W3Schools.JavaSmallProjectAndEx.ExX27;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class OnlineOrder extends CustomerOrder{
    private int distanceFromHQ;
    private String deliveryAddress;
    private String trackingNumber;

    public OnlineOrder(Customer customer, LocalDateTime orderDate, int distanceFromHQ, String deliveryAddress, String trackingNumber) {
        super(customer, orderDate);
        this.distanceFromHQ = distanceFromHQ;
        this.deliveryAddress = deliveryAddress;
        this.trackingNumber = trackingNumber;
    }

    @Override
    public void calculateDeliveryTime() {
        super.calculateDeliveryTime();
        LocalDateTime estimatedDeliveryDate;
        if(distanceFromHQ <= 40){
            estimatedDeliveryDate= getOrderDate().plusDays(1);
        } else if(distanceFromHQ <=80){
            estimatedDeliveryDate = getOrderDate().plusDays(3);
        } else if(distanceFromHQ <= 300) {
            estimatedDeliveryDate = getOrderDate().plusDays(7);
        } else {
            estimatedDeliveryDate = getOrderDate().plusDays(12);
        }
        System.out.println("Estimated delivery time: " + estimatedDeliveryDate);
    }


}
