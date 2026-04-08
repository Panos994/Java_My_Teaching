package org.example.W3Schools.StreamsW3Schools.StreamOtherResource5;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> doubledList = myList.stream().map(x ->x*2).toList();
        System.out.println(doubledList);
    }
}
