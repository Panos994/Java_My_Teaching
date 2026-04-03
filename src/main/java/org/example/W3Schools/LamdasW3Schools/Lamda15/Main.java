package org.example.W3Schools.LamdasW3Schools.Lamda15;

import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List< Integer > nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int numSqOdd = nums.stream().filter(n -> n%2!=0).mapToInt(n -> n * n).sum();

        int numSqEven = nums.stream().filter(n -> n%2==0).mapToInt(n -> n * n).sum();

        System.out.println("Sum of squares of odd numbers: " + numSqOdd);
        System.out.println("Sum of squares of even numbers: " + numSqEven);
    }
}
