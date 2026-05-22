package org.example.W3Schools.LamdasW3Schools.LamdaOtherResourceGPTEx19;

import java.math.BigInteger;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        BinaryOperator<Integer> maxInt = (i,h) -> i.compareTo(h) > 0 ? i : h;
        System.out.println("Max of 5 and 10: " + maxInt.apply(5, 10));
    }
}
