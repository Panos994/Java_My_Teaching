package org.example.W3Schools.StreamsW3Schools.StreamOtherResourceGPTExX3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(List.of("Alice", "Bob", "Charlie", "David", "Eve"));
        List<String> naem2 = names.stream().filter(name -> name.length() >= 4).map(String::toLowerCase).distinct().sorted().toList();
        System.out.println(naem2);
    }
}
