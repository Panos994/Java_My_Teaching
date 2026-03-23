package org.example.W3Schools.LamdasW3Schools.Lamda4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterOddEven {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7);
        System.out.println("\nPrint all nums: ");
        for(int n : nums){
            System.out.print(n + " ");
        }

        System.out.println("\nPrint even nums: ");
        List evenNums = nums.stream().filter(n -> n%2== 0).collect(Collectors.toList());
        evenNums.forEach(s -> System.out.print(s));

        System.out.println("\nPrint odd nums: ");
        List oddNums = nums.stream().filter(n -> n%2!= 0).collect(Collectors.toList());
        oddNums.forEach(s -> System.out.print(s));
    }
}
