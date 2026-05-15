package org.example.W3Schools.LamdasW3Schools.LamdaOtherResourceGPTEx16;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(List.of("Nikos", "Giannis", "Al", "Maria"));
        names.sort(Comparator.comparing(String::length));
        System.out.println(names);

        List<String> words = List.of("Apple", "banana", "Avocado", "pear", "Apricot");
        words.stream().filter(word -> word.startsWith("A")).forEach(System.out::println);

        words.stream().filter(w -> w.toUpperCase().startsWith("A")).forEach(System.out::println);
    }
}
