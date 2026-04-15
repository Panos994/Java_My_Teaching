package org.example.W3Schools.JavaSmallProjectAndEx.Ex19;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        printResult();
    }

    private static void printResult(){
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        int userOption = 0, computerOption = 0;
        System.out.println("Please type 1 for Rock, 2 for paper, 3 for scissors and 4 for exit!");

        do{
            userOption = sc.nextInt();
            computerOption = rand.nextInt(1,3);
            if(userOption == 1 && computerOption == 2){
                System.out.println("You lose! Computer choose paper!");
            } else if(userOption == 2 && computerOption == 1){
                System.out.println("You win! Computer choose rock!");
            } else if(userOption == 3 && computerOption == 2){
                System.out.println("You win! Computer choose paper!");
            } else if(userOption == 1 && computerOption == 3){
                System.out.println("You win! Computer choose scissors!");
            } else if(userOption == 2 && computerOption == 3){
                System.out.println("You lose! Computer choose scissors!");
            } else if(userOption == 3 && computerOption == 1){
                System.out.println("You lose! Computer choose rock!");
            } else if(userOption == computerOption){
                System.out.println("It's a tie! Computer choose the same option as you!");
            } else if(userOption == 4){
                System.out.println("Exiting the game. Goodbye!");
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        } while(userOption!= 4);

    }
}
