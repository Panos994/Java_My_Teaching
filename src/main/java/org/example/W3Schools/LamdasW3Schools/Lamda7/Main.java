package org.example.W3Schools.LamdasW3Schools.Lamda7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,2,4,5,4,7,5,9,10);

        List<Integer> removedDuplicates = list.stream().distinct().toList();

        for(Integer n : removedDuplicates){
            System.out.println(n);
        }
    }
}
