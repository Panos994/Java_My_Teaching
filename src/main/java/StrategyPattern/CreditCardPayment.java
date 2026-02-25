package StrategyPattern;

public class CreditCardPayment implements PaymentStrategy{
    @Override
    public void pay(double amount) {
        System.out.println("making the payment of " + amount + " using Credit card");
    }


}
