package org.example.W3Schools.JavaSmallProjectAndEx.ExX20;

import java.math.BigDecimal;

public class Runner {
    public static void main(String[] args) {
        BankAccount bAcc = new BankAccount(1,"jOHNAKOS GER",new BigDecimal(10000));

        SavingsAccount sav = new SavingsAccount( 3, "Maria Joe", new BigDecimal(50000), new BigDecimal("0.05"));

        bAcc.deposit(new BigDecimal(5000));
        System.out.println("Balance after deposit: " + bAcc.getBalance());

        bAcc.withdraw(new BigDecimal(2000));
        System.out.println("Balance after withdrawal: " + bAcc.getBalance());

        sav.applyInterest();
        System.out.println("Balance after applying interest: " + sav.getBalance());
    }
}
