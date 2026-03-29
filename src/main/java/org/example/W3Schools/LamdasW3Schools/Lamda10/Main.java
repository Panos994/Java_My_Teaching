package org.example.W3Schools.LamdasW3Schools.Lamda10;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        BiFunction<String, String, String> concatStr = (s1, s2) -> {
            String s3 = s1 + "," + s2;
            return s3;
        };

        String str1 = "Hello ";
        String str2 = " How are you?";
        String res = concatStr.apply(str1, str2);
        System.out.println(res);
        System.out.println("-".repeat(100));


        String[] strs = {"Bob","Sara","Makis"};
        String res1 = String.join("/",strs);
        System.out.print(res1);

    }
}
