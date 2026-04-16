package org.example.W3Schools.StreamsW3Schools.StreamOtherResourceGPTEx3;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum = nums.stream().filter(n-> n%2 ==0 && n > 10).mapToInt(Integer::intValue).sum();
        System.out.println(sum);
    }
}
