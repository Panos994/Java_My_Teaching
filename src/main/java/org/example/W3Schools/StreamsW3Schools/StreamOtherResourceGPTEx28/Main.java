package org.example.W3Schools.StreamsW3Schools.StreamOtherResourceGPTEx28;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(List.of("John", "Jane", "Jack", "Jill", "James","Alexandros"));
        long count = names.stream().filter(s ->s.startsWith("A")).count();
        System.out.println("Count of names starting with A: " + count);
    }
}
