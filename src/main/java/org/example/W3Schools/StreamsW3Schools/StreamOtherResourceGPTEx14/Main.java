package org.example.W3Schools.StreamsW3Schools.StreamOtherResourceGPTEx14;

import org.w3c.dom.ranges.Range;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(List.of(1, 2, 3, 4, 5, 15, 16));
        int sum = nums.stream().filter(n -> n%2 ==0 && n >= 10 && n <= 100).distinct().mapToInt(Integer::intValue).sum();
        System.out.println(sum);
    }
}
