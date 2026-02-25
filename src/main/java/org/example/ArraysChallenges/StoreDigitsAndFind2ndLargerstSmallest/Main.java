package org.example.ArraysChallenges.StoreDigitsAndFind2ndLargerstSmallest;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int num = 567;
        storeDigits(num);

    }

    public static void storeDigits(int num){

        num = Math.abs(num); // χειρισμος αρνητικων
        String tempStr = Integer.toString(num);
        int digitCount = tempStr.length();
        int[] arr = new int[digitCount];
        int tempNum = num;

        // 2. Αποθήκευση ψηφίων στον πίνακα (από το τέλος προς την αρχή)
        for(int i = digitCount - 1; i >=0; i--){

            arr[i] = tempNum%10;
            tempNum/=10;


        }
        System.out.println("Digits array: " + Arrays.toString(arr));

        Arrays.sort(arr);

        System.out.println("Largest element: " + arr[arr.length-1] + " Largest second element: " + arr[arr.length - 2]);
    }
}
