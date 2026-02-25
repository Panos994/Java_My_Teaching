package org.example;

import java.util.*;

public class Exercise7 {
    public static void main(String[] args) {

        int[][] arr2D = {{3, 0}, {9, 1}, {4, 10}, {12, 2}, {6, 1}, {7, 10}};
        int passengersEnter = 0;
        int passengersLeft = 0;
        for (int i = 0; i < arr2D.length; i++) {
            passengersEnter += arr2D[i][0];
            passengersLeft += arr2D[i][1];
        }
        System.out.println("Passengers entered: " + passengersEnter + "\n");
        System.out.println("Passengers left: " + passengersLeft + "\n");
        System.out.println("Remaining Passengers are: " + (passengersEnter - passengersLeft));


        //8)
        System.out.println();
        System.out.println("Exercice 8: ");
        String s1 = "xyaabbbccccdefww";
        String s2 = "xxxxyyyyabklmopq";
        sortString(s1, s2);
    }

    public static void sortString(String s1, String s2) {
        String s3 = "";
        for(int i = 0; i < s1.length(); i++){
            if(!s3.contains(Character.toString(s1.charAt(i)))){
                s3 += Character.toString(s1.charAt(i));
            }
        }
        for(int i = 0; i < s2.length(); i++){
            if(!s3.contains(Character.toString(s2.charAt(i)))){
                s3 += Character.toString(s2.charAt(i));
            }
        }
        char[] c3 = s3.toCharArray();
        Arrays.sort(c3);
        System.out.println(c3);
    }
}
