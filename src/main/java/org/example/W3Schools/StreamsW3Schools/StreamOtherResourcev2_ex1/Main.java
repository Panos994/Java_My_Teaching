package org.example.W3Schools.StreamsW3Schools.StreamOtherResourcev2_ex1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int sum = 0;
        double avg = 0;

        if(arr.length >=1 && arr.length<= 1000){
            sum = Arrays.stream(arr).sum();
            System.out.println(sum);
        }

        for(int i = 0; i < arr.length; i++){
            if(arr[i] >= 1 && arr[i] <= 1000){
                sum = Arrays.stream(arr).sum();
                System.out.println(sum);
            }
        }

        avg =  Arrays.stream(arr).average().orElse(0);
        System.out.println(avg);

        int filtered = Arrays.stream(arr).filter(n -> n%2!=0).max().orElse(0);
        System.out.println(filtered);
    }
}
