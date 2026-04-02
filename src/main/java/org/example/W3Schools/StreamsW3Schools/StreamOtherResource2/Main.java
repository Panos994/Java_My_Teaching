package org.example.W3Schools.StreamsW3Schools.StreamOtherResource2;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> sentences = Arrays.asList(
                "Java Stream API provides a fluent interface for processing sequences of elements.",
                "It supports functional-style operations on streams of elements, such as map-reduce transformations.",
                "In this exercise, you need to count the total number of words in all sentences."
        );

        int count = sentences.stream().filter(sentence -> sentence.split(" ").length > 0).mapToInt(sentence -> sentence.split(" ").length).sum();
        System.out.println(count);

        //or
        long count2 = sentences.stream().flatMap(e -> Arrays.stream(e.split(" "))).distinct().count();
        System.out.println(count);
    }
}
