package org.example.W3Schools.StreamsW3Schools.StreamOtherResourceGPTEx33;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Predicate<String> len = s-> s.length() >=5;
        System.out.println(len.test("Hello sir"));
        System.out.println("=============================");
        List<Integer> nums = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        List<Integer> filters = nums.stream().filter(n->n%2==0).map(n->n*2).toList();
        System.out.println(filters);
        System.out.println("=============================");
        int max = nums.stream().max(Integer::compareTo).orElseThrow();
        System.out.println(max);
        System.out.println("=============================");
        List<Integer> myN = new ArrayList<>(List.of(10,11,6,5,44,1,88));
        long countFilt = myN.stream().filter(n -> n>10).count();
        System.out.println(countFilt);

    }
}
