package org.example.W3Schools.LamdasW3Schools.Lamda8;

import java.util.function.LongUnaryOperator;

public class Main {
    public static void main(String[] args) {
        LongUnaryOperator factorial = n -> {
            long result = 1;
            for (long i = 1; i <= n; i++) {
                result *= i;
            }
            return result;
        };

        long n = 5;
        long factoriln = factorial.applyAsLong(n);
        System.out.println(factoriln);

    }
}
