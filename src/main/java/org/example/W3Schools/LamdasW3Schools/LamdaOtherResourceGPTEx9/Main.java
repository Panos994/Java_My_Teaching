package org.example.W3Schools.LamdasW3Schools.LamdaOtherResourceGPTEx9;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        Predicate<Integer> isEven = (n) -> n%2 ==0;
        for(Integer n : nums){
            System.out.println(n + " is interger --> " + isEven.test(n));
        }
    }
}
