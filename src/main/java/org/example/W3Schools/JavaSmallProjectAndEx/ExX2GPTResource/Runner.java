package org.example.W3Schools.JavaSmallProjectAndEx.ExX2GPTResource;


import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        LoyalCustomer lc = new LoyalCustomer("Takis","tak@gm.com");


        Purchase pc1 = new Purchase("Laptop", 900);
        Purchase pc2 = new Purchase("Tablet",1000);

        lc.addPurchase(pc1);
        lc.addPurchase(pc2);

        System.out.println(lc.getPurchaseList());
        lc.applyDiscount();
        System.out.println(lc.getPurchaseList());

        System.out.println(lc.totalCost());
    }
}
