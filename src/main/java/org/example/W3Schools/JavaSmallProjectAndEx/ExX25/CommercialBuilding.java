package org.example.W3Schools.JavaSmallProjectAndEx.ExX25;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CommercialBuilding extends Building{

    private int officeSpaces;
    final static int rentPerOfficeSpace = 1000;
    public CommercialBuilding(String address, int numberOfFloors, int totalArea, int officeSpaces) {
        super(address, numberOfFloors, totalArea);
        this.officeSpaces = officeSpaces;
    }

    @Override
    public double calculateTotalRent() {
        return super.calculateTotalRent() + (officeSpaces * rentPerOfficeSpace);
    }
}
