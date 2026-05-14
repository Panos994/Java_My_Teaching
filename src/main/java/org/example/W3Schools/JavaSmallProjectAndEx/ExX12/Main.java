package org.example.W3Schools.JavaSmallProjectAndEx.ExX12;

import com.beust.ah.A;

import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime todayAt3PM = now.with(LocalTime.of(15, 0));
        Airplane boeing457 = new Airplane( 00457, "Dubai", todayAt3PM,Status.DELAYED);

        boeing457.getDepartureTime();
        System.out.println(boeing457.isDelayed(todayAt3PM.plusMinutes(30)));
        boeing457.checkStatus();
    }
}
