package org.example.W3Schools.JavaSmallProjectAndEx.ExX24;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter

@NoArgsConstructor
@ToString
public class WashingMachine extends ElectronicsProduct{
    private int warrantyPeriod;

    public WashingMachine(String name, double price) {
        super(name, price);
        this.warrantyPeriod = 2;
    }
    public void extendWarranty(int years){
        warrantyPeriod +=years;
    }

}
