package org.example.W3Schools.StreamsW3Schools.StreamOtherResourceGPTEx9;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> myInts = List.of(1,2,3,4,5,6,7,8,8,10);
        List<Integer> filt = myInts.stream().filter(n->n%2 == 0).map(n->n*4).toList();
        System.out.println(filt);
    }
}
