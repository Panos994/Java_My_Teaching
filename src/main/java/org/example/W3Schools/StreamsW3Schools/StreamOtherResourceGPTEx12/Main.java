package org.example.W3Schools.StreamsW3Schools.StreamOtherResourceGPTEx12;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("java", "ai", "stream", "code", "ok");

        List<String> upperC = words.stream().filter(s-> s.length() >= 4).map(String::toUpperCase).toList();
        System.out.println(upperC);
    }
}
