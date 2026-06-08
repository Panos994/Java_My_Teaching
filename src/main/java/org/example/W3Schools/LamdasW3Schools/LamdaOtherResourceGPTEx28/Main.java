package org.example.W3Schools.LamdasW3Schools.LamdaOtherResourceGPTEx28;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Main { @FunctionalInterface
interface Sum {
    int add(int a, int b);
}

    public static void main(String[] args) {
        Sum sum = (a, b) -> + b;
        System.out.println(sum.add(10, 4));

        System.out.println("x".repeat(100));

        BiFunction<Integer, Integer, Integer> sumR = (n,n1) -> n+n1;
        System.out.println(sumR.apply(10,4));
    }

}
