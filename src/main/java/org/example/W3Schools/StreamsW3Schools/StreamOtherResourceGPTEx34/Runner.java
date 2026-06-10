package org.example.W3Schools.StreamsW3Schools.StreamOtherResourceGPTEx34;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Runner {
    public static void main(String[] args) {
        List<String> myLs = new ArrayList<>(List.of("apple","banana","kiwi"));

        List<Integer> newList = myLs.stream().map(s-> s.length()).collect(Collectors.toList());
        System.out.println(newList);
    }

}
