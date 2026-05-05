package org.example.W3Schools.LamdasW3Schools.LamdaOtherResourceGPTEx8;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class Main {
    public static void main(String[] args) {
        BinaryOperator<Integer> sum = (a,b)-> a + b;
        System.out.println(sum.apply(10,45));

        List<String> names = List.of("Alice", "Bob", "Charlie");
        names.forEach(name -> System.out.println(name));

        BiFunction<Integer, Integer, Integer> max = (x,y) -> x >y ? x : y;
        System.out.println(max.apply(101,1000));
    }
}
