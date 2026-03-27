package org.example.W3Schools.StreamsW3Schools.Stream5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Aello", "All", "Java", "Streams");
        char startLet = 'A';
        List<String> countLetterStringList = new ArrayList<>();
        long tt = strings.stream().filter(s -> s.startsWith(String.valueOf(startLet))).count();

        System.out.println("Number of words startsWith  " + startLet + " is " + tt);
    }
}
