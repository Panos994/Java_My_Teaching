package org.example.W3Schools.StreamsW3Schools.StreamEx1;

import java.util.Arrays;
import java.util.List;

public class AverageStream {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,2,3,4,5);
        double avg = nums.stream().mapToDouble(Integer::doubleValue).average().orElse(0.0);

        System.out.println("Average value of the said numbers: " + avg);

    }
}
