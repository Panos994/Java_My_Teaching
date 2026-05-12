package org.example.W3Schools.LamdasW3Schools.LamdaOtherResourceGPTEx10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(List.of("Nikos", "Anna", "Panos", "Io", "Katerina"));




        names.sort((a,b) -> Integer.compare(a.length(), b.length()));
        System.out.println(names);
    }
}
