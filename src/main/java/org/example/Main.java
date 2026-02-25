package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static boolean check(int ui, int low, int upper) {
        return ui >= low && ui <= upper;
    }
    public static int getUserInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please give me a temperature betweem these borders of numbers [-10 έως 50]:");
        return sc.nextInt();
    }
    public static String messages(int i, int temperature) {
        switch (i) {
            case 1:
                return temperature + "\t" + "Freezing weather";
            case 2:
                return temperature + "\t" + "Very Cold weather";
            case 3:
                return temperature + "\t" + "Cold weather";
            case 4:
                return temperature + "\t" + "Normal In Temp";
            case 5:
                return temperature + "\t" + "Its Hot";
            case 6:
                return temperature + "\t" + "Its very Hot";
        }
        return "";
    }
    public static void print(String tempMsg){
        System.out.println(tempMsg);
    }
    public static void main(String[] args) {
        //A)
        int[] ui = new int[4];
        int i = 0;
        System.out.println("Welcome to your temperature calculator. Please give me 4 temperatures betweem these borders of numbers [-10 έως 50]:");
        while (i < 4) {
            int userInp = getUserInput();
            if (check(userInp, -10, 50)) {
                ui[i] = userInp;
                i++;
            } else {
                System.out.println("Try again. Type the correct inputs as aforementioned! ");
            }
        }
        Arrays.sort(ui);
        System.out.println("Your temperatures were : " + Arrays.toString(ui));
        for (i = 0; i < ui.length; i++) {
            if (ui[i] < 0) {
                print(messages(1, ui[i]));
            } else if (ui[i] >= 0 && ui[i] < 10) {
                print(messages(2, ui[i]));
            } else if (ui[i] >= 10 && ui[i] < 20) {
                print(messages(3, ui[i]));
            } else if (ui[i] >= 20 && ui[i] < 30) {
                print(messages(4, ui[i]));
            } else if (ui[i] >= 30 && ui[i] < 40) {
                print(messages(5, ui[i]));
            } else if (ui[i] >= 40) {
                print(messages(6, ui[i]));
            }
        }
        System.out.println("\n");
    }
}