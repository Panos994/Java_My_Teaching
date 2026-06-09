package org.example.W3Schools.LamdasW3Schools.LamdaOtherResourceGPTEx29;

import com.google.gson.internal.bind.util.ISO8601Utils;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<Integer,Integer> squared = n -> n*n;
        System.out.println(squared.apply(5));
    }
}
