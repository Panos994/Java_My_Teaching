package org.example.W3Schools.StreamsW3Schools.StreamOtherResourceGPTEx10;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> myL = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int evenS = myL.stream()
                .filter(n-> n%2==0).mapToInt(Integer::intValue).sum();

        System.out.println("Sum of even numbers: " + evenS);

    }
}
