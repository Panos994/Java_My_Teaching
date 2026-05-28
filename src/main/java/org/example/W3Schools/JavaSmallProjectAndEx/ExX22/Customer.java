package org.example.W3Schools.JavaSmallProjectAndEx.ExX22;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Customer {
    private String name;
    private String email;
    private List<Purchase> purchaseHistory;

    public Customer(){
        purchaseHistory = new ArrayList<>();
    }

    public void addPurchase(Purchase p){
        purchaseHistory.add(p);
    }
    public double calcTotalExpenses(){
        double totalExpenses = 0.0;
        for(Purchase p : purchaseHistory){
            totalExpenses+=p.getExpenseOfProduct();
        }
        return totalExpenses;
    }


}
