package org.example.W3Schools.LamdasW3Schools.LamdaOtherResourceGPTEx24;

import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Predicate<String> sLen = s->s.length() > 5;
        System.out.println(sLen.test("Hello"));
        System.out.println(sLen.test("Hello World"));
    }
}
