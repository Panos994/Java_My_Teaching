package org.example;


import java.util.Scanner;

public class MaxNum {

    public static int getMaxNumber(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Read positive N: ");

         int N = 0;
         int sum = 0;
         int max = 0;
         int num = 0;

        do{
            N = sc.nextInt();
            if(N <= 0){
                System.out.println("Type numbers that are only positives.");
            }
        }while (N<=0);

        if(N > 0 && sum >= 0){
            while(sum < N) {
                System.out.println("Type positive numbers now to add them: ");
                num = sc.nextInt();
                if (num > 0) {
                    sum = sum + num;
                    if (num > max) {
                        max = num;
                    }
                }
            }
        }

        return max;

    }




}
