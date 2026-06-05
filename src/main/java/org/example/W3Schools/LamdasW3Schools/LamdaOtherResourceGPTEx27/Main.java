package org.example.W3Schools.LamdasW3Schools.LamdaOtherResourceGPTEx27;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<String, String> stringTransformer = s-> s.toUpperCase().substring(0,3);
        List<String> strs = new ArrayList<>(List.of("Madison", "Jane", "Alison", "Berry", "James"));
        for(String s : strs) {
            System.out.println(stringTransformer.apply(s));
        }
    }
}
