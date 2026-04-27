package org.example.W3Schools.StreamsW3Schools.StreamOtherResourceGPTEx8;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> myL = List.of(1, 2, 3, 4, 5,6,7,8,9);
        List<Integer> myLfiltered = myL.stream().filter(n ->n%3 ==0).map(n->n*5).toList();
        System.out.println(myLfiltered);
    }
}
