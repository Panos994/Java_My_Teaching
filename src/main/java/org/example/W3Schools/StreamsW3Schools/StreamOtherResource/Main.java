package org.example.W3Schools.StreamsW3Schools.StreamOtherResource;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eva");
        int longestCharName = names.stream().filter(name -> name.length() > 2).mapToInt(String::length).max().getAsInt();
        System.out.println(longestCharName);
    }
}
