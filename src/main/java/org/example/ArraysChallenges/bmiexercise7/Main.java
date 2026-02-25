package org.example.ArraysChallenges.bmiexercise7;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Πόσα άτομα θέλετε να εισάγετε; ");
        int numPersons = sc.nextInt();
        double[][] data = new double[numPersons][3];
        String[] names = new String[numPersons];

        for(int i = 0; i < numPersons;i++){
            System.out.println("\nΕισαγωγη στοιχειων: " + (i+1) + " : ");
            names[i] = sc.next();

            System.out.println("Υψος");
            double h = sc.nextDouble();
            System.out.println("Βαρος");
            double w = sc.nextDouble();

            Person p = new Person(names[i],h,w);

            data[i][0] = p.getHeight();
            data[i][1] = p.getWeight();
            data[i][2] = p.bmicalculation();


        }
        for(int i = 0; i < numPersons; i++){
            System.out.printf("Ονομα %s | Υψος %.2f | Βαρος %.2f | BMI: %.2f%n",names[i], data[i][0],data[i][1],data[i][2]);
        }


    }
}
