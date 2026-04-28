package org.example.W3Schools.LamdasW3Schools.LamdaOtherResourceGPTEx4;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> myList = List.of("Hello", "World", "Java", "Lambda", "Expressions");
        List<String> sortedList = myList.stream().sorted((s1,s2)-> s1.length() - s2.length()).toList(); //για φθινουσα πρεπει να ειναι s2.length() - s1.length()
        System.out.println(sortedList);

        //φθινουσα
        List<String> myList2 = List.of("Hello", "World", "Java", "Lambda", "Expressions");
        List<String> sortedList2 = myList.stream().sorted((s1,s2)-> s2.length() - s1.length()).toList();
        System.out.println(sortedList2);
        //και πιο κομψα ακομη
        List<String> list3 = List.of("Hello", "World", "Java", "Lambda", "Expressions");
        List<String> sorted3 = list3.stream().sorted(Comparator.comparingInt(String::length).reversed()).toList();
        System.out.println(sorted3);
    }
}
