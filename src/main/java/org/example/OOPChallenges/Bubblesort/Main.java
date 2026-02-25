package org.example.OOPChallenges.Bubblesort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {4,5,1,33,4,0,9};
        bubbleSort(arr);
    }

    public static void bubbleSort(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < n - i - 1; j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
