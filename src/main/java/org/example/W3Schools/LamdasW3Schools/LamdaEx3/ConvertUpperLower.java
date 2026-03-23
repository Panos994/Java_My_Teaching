package org.example.W3Schools.LamdasW3Schools.LamdaEx3;

import java.util.Arrays;
import java.util.List;

public class ConvertUpperLower {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("ADAM","Georgia","jAsoN");

        System.out.println("\n Original Strings: ");
        for(String str : list){
            System.out.println(str);
        }
        list.replaceAll(str->str.toUpperCase());
        System.out.println("\n UpperCase Strings: ");
        for(String str : list){
            System.out.println(str);
        }
    }

}
