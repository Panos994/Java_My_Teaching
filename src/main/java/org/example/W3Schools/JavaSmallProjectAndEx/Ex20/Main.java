package org.example.W3Schools.JavaSmallProjectAndEx.Ex20;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        List<Integer> evenN = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println(evenN);
        List<Integer> oddN = numbers.stream().filter(n -> n % 2 != 0).collect(Collectors.toList());
        System.out.println(oddN);
    }
}
