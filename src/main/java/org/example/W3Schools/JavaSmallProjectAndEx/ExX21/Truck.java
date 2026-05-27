package org.example.W3Schools.JavaSmallProjectAndEx.ExX21;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor

@ToString(callSuper = true)
public class Truck extends Vehicle{
    private int payloadCapacity;

    public Truck(String make, String model, int year, int payloadCapacity) {
        super(make, model, year);
        this.payloadCapacity = payloadCapacity;
    }
}
