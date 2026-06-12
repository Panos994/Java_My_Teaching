package org.example.W3Schools.JavaSmallProjectAndEx.ExX2GPTResource;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Customer {
    private String name;
    private String email;
    private List<Purchase> purchaseList;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
        purchaseList = new ArrayList<>();
    }

    public void addPurchase(Purchase p){
        purchaseList.add(p);
    }

    public double totalCost(){
        double cost = 0.0;
        for(Purchase p : purchaseList){
            cost+=p.getPrice();
        }
        return cost;
    }
}
