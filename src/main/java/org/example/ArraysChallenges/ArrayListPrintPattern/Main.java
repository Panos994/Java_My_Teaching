package org.example.ArraysChallenges.ArrayListPrintPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        printPattern(6);
    }

    public static void printPattern(int n) { //https://www.geeksforgeeks.org/java/java-program-to-print-pascals-triangle/  -- here I got a lof help in this article (I was a bit confused)
        List<List<Integer>> triangle = new ArrayList<>(); //I want to add the row list inside another list
        //ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for(int k = 0; k <= n-i; k++){
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                if( j == 0 || j == i){
                    row.add(1);
                } else {
                    int num = triangle.get(i - 1).get(j-1) + triangle.get(i - 1).get(j);
                    row.add(num);
                }
                System.out.print(row.get(j) + " ");
            }
            triangle.add(row);
            System.out.println();
        }
    }
}

