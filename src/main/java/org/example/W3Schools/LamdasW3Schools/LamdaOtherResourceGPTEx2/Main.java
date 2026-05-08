package org.example.W3Schools.LamdasW3Schools.LamdaOtherResourceGPTEx2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(List.of("Alice", "bob", "Charlie", "David", "Eve"));
        Predicate<String> isValidName = s-> {
            String t = s.trim();
            return t.length() >=3 && Character.isUpperCase(t.charAt(0))
                    && t.substring(1).chars().allMatch(Character::isLowerCase);
        };
        //or in one line with regex: Predicate<String> isValidName = s -> s.trim().matches("[A-Z][a-z]{2,}");
        for(String s : names){
//            isValidName.test(s);
            System.out.println("Is " + s + " a valid name? " +  isValidName.test(s));
        }
    }
}
