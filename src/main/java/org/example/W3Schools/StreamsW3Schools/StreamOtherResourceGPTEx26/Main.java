package org.example.W3Schools.StreamsW3Schools.StreamOtherResourceGPTEx26;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,34,5,6};
        int max = Arrays.stream(arr).max().orElseThrow();
        System.out.println("Max value in the array: " + max);
    }
}
