package org.example.W3Schools.StreamsW3Schools.Stream8;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Integer secondLargest = list.stream().distinct().sorted((a,b) -> Integer.compare(b,a)).skip(1).findFirst().orElse(null);
        System.out.println(secondLargest);

        Integer secondSmallest = list.stream().distinct().sorted().skip(1).findFirst().orElse(null);
        System.out.println(secondSmallest);
    }
}
