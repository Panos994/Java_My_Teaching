package org.example.W3Schools.StreamsW3Schools.StreamOtherResourceGPTEx15;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);
        int res = nums.stream().filter(n -> n%2 == 0).mapToInt(n -> n* n).sum();
        System.out.println(res);
    }
}
