package org.example.W3Schools.LamdasW3Schools.LamdaOtherResourceGPTEx20;

import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Predicate<String> stCheck = s-> s.length() >5;

        if(stCheck.test("Ertonv")){
            System.out.println("String is longer than 5 characters");
        } else {
            System.out.println("String is not longer than 5 characters");
        }
    }
}
