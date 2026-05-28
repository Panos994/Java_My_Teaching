package org.example.W3Schools.JavaSmallProjectAndEx.ExX22;

import org.checkerframework.checker.units.qual.C;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        LoyalCustomer lc = new LoyalCustomer("John Doe", "jer@gml.com", new ArrayList<>());

        Purchase p = new Purchase("Book", 20.0);

        Purchase p1 = new Purchase("Car", 5000);
        lc.addPurchase(p);
        lc.addPurchase(p1);

        System.out.println("Total expenses: " + lc.calcTotalExpenses());
        System.out.println("After discount: " + lc.applyDiscount());
        System.out.println(lc.getPurchaseHistory());
    }
}
