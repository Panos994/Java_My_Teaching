package org.example.W3Schools.JavaSmallProjectAndEx.ExX25;

public class Runner {
    public static void main(String[] args) {
        ResidentialBuilding rb = new ResidentialBuilding("Hilton Area 2003, USA",4, 250, 5);

        CommercialBuilding cb = new CommercialBuilding("Hilton Area Urban 2003, USA",4, 244, 4);


        System.out.println(rb.calculateTotalRent());
        System.out.println(cb.calculateTotalRent());
    }
}
