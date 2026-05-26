package org.example.W3Schools.JavaSmallProjectAndEx.ExX20;

import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
@ToString
public class SavingsAccount extends BankAccount{
    private BigDecimal interestRate;

    public SavingsAccount(int accountNumber, String accountHolderName, BigDecimal balance, BigDecimal interestRate) {
        super(accountNumber, accountHolderName, balance);
        this.interestRate = interestRate;
    }

    public BigDecimal applyInterest(){
        setBalance(getBalance().add(getBalance().multiply(interestRate)));
        return getBalance();
    }
}
