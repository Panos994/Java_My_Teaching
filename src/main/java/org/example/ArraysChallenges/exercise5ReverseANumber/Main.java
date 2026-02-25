package org.example.ArraysChallenges.exercise5ReverseANumber;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a number: ");
        int num = sc.nextInt();
        String num1 = Integer.toString(num);
        System.out.println("---- Process for reversing the number ----");
        int[] storeDigs = new int[num1.length()];
        int i = 0;
        while(num!=0){
             int digit = num%10; //σε προσωρινη μεταβλητη το βαζω για να κανει την ιδια δουλεια και για το επομενο ψηφιο
             storeDigs[i] = digit;
            num = num/10;
             i++;
        }


        System.out.println(Arrays.toString(storeDigs));


    }
}
