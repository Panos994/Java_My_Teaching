package org.example.W3Schools.StreamsW3Schools.StreamOtherResourceGPTEx13;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(5, -2, 10, 10, 3, 0, -7, 8, 8, 1);
        List<Integer> filtered = nums.stream().filter(n -> n > 0).distinct().toList();
        int sumNegSquares = nums.stream().filter(n -> n < 0).mapToInt(n->n*n).sum();
        Map<Boolean,List<Integer>> evenOdd = nums.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Sum of squares of negative numbers: " + sumNegSquares);
        System.out.println("Even numbers: " + evenOdd.get(true));
        System.out.println("Odd numbers: " + evenOdd.get(false));
        System.out.println(filtered);
    }
}
