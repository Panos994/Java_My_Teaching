package org.example;

import java.util.Scanner;
import java.util.regex.Pattern;


public class Exercise {
    public static void main(String[] args){
        System.out.println("Minimum: " + findSmallestNumber());
        AvgNumber avgNumber = new AvgNumber();
        System.out.println("Minimum: " + avgNumber.averageNumber());

        System.out.println("Middle Character(s): " + findMiddleCharacter("sudgfg"));
        System.out.println("Number of  Vowels in the string: " + countVowels("sodgadefg"));
        System.out.println("Number of  Consonants in the string: " + countConsonants("sodgadefg"));
        System.out.println("Number of  words in the string: " + countWords("The quick brown fox jumps over the lazy dog"));
        System.out.println("sum of digits: " + sumOfDigits(256));


        System.out.println("Enter your password:");
        Scanner sc = new Scanner(System.in);
        String pass = sc.nextLine();
        System.out.println(validPassword(pass));


    }

    public static double findSmallestNumber(){
        double n1 = 0.0;
        double n2 = 0.0;
        double n3 = 0.0;
        double min = Double.MIN_VALUE;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your numbers: ");
        n1 = sc.nextDouble();
        n2 = sc.nextDouble();
        n3 = sc.nextDouble();

        if(n1 < n2 && n1 < n3){
            min = n1;
        } else if(n2 < n1 && n2 < n3){
            min = n2;
        } else{
            min = n3;
        }
        return min;
    }

    public static double averageNumber(){
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


    public static String findMiddleCharacter(String str){
        int position;
        int length;
        if(str.length()%2==0){
             position = str.length()/2;
            length = 2;
        } else{
            position = str.length()/2-1;
            length = 1;
        }
        return str.substring(position, position + length); //θα θέσει ενα range στο τι να επιστρεψω απο το string (πχ εδω θα θεσω απο το position μέχρι το position + length αν το length στην πρωτη περιπτωση ειναι 2 (θα φέρει πχ dd) ειδαλλως για την 2η συνθήκη θα φέρει d
    }


    public static int countVowels(String str){
       // char[] arrV = str.toCharArray();
        int countV = 0;
        for(int i = 0; i< str.length();i++){
            if(str.charAt(i)=='a' || str.charAt(i)=='e' || str.charAt(i)=='o' || str.charAt(i)=='u' || str.charAt(i)=='i'){
                countV++;
            }
        }
        return countV;
    }

    public static int countConsonants(String str){
        // char[] arrV = str.toCharArray();
        int countC = 0;
        String lowerStr = str.toLowerCase();
        for(int i = 0; i< str.length();i++){
            char currentChar = lowerStr.charAt(i);
            if(currentChar >= 'a' && currentChar <= 'z'){
                if(!(str.charAt(i)=='a' || str.charAt(i)=='e' || str.charAt(i)=='o' || str.charAt(i)=='u' || str.charAt(i)=='i')){
                    countC++;
                }

            }
        }
        return countC;
    }

    public static int countWords(String str){
        //char[] arr = str.toCharArray();
        int countOfWords = str.split("\\s").length;

        return countOfWords;
    }

    public static long sumOfDigits(long n){
        long res = 0;
        while(n>0){
            res = res + n%10; //5, 5 + 2 = 7,
            n = n/10; //2, 2/10 = 0
        }
        return res;
    }



    public static String validPassword(String str){
        String message = null;
        String password = "^(?=.*[0-9].*[0-9])(?=[a-zA-Z0-9]{10,}$)[a-zA-Z0-9]+$";

        if(str.matches(password)){
             message = "Password is valid: " + str;
        } else {
            message = "1. A password must have at least eight characters.\n" +
                    "2. A password consists of only letters and digits.\n" +
                    "3. A password must contain at least two digits";
        }
        return message;
    }
}
