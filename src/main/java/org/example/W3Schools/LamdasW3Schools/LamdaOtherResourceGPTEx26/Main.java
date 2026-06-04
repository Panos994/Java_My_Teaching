package org.example.W3Schools.LamdasW3Schools.LamdaOtherResourceGPTEx26;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<Integer, Integer> sqn = x -> x*x;
        System.out.println(sqn.apply(5)); // Output: 25
    }
}
