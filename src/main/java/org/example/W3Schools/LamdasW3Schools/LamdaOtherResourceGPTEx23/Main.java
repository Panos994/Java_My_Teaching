package org.example.W3Schools.LamdasW3Schools.LamdaOtherResourceGPTEx23;

import com.google.gson.internal.bind.util.ISO8601Utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        List<Integer> f = l.stream().filter(n->n%2==0).toList();
        System.out.println(f);

        int num = 5;
        Predicate<Integer> isE = n->n%2==0;
        Consumer<Integer> print = System.out::println;
        Function<Integer,Integer> sq = n->n*n;
        System.out.println(isE.test(num));   // false
        print.accept(num);                   // 5
        System.out.println(sq.apply(num));    // 25

        Function<String,String> isUpper = String::toUpperCase;
        System.out.println(isUpper.apply("hello world"));
        Consumer<String> isU = System.out::println;
        isU.accept(isUpper.apply("hello world")); // "hello world"
        // "HELLO WORLD"
    }



}
