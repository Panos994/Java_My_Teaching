package org.example.W3Schools.LamdasW3Schools.Lamda19;

import com.sun.jdi.ArrayReference;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5};

        Integer secondMax = Arrays.stream(arr).distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(null);
        System.out.println("Second max value: " + secondMax);

        Integer secondMin = Arrays.stream(arr).distinct().sorted().skip(1).findFirst().orElse(null);
        System.out.println("Second min value: " + secondMin);
//


    }
}
