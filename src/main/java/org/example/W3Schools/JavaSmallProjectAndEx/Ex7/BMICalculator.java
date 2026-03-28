package org.example.W3Schools.JavaSmallProjectAndEx.Ex7;

import java.util.Locale;
import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        double weight = 0.0;
        double height = 0.0;
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);;
        System.out.println("Welcome to the BMI Calculator!");
        double bmiCalc = 0.0;

        do{
            System.out.println("Please enter your weight (positive number): ");
            while (!sc.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a valid number for weight:");
                sc.next(); // discard invalid input
            }
            weight = sc.nextDouble();

            System.out.println("Please enter your height (positive number): ");
            while (!sc.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a valid number for height:");
                sc.next(); // discard invalid input
            }
            height = sc.nextDouble();

            if (weight <= 0 || height <= 0) {
                System.out.println("Weight and height must be positive numbers. Please try again.");
            }
        } while(weight <= 0 || height <= 0);

        bmiCalc = weight / Math.pow(height, 2);
        System.out.println("Your BMI is: " + String.format("%.02f",bmiCalc));

    }
}
