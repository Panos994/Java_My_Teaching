package org.example.W3Schools.JavaSmallProjectAndEx.ExX20;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BankAccount {
    private int accountNumber;
    private String accountHolderName;
    private BigDecimal balance;

    public BigDecimal deposit(BigDecimal amount){
        setBalance(balance.add(amount));
        return balance;
    }

    public BigDecimal withdraw(BigDecimal amount){
        setBalance(balance.subtract(amount));
        return balance;
    }
    public BigDecimal checkBalance(){
        return balance;
    }
}
