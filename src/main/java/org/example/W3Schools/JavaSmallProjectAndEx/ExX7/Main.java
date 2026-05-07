package org.example.W3Schools.JavaSmallProjectAndEx.ExX7;

import com.beust.ah.A;

public class Main {
    public static void main(String[] args) {
        Bank b = new Bank();
        Account acc1 = new Account("John Doe", 1000.0);
        Account acc2 = new Account("Jane Smith", 2000.0);
        b.addAccount(acc1);
        b.addAccount(acc2);

        b.depositMoney( acc1, 300);
        b.withDrawMoney(acc1, 100);

        System.out.println("Balance of " + ": " + acc1.getBalance());
    }
}
