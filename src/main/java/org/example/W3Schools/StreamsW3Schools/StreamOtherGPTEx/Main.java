package org.example.W3Schools.StreamsW3Schools.StreamOtherGPTEx;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> filtering = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenFiltered = filtering.stream().filter(n-> n%2 == 0).collect(Collectors.toList());
        System.out.println(evenFiltered);
        List<Integer> sqFiltered = filtering.stream().filter(n -> n%2 ==0).map(n->n*n).sorted().collect(Collectors.toList());
        System.out.println(sqFiltered);
    }
}
