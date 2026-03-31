package org.example.W3Schools.StreamsW3Schools.Stream9;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Double> squared = numbers.stream().map(n -> Math.pow(n,2)).collect(Collectors.toList());
        for(Double nms : squared){
            System.out.print(String.format("%.2f ", nms));
        }

    }
}
