package org.example.W3Schools.LamdasW3Schools.LamdaOtherResourceGPTEx18;

import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<String> names = List.of("Anna", "alex", "George", "andrew", "Ariana", "Bob", "alice");
        Predicate<String> filtered = s -> s.length() >= 5 && (s.startsWith("A") || s.startsWith("a"));
        names.stream().filter(filtered).forEach(System.out::println);
    }
}
