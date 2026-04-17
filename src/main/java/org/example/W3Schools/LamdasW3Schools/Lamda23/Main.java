package org.example.W3Schools.LamdasW3Schools.Lamda23;

import java.util.List;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
       List<String> colors = List.of("Red", "Green", "Blue");
       double averL = colors.stream().mapToInt(String::length).average().orElse(0);
        System.out.println("Average length of colors: " + averL);


    }


}
