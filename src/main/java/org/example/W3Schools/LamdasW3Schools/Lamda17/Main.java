package org.example.W3Schools.LamdasW3Schools.Lamda17;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> strsList = Arrays.asList("Hello", "World", "Java", "Programming", "Lambda");
        int maxLength = strsList.stream().mapToInt(String::length).max().orElse(0);
        System.out.println("Maximum length of strings: " + maxLength);

        int minLength = strsList.stream().mapToInt(String::length).min().orElse(0);
        System.out.println("Minimum length of strings: " + minLength);
    }
}
