package org.example.W3Schools.JavaSmallProjectAndEx.Ex4;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessing {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        int rangeNums = rand.nextInt(1,101);

        System.out.println("Welcome to the number guessing game!");
        System.out.println("Please type your number from range 1-100 and it will answer if you guessed correctly!");
        int userNum = sc.nextInt();
        do{
            if(userNum > rangeNums){
                System.out.println("Your guess is too high! As the correct number was: " + rangeNums);
            } else if(userNum < rangeNums){
                System.out.println("Your guess is too low! As the correct number was: " + rangeNums);
            } else if(userNum == rangeNums){
                System.out.println("Congratulations! You guessed the number!");
            }
            rangeNums = rand.nextInt(1,101);
            System.out.println("Please type your number from range 1-100 and it will answer if you guessed correctly!");
            userNum = sc.nextInt();
        } while(userNum != rangeNums);
    }
}
