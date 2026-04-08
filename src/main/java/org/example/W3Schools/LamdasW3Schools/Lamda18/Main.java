package org.example.W3Schools.LamdasW3Schools.Lamda18;

import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Predicate<Integer> isPerfect = n -> {
            int sqrt = (int) Math.sqrt(n);
            return sqrt * sqrt == n;
        };

        int N = 36;
        boolean res1 = isPerfect.test(N);
        System.out.println(N + " is perfect square: " + res1);
    }
}
