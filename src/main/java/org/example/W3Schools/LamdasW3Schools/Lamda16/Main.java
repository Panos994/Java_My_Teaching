package org.example.W3Schools.LamdasW3Schools.Lamda16;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
        boolean isExistingWord = words.stream().anyMatch(s -> s.equals("apple"));
        System.out.println(isExistingWord);
    }
}
