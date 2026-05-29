package org.example.W3Schools.StreamsW3Schools.StreamOtherResourceGPTEx27;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        int max = l.stream().max(Integer::compare).orElseThrow();
        System.out.println(max);
    }
}
