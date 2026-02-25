package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        //2)
        String DNA = "GCAT";
        //https://www.w3schools.com/java/ref_string_replace.asp   -- μου περασε απο το μυαλο αν υπαρχει καποια replace μεθοδος ενος χαρακτηρα και googlαρα εδω
        //https://www.geeksforgeeks.org/java/java-string-is-immutable-what-exactly-is-the-meaning/
        //To εκανα ετσι και δεν αλλαζε DNA2.replace("T", "U"); Strings in Java ειναι αμετάβλητα αρα τα θετω σε νεα μεταβλητη
        String RNA = DNA.replace("T", "U");
        System.out.println(RNA);



        //3) Call exercice 3 method
        populationTarget();

        //1) Call exercice 1 method
        Scanner sc = new Scanner(System.in);
        String number = sc.nextLine();
        squareDigits(number);
    }

    //3)
    public static void populationTarget() {
        double p0 = 1000;
        double years = 0;
        while (p0 <= 1200) {
            double increasePerYear = (p0 * 0.02) + 50;
            p0 = p0 + increasePerYear;
            years++;
            System.out.println("Population's increase per year " + p0);
        }
        System.out.println();
        System.out.println("Duration needed to succeed population over or equal to 1200 people are: " + years + " years");
    }

    //1)
    public static void squareDigits(String num) {
        char[] nm = num.toCharArray();
        int temp = 0;
        int squared = 0;
        String result = "";

        for(int i = 0; i < nm.length;i++){
            if(num.charAt(i) == '-'){
                continue;
            }
            temp = Integer.parseInt(Character.toString(nm[i]));
            squared = temp * temp;
            result += String.valueOf(squared);
        }
        if(num.charAt(0) == '-'){
            result = Character.toString('-') + result;
        }
        System.out.println(Integer.valueOf(result));


        //εδω ειδα την υλοποιηση απο stack overflow γιατι κολλησα τελειως -- να το δουμε αλλα και αν υπαρχει αλλη υλοποιηση https://stackoverflow.com/questions/8033550/convert-an-integer-to-an-array-of-digits
//        ArrayList<Integer> array = new ArrayList<Integer>();
//        do {
//            array.add(num % 10);   //αυτο το θυμομουν σαν υλοποιηση οτι παιρνεις το 1ο ψηφιο και μετα το τελευταιο αλλα να το δουμε και μαζι λίγο
//            num /= 10;
//        } while (num > 0);
//        System.out.println(array);
//        // μετά έκανα εγώ αυτό
//        for (Integer digits : array) {
//            int squared = digits * digits;
//            System.out.print(squared);
//
//        }
    }


}
