package org.example.W3Schools.StreamsW3Schools.StreamOtherResourceGPTEx30;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(List.of("John", "Alanne", "Jack", "Jill", "James"));

        Predicate<String> filteredLetters = name-> name.startsWith("A");
        names.stream().filter(filteredLetters).forEach(System.out::println);

    }
}
