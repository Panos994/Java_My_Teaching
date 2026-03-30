package org.example.W3Schools.LamdasW3Schools.Lamda11;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,2,3,4,55,6);
        System.out.println("original values of the list: " + nums);

        Optional<Integer> max = nums.stream().max((x,y) -> x.compareTo(y));
        System.out.println("max value in the list: " + max.get());

        Optional<Integer> min = nums.stream().min((x,y) -> x.compareTo(y));
        System.out.println("min value in the list: " + min.get());
    }

}
