package org.example.W3Schools.JavaSmallProjectAndEx.Ex25;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> myN = Arrays.asList(10, 20, 5, 30, 15);
        findLargestN(myN);
    }
    private static void findLargestN(List<Integer> numbers){
        int max = 0;
        for(Integer n : numbers){
            if(n>max){
                max = n;
            }
        }
        System.out.println("The largest number is: " + max);
    }
}
