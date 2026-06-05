package org.example.W3Schools.JavaSmallProjectAndEx.ExX27;


import java.time.LocalDateTime;

public class Runner {
    public static void main(String[] args) {
        Customer ct = new Customer("George Dohn");

        OnlineOrder on = new OnlineOrder(ct, LocalDateTime.of(2026, 6,15,9,10), 90, "Pivot Table 45, Athens", "ui12312355eer");
        on.calculateDeliveryTime();

    }
}
