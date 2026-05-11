package org.example.W3Schools.LamdasW3Schools.LamdaOtherResourceGPTEx1;

import org.w3c.dom.ranges.Range;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
//        Function<String,Integer> numsSum = s -> (int)s.chars().filter(Character::isDigit).count();
        Function<String, Integer> digitCount = s -> s == null ? 0 : (int) s.chars().filter(Character::isDigit).count();
        System.out.println(digitCount.apply("Hello123")); // Output: 3

    }
}
