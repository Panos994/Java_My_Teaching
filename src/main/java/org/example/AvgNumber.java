package org.example;

import java.util.Scanner;

public class AvgNumber {

    public  double averageNumber(){
        double n1 = 0.0;
        double n2 = 0.0;
        double n3 = 0.0;
        double avg = 0.0;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your numbers: ");
        n1 = sc.nextDouble();
        n2 = sc.nextDouble();
        n3 = sc.nextDouble();

        avg = (n1 + n2 + n3) / 3;


        return avg;
    }

}

