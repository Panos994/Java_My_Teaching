package org.example.W3Schools.LamdasW3Schools.LamdaExercise2;

import java.util.function.Predicate;

public class StringEmptiness {
    public static void main(String[] args) {
        Predicate<String> isEmptyString = str -> str.isEmpty();

        String str1 = "";
        String str2 = "Hey, checking is your are empty! ";


        System.out.println("String 1:" + str1);
        System.out.println("String 1 is empty: " + isEmptyString.test(str1));
        System.out.println("\nString 2:" + str2);
        System.out.println("String 2 is empty: " + isEmptyString.test(str2));
    }


}
