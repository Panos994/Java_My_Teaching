package org.example.W3Schools.LamdasW3Schools.LamdaOtherResourceGPTEx11;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(List.of("Madison", "Jane", "Alison", "Berry", "James"));
        Comparator<String> sortedAlgorithmByName = Comparator.comparing(String::length);

        System.out.println("Before sorting: " + names);
        names.sort(sortedAlgorithmByName);
        System.out.println("After sorting: " + names);

        //or
        Comparator<String> cmp = Comparator.comparingInt(String::length)
                .thenComparing(Comparator.naturalOrder());

        System.out.println("Before sorting: " + names);
        names.sort(cmp);
        System.out.println("After sorting: " + names);
    }
}
