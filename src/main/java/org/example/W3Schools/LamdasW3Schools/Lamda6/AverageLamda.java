package org.example.W3Schools.LamdasW3Schools.Lamda6;

import java.util.Arrays;
import java.util.List;

public class AverageLamda {
    public static void main(String[] args) {
        //Find average of doubles using lambda
        //Write a Java program to implement a lambda expression to find the average of a list of doubles.

        List<Double> list = Arrays.asList(1.0,2.0,3.0,4.0,5.0);
        double avg = list.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
        System.out.println("Average value of the said numbers: " + avg);

    }
}
