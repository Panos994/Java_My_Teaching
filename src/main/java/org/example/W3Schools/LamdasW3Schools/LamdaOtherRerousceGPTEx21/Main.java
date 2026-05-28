package org.example.W3Schools.LamdasW3Schools.LamdaOtherRerousceGPTEx21;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<Integer, Integer> sdf = x->x*x;
        System.out.println(sdf.apply(5)); // 25
    }
}
