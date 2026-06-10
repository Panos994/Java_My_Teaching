package org.example.W3Schools.LamdasW3Schools.LamdaOtherResourceGPTEx30;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<Integer,Integer> sq = n -> n*n;
        System.out.println(sq.apply(11));
    }
}
