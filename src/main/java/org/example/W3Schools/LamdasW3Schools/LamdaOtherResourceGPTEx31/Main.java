package org.example.W3Schools.LamdasW3Schools.LamdaOtherResourceGPTEx31;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<String, Integer> retSL = s->s.length();
        System.out.println(retSL.apply("werwrwer"));

        BiFunction<Integer,Integer,Integer> sum = (n,s1) -> n+s1;
        System.out.println(sum.apply(5,4));

        List<Integer> myN = new ArrayList<>(List.of(1,4,53,3));
        Function<List<Integer>, Optional<Integer>> maxN = n -> n.stream().max(Comparable::compareTo);

        System.out.println(maxN.apply(myN));
    }
}
