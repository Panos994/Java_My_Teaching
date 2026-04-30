package org.example.W3Schools.StreamsW3Schools.StreamOtherReousrceGPTEx5;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = List.of(3, 10, 4, 7, 12, 5, 10);

        List<Integer> res = nums.stream()
                .filter(n -> n % 2 == 0)
                .distinct()
                .sorted(Comparator.reverseOrder()) // descending
                .map(n -> n * 2)
                .toList();

        System.out.println(res); // [24, 20, 8]
    }

}
