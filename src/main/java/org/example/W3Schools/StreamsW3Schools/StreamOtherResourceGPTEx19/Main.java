package org.example.W3Schools.StreamsW3Schools.StreamOtherResourceGPTEx19;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(List.of("  Alice", "alex", "Bob", "ALICE", " anna "));
        List<String> distinctNames =
                names.stream()
                        .filter(Objects::nonNull)
                        .map(String::trim)
                        .map(String::toLowerCase)
                        .filter(s -> s.startsWith("a"))
                        .distinct()
                        .sorted()
                        .toList();
        System.out.println(distinctNames);
    }
}
