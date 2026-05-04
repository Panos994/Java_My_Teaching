package org.example.W3Schools.LamdasW3Schools.LamdaOtherResourceGPTEx6;

import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Predicate<Integer> isEven = x -> x%2 == 0;

        System.out.println(isEven.test(4));
        System.out.println(isEven.test(5));
    }
}
