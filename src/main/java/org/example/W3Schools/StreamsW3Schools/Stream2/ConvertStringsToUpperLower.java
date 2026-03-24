package org.example.W3Schools.StreamsW3Schools.Stream2;

import java.util.Arrays;

public class ConvertStringsToUpperLower {
    public static void main(String[] args) {
        String[] test = {"jaSon","vsssSdssS","KloKl"};

        Arrays.stream(test).map(String::toUpperCase).forEach(s -> System.out.println(s));
        Arrays.stream(test).map(String::toLowerCase).forEach(s -> System.out.println(s));
    }





}
