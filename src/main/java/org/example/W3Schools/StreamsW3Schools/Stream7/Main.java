package org.example.W3Schools.StreamsW3Schools.Stream7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Integer max = list.stream().max(Integer::compare).orElse(null);
        System.out.println("Max: " + max);
        Integer min = list.stream().min(Integer::compare).orElse(null);
        System.out.println("Min: " + min);
    }
}
