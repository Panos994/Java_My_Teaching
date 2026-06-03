package org.example.W3Schools.JavaSmallProjectAndEx.ExX25;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class ResidentialBuilding extends Building{

    private int numberOfapartments;
    final static int rentPerApartment = 500;

    public ResidentialBuilding(String address, int numberOfFloors, int totalArea, int numberOfapartments) {
        super(address, numberOfFloors, totalArea);
        this.numberOfapartments = numberOfapartments;
    }

    @Override
    public double calculateTotalRent() {
        return super.calculateTotalRent() + (numberOfapartments * rentPerApartment);
    }
}
