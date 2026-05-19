package org.example.W3Schools.LamdasW3Schools.LamdaOtherResourceGPTEx17;

import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Predicate<String> str = s -> s!= null && s.trim().length() >= 3 ? true : false;

        System.out.println(str.test("   ")); // false
        System.out.println(str.test("   abc")); // true
        System.out.println(str.test("   abcd ")); // true
    }
}
