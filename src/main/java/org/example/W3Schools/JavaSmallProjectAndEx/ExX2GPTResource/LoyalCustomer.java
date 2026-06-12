package org.example.W3Schools.JavaSmallProjectAndEx.ExX2GPTResource;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class LoyalCustomer extends Customer {

    private static double discount = 0.09;

    public LoyalCustomer(String name, String email) {
        super(name, email);
    }

    public void applyDiscount(){

        for(Purchase p : getPurchaseList()){
            p.setPrice(p.getPrice() - (p.getPrice() * discount));
        }
    }
}
