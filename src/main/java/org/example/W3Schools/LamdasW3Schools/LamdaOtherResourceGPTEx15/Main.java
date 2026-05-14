package org.example.W3Schools.LamdasW3Schools.LamdaOtherResourceGPTEx15;

import java.math.BigInteger;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Integer> a = List.of(3, 10, 7, 8, 2, 9); /* 1-line: χρησιμοποίησε forEach + lambda */
        a.forEach(n -> { if (n % 2 == 0) System.out.println(n); });
        //or bitwise
        System.out.println("Using bitwise:");
        a.forEach(n -> {
            if ((n & 1) == 0) System.out.println(n);
        });
    }
}
