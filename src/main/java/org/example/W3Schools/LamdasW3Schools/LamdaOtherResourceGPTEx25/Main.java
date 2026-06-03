package org.example.W3Schools.LamdasW3Schools.LamdaOtherResourceGPTEx25;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<String, Integer> rtLenOfAStr = (str) -> str.length();
        System.out.println(rtLenOfAStr.apply("Hello, World!"));
    }
}
