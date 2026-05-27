package org.example.W3Schools.JavaSmallProjectAndEx.ExX21;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor

@ToString
public class Car extends Vehicle{
    private int trunkSize;

    public Car(String make, String model, int year, int trunkSize) {
        super(make, model, year);
        this.trunkSize = trunkSize;
    }
}
