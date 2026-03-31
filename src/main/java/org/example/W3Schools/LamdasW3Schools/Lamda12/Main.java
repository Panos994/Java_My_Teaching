package org.example.W3Schools.LamdasW3Schools.Lamda12;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> myCalculationList = Arrays.asList(1, 2, 3, 4, 5);
        int res = myCalculationList.stream().reduce(1,(x,y) -> x*y).intValue();
        System.out.println(res);
        int sum = myCalculationList.stream().reduce(0,(x,y) -> x+y).intValue();
        System.out.println(sum);


    }
}
