package org.example.W3Schools.LamdasW3Schools.LamdaOtherResourceGPTExX4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
//        Predicate<String> isUpperAndLengthMoreThan5 = s -> {
//               String t = s.trim();
//               return t.length() > 5 && Character.isUpperCase(t.charAt(0));
//        };
        Predicate<String> isUpperAndLengthAtLeast5AndStartsUpper =
                s -> s != null && (s = s.trim()).length() >= 5 && Character.isUpperCase(s.charAt(0));

        List<String> strings = new ArrayList<>(List.of("Mry","adf","Loodf","HHHDFASS"));
        for(String st : strings){
            System.out.println(st + " is length 5 and uppercase--> " + isUpperAndLengthAtLeast5AndStartsUpper.test(st));
        }

        System.out.println("-".repeat(50));
        List<Integer> nus = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9,-9,-3));

        nus.sort(
                Comparator.comparingInt((Integer x) -> Math.abs(x))
                        .thenComparing(Comparator.reverseOrder())
        );
        System.out.println(nus);


//        String s = "Java is the best programming language in the world";
//        Supplier<String> st = () -> {
//            String longest = "";
//            if (s == null || s.trim().isEmpty()) {
//                return longest;
//            }
//
//            for (String word : s.trim().split("\\s+")) {
//                if (word.length() > longest.length()) {
//                    longest = word;
//                }
//            }
//            return longest;
//        };
//        System.out.println(st.get());

    }
}
