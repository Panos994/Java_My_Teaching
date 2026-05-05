package org.example.W3Schools.StreamsW3Schools.StreamOtherResourceGPTEx11;

import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
         int sumSq = IntStream.rangeClosed(1,5).map(x->x*x).sum();
         System.out.println("Sum of squares from 1 to 5: " + sumSq);

         List<String> myNames = List.of("Alice", "Bob", "Charlie", "David", "Eve");
         List<String> nfiltered = myNames.stream().filter(name -> name.startsWith("A")).toList();
         System.out.println("Names starting with A: " + nfiltered);
    }
}
