package org.example.W3Schools.LamdasW3Schools.LamdaExerciseOtherResourceGPT1;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> myList = List.of("Hello", "World", "Java", "Lambda", "Expressions");
        List<String> sortedL = myList.stream().sorted(Comparator.comparing(s -> s.length())).toList();

        System.out.print(sortedL);
    }
}
