package org.example.W3Schools.StreamsW3Schools.StreamOtherResourceGPTEx4;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, -2, 3, -4, 5);
        List<Integer> filteredN = nums.stream().filter(n -> n > 0).map(n -> n*2).sorted().sorted(Comparator.reverseOrder()).toList();
        System.out.println(filteredN);


    }
}
