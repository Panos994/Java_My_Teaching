package org.example.W3Schools.JavaSmallProjectAndEx.ExX7;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bank {
    private List<Account> accounts = new ArrayList<>();;


    public void addAccount(Account acc){
        accounts.add(acc);
    }
    public void removeAccount(Account acc){
        if(acc!= null){
            accounts.remove(acc);
        }
    }


    public void depositMoney(Account acc, double depositAmount){
        double totalBalance = 0.0;
        double currentBal = acc.getBalance();
        if(acc!= null){
            totalBalance = currentBal+depositAmount;
        }
        acc.setBalance(totalBalance);
        System.out.println("Total Balance after deposit: " + currentBal);
    }

    public void withDrawMoney(Account acc, double depositAmount){
        double totalBalance = 0.0;
        double currentBal = acc.getBalance();
        if(acc!=null && currentBal>=depositAmount){
            totalBalance = currentBal - depositAmount;

        }
        acc.setBalance(totalBalance);
        System.out.println("Total Balance after withdrawal: " + currentBal);
    }
}
