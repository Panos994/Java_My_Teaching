package org.example.W3Schools.StreamsW3Schools.StreamOtherResourceGPTEx29;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<Integer> numbs = new ArrayList<>(List.of(45,1,2,3,44,5));
        int max = numbs.stream().max(Integer::compareTo).orElseThrow();
        System.out.println(max);
    }
}
