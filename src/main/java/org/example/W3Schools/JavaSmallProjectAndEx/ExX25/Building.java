package org.example.W3Schools.JavaSmallProjectAndEx.ExX25;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Building {
    final static int costPerMeter = 1100;
    private String address;
    private int numberOfFloors;
    private int totalArea;


    public double calculateTotalRent(){
        return totalArea * costPerMeter;
    }

}
