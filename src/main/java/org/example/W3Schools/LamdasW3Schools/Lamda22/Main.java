package org.example.W3Schools.LamdasW3Schools.Lamda22;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<String> list = List.of("Java", "Python", "C++", "JavaScript","java","python");

        boolean isUpper = checkCase(list, s->s.equals(s.toUpperCase()), String::toUpperCase);
        System.out.println("All strings are uppercase: " + isUpper);

        boolean isLower = checkCase(list, s->s.equals(s.toLowerCase()), String::toUpperCase);
        System.out.println("All strings are uppercase: " + isLower);

        boolean isMixed = !isLower && !isUpper;
        System.out.println("All strings are mixed case: " + isMixed);
    }

    public static boolean checkCase(List<String> strings , Predicate<String> checkFun, Function<String, String> convertFun){
        String firstStr = strings.get(0);
        String convertedStr = convertFun.apply(firstStr);
        return strings.stream().allMatch(s->checkFun.test(s));
    }
}
