package StrategyPattern;

public class PaymentTest {
    public static void main(String[] args){
        PaymentContext context = new PaymentContext(new CreditCardPayment()); //first initialize the PaymentContext object
        context.pay(500.0);
                                                                              //and then via PaymentContext object can use different payment methods with the setter
        context.setPaymentStrategy(new PayPalPayment());
        context.pay(535.1);

        context.setPaymentStrategy(new BankTransferPayment());
        context.pay(1001.5);

    }
}
