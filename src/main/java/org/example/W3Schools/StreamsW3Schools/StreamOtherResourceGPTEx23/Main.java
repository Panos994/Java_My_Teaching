package org.example.W3Schools.StreamsW3Schools.StreamOtherResourceGPTEx23;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = List.of("Anna", "Bob", "Alexander", "Maria", "Chris");
        List<String> f = names.stream().filter(s->s.startsWith("A")).map(String::toUpperCase).toList();
        f.forEach(System.out::println);
    }
}
