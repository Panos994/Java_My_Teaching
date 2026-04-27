package org.example.W3Schools.LamdasW3Schools.LamdaOtherResourceGPTEx3;

import com.google.gson.internal.bind.util.ISO8601Utils;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> mySt = List.of("Ann","Bob","Potato","Woody","annihilator");
        List<String> filtered = mySt.stream().filter(s -> s.toUpperCase().startsWith("A")).toList();
        System.out.println(filtered);
    }


}
