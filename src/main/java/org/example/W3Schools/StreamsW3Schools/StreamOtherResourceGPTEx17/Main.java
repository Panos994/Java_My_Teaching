package org.example.W3Schools.StreamsW3Schools.StreamOtherResourceGPTEx17;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> b = List.of(1, 6, 2, 10, 5, 9); /* 1-line: stream().filter(...).mapToInt(...).sum() */
        int sum = b.stream().filter(n -> n > 5).mapToInt(Integer::intValue).sum();
        System.out.println("Sum of numbers greater than 5: " + sum);
    }
}
