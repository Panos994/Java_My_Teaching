package org.example.W3Schools.StreamsW3Schools.StreamOtherResourceGPTEx24;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("java", "stream", "lambda", "cat", "school");
        long count = words.stream().filter(s -> s.length() > 4).count();
        System.out.println("Words longer than 4 characters: " + count);
    }
}
