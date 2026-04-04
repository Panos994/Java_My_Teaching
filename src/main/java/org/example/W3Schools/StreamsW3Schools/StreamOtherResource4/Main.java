package org.example.W3Schools.StreamsW3Schools.StreamOtherResource4;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

//        double sum = numbers.stream().filter(n -> n%2==0).map(n -> n * n).reduce(0, Integer::sum);
        int sum = numbers.stream().mapToInt(n -> n*n).filter(n -> n%2==0).sum();
        System.out.println(sum);
    }
}
