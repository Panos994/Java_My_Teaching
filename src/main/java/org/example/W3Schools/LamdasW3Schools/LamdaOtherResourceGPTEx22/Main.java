package org.example.W3Schools.LamdasW3Schools.LamdaOtherResourceGPTEx22;

import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Predicate<Integer> multiplierOfThree = n -> n%3==0;
        System.out.println(multiplierOfThree.test(9)); // true
        System.out.println(multiplierOfThree.test(10)); // false
    }
}
