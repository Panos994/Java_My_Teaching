package org.example.W3Schools.StreamsW3Schools.StreamOtherResourceGPTEx7;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> myN = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> oddN = myN.stream().filter(n -> n%2!= 0).map(n->n * 2).collect(Collectors.toList());

        System.out.println(oddN);
    }
}
