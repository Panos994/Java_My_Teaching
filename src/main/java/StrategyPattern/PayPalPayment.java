package StrategyPattern;

public class PayPalPayment implements PaymentStrategy{

    @Override
    public void pay(double amount) {
        System.out.println("making the payment of " + amount + " using Paypal");
    }
}
