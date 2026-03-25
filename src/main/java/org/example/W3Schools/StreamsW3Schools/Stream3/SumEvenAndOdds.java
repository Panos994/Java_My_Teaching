package org.example.W3Schools.StreamsW3Schools.Stream3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SumEvenAndOdds {
    public static void main(String[] args) {
        List<Integer> sumEvenOddList = Arrays.asList(1,3,4,2,5,6,7,44,11);
        List<Integer> even = sumEvenOddList.stream().filter(n -> n%2==0).collect(Collectors.toList());
        int sumEven = 0;
        for(Integer evenN : even){
            sumEven += evenN;
        }
        List<Integer> odd = sumEvenOddList.stream().filter(n -> n%2!=0).collect(Collectors.toList());
        int sumOdd = 0;
        for(Integer oddN : odd){
            sumOdd += oddN;
        }

        System.out.println("\nThe sum of even number is: " + sumEven);
        System.out.println("\nThe sum of odd number is: " + sumOdd);

        //More delegant without for loops:
        /*
        List<Integer> numbers = Arrays.asList(1, 3, 4, 2, 5, 6, 7, 44, 11);

        int sumEven = numbers.stream()
                             .filter(n -> n % 2 == 0)
                             .mapToInt(Integer::intValue)
                             .sum();

        int sumOdd = numbers.stream()
                            .filter(n -> n % 2 != 0)
                            .mapToInt(Integer::intValue)
                            .sum();

        System.out.println("The sum of even numbers is: " + sumEven);
        System.out.println("The sum of odd numbers is: " + sumOdd);
         */

    }
}
