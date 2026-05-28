package org.example.W3Schools.LamdasW3Schools.LamdaOtherResourceGPTEx22;

import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Predicate<Integer> multiplierOfThree = n -> n%3==0;
        System.out.println(multiplierOfThree.test(9)); // true
        System.out.println(multiplierOfThree.test(10)); // false


        Function<String,Integer> lengthStr = s-> s.length();
        System.out.println(lengthStr.apply("Hello")); // 5
        Function<String,Integer> lenV2 = String::length;
        System.out.println(lenV2.apply("Hello")); // 5
    }
}
