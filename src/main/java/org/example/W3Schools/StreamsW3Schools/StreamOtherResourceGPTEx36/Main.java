package org.example.W3Schools.StreamsW3Schools.StreamOtherResourceGPTEx36;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> words  = new ArrayList<>(List.of("Anne","Gunslight","Seeking it","Anne","Surdup","Seeking it","ANNE"));

        List<String> uniqueW = words.stream().map(String::toLowerCase).distinct().toList();
        System.out.println(uniqueW);
    }
}
