package org.example.W3Schools.JavaSmallProjectAndEx.ExX22;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@ToString
public class LoyalCustomer extends Customer {
    private static final double discountRate = 0.05;

    public LoyalCustomer(String name, String email, List<Purchase> purchaseHistory) {
        super(name, email, purchaseHistory);
    }

    public LoyalCustomer() {
    }

    public double applyDiscount(){
        double expensesAfterDiscount = 0.0;
        if(calcTotalExpenses() > 2500){
            expensesAfterDiscount = calcTotalExpenses() - calcTotalExpenses() * discountRate;
        }
        System.out.println("Total expenses after discount: " + expensesAfterDiscount);
        return expensesAfterDiscount;
    }

}
