package org.example.W3Schools.StreamsW3Schools.StreamOtherResourceGPTEx22;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> genStrings = new ArrayList<>(List.of("Hello", "World", "Java", "Streams", "A-Example"));
        List<String> filtered = genStrings.stream().filter(s->s.startsWith("A") || s.startsWith("a")).toList();
        System.out.println(filtered);
    }
}
