package org.example.W3Schools.StreamsW3Schools.StreamOtherResourceGPTEx32;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,3,455,6,6};

        OptionalInt maxOpt = Arrays.stream(arr).max();
        if (maxOpt.isPresent()) {
            int max = maxOpt.getAsInt();
            System.out.println("Max element: " + max);
        } else {
            System.out.println("Array is empty");
        }
    }
}
