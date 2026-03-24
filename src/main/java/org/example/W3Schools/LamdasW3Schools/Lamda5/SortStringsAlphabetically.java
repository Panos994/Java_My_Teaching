package org.example.W3Schools.LamdasW3Schools.Lamda5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortStringsAlphabetically {
    public static void main(String[] args) {
        String[] names = {"Georgia","Adam","Vilma"};
        Arrays.stream(names).sorted().forEach(s -> System.out.println(s));

        //or in a list
        List<String> namesList = Arrays.asList("Georgios","Adamantios","Vilmarios");
        System.out.println("\n before sort: ");
        for(var str : namesList){
            System.out.println(str);
        }
        //after sorting
        namesList.sort((s1,s2) -> s1.compareToIgnoreCase(s2));
        System.out.println("\n sorted: ");
        for(var str : namesList){
            System.out.println(str);
        }

    }
}
