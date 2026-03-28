package org.example.W3Schools.StreamsW3Schools.Stream6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortStringsAZAndZAWithStreams {
    public static void main(String[] args) {
        List<String> strList = Arrays.asList("Banana", "Apple", "Cherry", "Date", "Elderberry");

        List<String> sortedAz = strList.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedAz);
        List<String> sortedzA = strList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(sortedzA);
    }
}
