package org.example;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //4)
        int hours = 0;

        final double lt = 0.5;

        double prod = 0;

        System.out.println("Give me your lt of water you drink for your hours");
        Scanner sc = new Scanner(System.in);
        System.out.println("Hours: ");
        hours = sc.nextInt();
        System.out.println();
//        System.out.println("lt: ");
//        lt = sc.nextDouble();

        prod = hours * lt;

        System.out.println("Your lt are: " + Math.floor(prod)); //στρογγυλοποιηση προς τα κατω
                                                                //   αν ηταν 2.4 η round (2), ενω 2.5 και πανω (3)
                                                                // ceiling πάντα προς τα πάνω
    }
}