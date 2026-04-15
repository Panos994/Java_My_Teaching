package org.example.W3Schools.StreamsW3Schools.StreamOtherResourceGPTEx2;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie", "David", "Ava", "avff");
        List<String> filteredCapitalA = names.stream().filter(s-> s.startsWith("A")).map(s->s.toLowerCase()).collect(Collectors.toList());
        System.out.println(filteredCapitalA);
    }
}
