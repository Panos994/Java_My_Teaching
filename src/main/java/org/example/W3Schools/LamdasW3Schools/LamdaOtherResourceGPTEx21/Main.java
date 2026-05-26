package org.example.W3Schools.LamdasW3Schools.LamdaOtherResourceGPTEx21;


import java.util.Comparator;
import java.util.function.BiFunction;


public class Main {
    public static void main(String[] args) {


        BiFunction<Integer, Integer, Integer> checkMaxBiF = (n1,n2) -> n1 > n2 ? n1 : n2;
        System.out.println(checkMaxBiF.apply(10, 20));


    }
}
