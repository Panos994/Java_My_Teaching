package org.example.W3Schools.StreamsW3Schools.Stream4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,4,4);

        List<Integer> removedDupl = list.stream().distinct().collect(Collectors.toList());
        System.out.print("List with duplicates removed: " + removedDupl);

    }
}
