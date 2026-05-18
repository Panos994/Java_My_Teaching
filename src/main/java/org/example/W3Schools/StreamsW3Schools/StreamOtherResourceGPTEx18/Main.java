package org.example.W3Schools.StreamsW3Schools.StreamOtherResourceGPTEx18;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> words = List.of("java", "stream", "api", "lambda", "code", "java", "api");
        Map<Integer, Long> wordLengthAndCount = words.stream().collect(Collectors.groupingBy(String::length, Collectors.counting()));

        System.out.println(wordLengthAndCount);

        //if I want map to be shown ordered by key (meaning by length)
        Map<Integer, Long> wordLengthAndCount2 =
                words.stream()
                        .collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.counting()));

        System.out.println(wordLengthAndCount2);

        List<Integer> nums = List.of(5, 2, 9, 2, 4, 7, 4, 4, 10);

        List<Integer> top3FrequentNums = nums.stream().collect(Collectors.groupingBy(n-> n,Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((Comparator.<Map.Entry<Integer,Long>> comparingLong(e->e.getValue().longValue()).reversed()).thenComparingInt(Map.Entry::getKey))
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println(top3FrequentNums);
    }
}
