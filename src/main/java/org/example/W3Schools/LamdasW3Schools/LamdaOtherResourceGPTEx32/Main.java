package org.example.W3Schools.LamdasW3Schools.LamdaOtherResourceGPTEx32;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> sum = (x,y) -> x+y;

        System.out.println(sum.apply(3,4));
        List<Integer> ist = new ArrayList<>(List.of(1,2,3,44,5));
        Function<List<Integer>, Optional<Integer>> max = l -> l.stream().max(Comparable::compareTo);
        System.out.println(max.apply(ist));
    }
}
