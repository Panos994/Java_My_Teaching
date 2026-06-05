package org.example.W3Schools.StreamsW3Schools.StreamOtherResourceGPTEx31;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(List.of("Madison", "Jane", "Alison", "Berry", "James"));
        List<String> upper = names.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(upper);
    }
}
