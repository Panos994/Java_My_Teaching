package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static long getUserInput(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLong();
    }

    public static String getUserInputString(){
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }
    public static void decimalToBinaryConverter(long number){
        ArrayList<Long> list = new ArrayList<>();
        long ypolipo = 0;
        do{
            ypolipo = number%2;
            list.add(ypolipo);
            number = (number/2);
       } while(number != 0);
        Collections.reverse(list);
       System.out.println("Result is: " + list);
    }
    public static void binaryToDecimal(String number){
        char[] c = number.toCharArray();
        int result = 0;
        int[] resultArray = new int[c.length];
        int values = 0;
        for(int i = 0; i < c.length; i++){
            if(c[i] == '0'){
                continue;
            }
            result += (Math.pow(2, values));
            values++;
        }
        System.out.println("Result is:" + result);
    }
    public static void decimalToHexaDecimal(Long num){
        ArrayList<String> list = new ArrayList<>();
        long ypolipo = 0;
        String hex = "";
        String ypol = "";
        do{
            ypolipo = num%16;
            ypol = String.valueOf(ypolipo);
            num = (num/16);
            if (ypol.equals("10")) {
                hex = "A";
                ypol = hex;
            } else if(ypol.equals("11")){
                hex = "B";
                ypol = hex;
            } else if(ypol.equals("12")){
                hex = "C";
                ypol = hex;
            } else if (ypol.equals("13")){
                hex = "D";
                ypol = hex;
            } else if (ypol.equals("14")){
                hex = "E";
                ypol = hex;
            } else if (ypol.equals("15")){
                hex = "F";
                ypol = hex;
            }
            list.add(ypol);
        } while(num != 0);
        Collections.reverse(list);
        System.out.println("Result" + list);
    }
    public static void print(String tempMsg){
        System.out.println(tempMsg);
    }
    public static void main(String[] args) {
        print("Hello!!! Please choose which converter you need");
        print("Type either  decimalToBinary, binaryToDecimal, decimalToHexaDecimal:");
        String choice = getUserInputString();
        do{
            if (choice.equals("decimalToBinary")){
                print("Please type your input for conversion: ");
                long inputNumber = 0;
                do{
                    inputNumber = getUserInput();
                } while(inputNumber > 2000000);
                decimalToBinaryConverter(inputNumber);
            } else if (choice.equals("binaryToDecimal")){
                print("Please type your input for conversion: ");
                String inputNumber2 = "";
                do{
                    inputNumber2 = getUserInputString();
                    if(!(inputNumber2.contains("0") || inputNumber2.contains("1")) ){
                        System.out.println("Wrong input you need to type either 0 or 1! ");
                    }
                } while(!(inputNumber2.contains("0") || inputNumber2.contains("1")));
               binaryToDecimal(inputNumber2);
            } else if (choice.equals("decimalToHexaDecimal")){
                print("Please type your input for conversion: ");
                long inputNumber3 = 0;
                do{
                    inputNumber3 = getUserInput();
                } while(inputNumber3 > 2000000);
                decimalToHexaDecimal(inputNumber3);
            }
        } while (!(choice.equals("decimalToBinary") || choice.equals("binaryToDecimal") || choice.equals("decimalToHexaDecimal")));
    }
}