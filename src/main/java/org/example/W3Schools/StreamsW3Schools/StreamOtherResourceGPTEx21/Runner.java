package org.example.W3Schools.StreamsW3Schools.StreamOtherResourceGPTEx21;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Runner {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>(List.of("apple", "banana", "cherry", "date", "elderberry", "fig", "grape"));
        Map<Character, Long> firstLetter = words.stream()
                .map(String::trim).filter(s->!s.isEmpty())
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(s -> s.charAt(0), Collectors.counting()));

        for(Map.Entry<Character, Long> entry : firstLetter.entrySet()){
            System.out.println("Letter: " + entry.getKey() + ", Count: " + entry.getValue());
        }



    }
}
