package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("First Exercise. Please enter your string: ");
        String ex1 = sc.nextLine();
        Encrypt.encryptThis(ex1);
        System.out.println("\n\n" + "Second Exercise: " );
        String[] ex2 = {"a", "b", "c", "d", "f"};
        System.out.println(Encrypt.consecutiveLetters(ex2));
        System.out.println("Or");
        String exx2 = "abcdf";
        Encrypt.conseLetters(exx2);
        System.out.println();
        MissingNumber missingNumber = new MissingNumber();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(9);
        list.add(11);
        System.out.println("\n" + "Third Exercise: " );
        missingNumber.findMissing(list);
    }
}