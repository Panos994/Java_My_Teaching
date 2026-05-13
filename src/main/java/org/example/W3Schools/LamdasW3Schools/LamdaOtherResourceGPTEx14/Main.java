package org.example.W3Schools.LamdasW3Schools.LamdaOtherResourceGPTEx14;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Panos", "Io", "Konstantinos", "A");
        names.sort(Comparator.comparing(String::length));
        System.out.println(names);
    }
}
