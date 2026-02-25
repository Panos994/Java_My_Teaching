package org.example;

import java.util.HashMap;
import java.util.Scanner;

public class ResistorCalculation {
    public static void displayColourAcronyms() {
        HashMap<String, String> map = new HashMap<>();
        map.put("M", "Μαύρο");
        map.put("K", "Καφέ");
        map.put("N", "Κόκκινο");
        map.put("O", "Πορτοκαλί");
        map.put("I", "Κίτρινο");
        map.put("R", "Πράσινο");
        map.put("L", "Μπλε");
        map.put("V", "Μωβ");
        map.put("G", "Γκρι");
        map.put("A", "Άσπρο");
        map.put("X", "Χρυσαφί ");
        map.put("S", "Ασημένιο");
        System.out.println("colours to choose are: " + map);
        //System.out.println(map.get("M"));
    }
    public static void displayValuesAcronyms() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Mαύρο", "0");
        map.put("Kαφέ", "1 or 0.01 for the Multiplier (last input Character)");
        map.put("Κόκκινο", "2 or 0.02 for the Multiplier (last input Character)");
        map.put("Πορτοκαλί", "3");
        map.put("Κίτρινο", "4");
        map.put("Πράσινο", "5");
        map.put("Μπλε", "6");
        map.put("Μωβ", "7");
        map.put("Γκρι", "8");
        map.put("Άσπρο", "9");
        map.put("X", "0.05 for the Multiplier (last input Character)");
        map.put("S", "0.10 for the Multiplier (last input Character)");
        System.out.println("Values to choose (for your reference) for the colours (4 or 5 values you need to choose): " + map);
    }
    public static void calculateResistor(){
        Scanner sc = new Scanner(System.in);
        String charDigits = " ";
        do {
            System.out.println("You need to enter only 4 or 5 input characters from Latin Alphabet:");
            charDigits = sc.next();
        } while (charDigits.chars().count() != 4 && charDigits.chars().count() != 5); //
        // https://www.bing.com/search?pglt=2083&q=String+determine+how+much+characters+to+type+the+user+Java&cvid=28173cbf6f444e32bbbe7e5024a78ea8&gs_lcrp=EgRlZGdlKgYIABBFGDkyBggAEEUYOTIICAEQ6QcY_FXSAQcyMzJqMGoxqAIAsAIA&FORM=ANNAB1&PC=DCTS
        char[] charDigs = charDigits.toCharArray();
        int value1 = 0;
        int value2 = 0;
        int value3 = 0;
        int value4 = 0;
        int value5 = 0;
        int value6 = 0;
        int value7 = 0;
        int value8 = 0;
        int value9 = 0;
        int value10 = 0;
        int value11 = 0;
        int value12 = 0;
        int[] digitsValue = new int[11];
        String result;
        for (int i = 0; i < charDigs.length; i++) {
            if (charDigs[i] == 'M') {
                value1 = 0;
                digitsValue[i] = value1;
            } else if (charDigs[i] == 'K') {
                value2 = 1;
                digitsValue[i] = value2;
            } else if (charDigs[i] == 'N') {
                value3 = 2;
                digitsValue[i] = value3;
            } else if (charDigs[i] == 'O') {
                value4 = 3;
                digitsValue[i] = value4;
            } else if (charDigs[i] == 'Ι') {
                value5 = 4;
                digitsValue[i] = value5;
            } else if (charDigs[i] == 'R') {
                value6 = 5;
                digitsValue[i] = value6;
            } else if (charDigs[i] == 'L') {
                value7 = 6;
                digitsValue[i] = value7;
            } else if (charDigs[i] == 'V') {
                value8 = 7;
                digitsValue[i] = value8;
            } else if (charDigs[i] == 'G') {
                value9 = 8;
                digitsValue[i] = value9;
            } else if (charDigs[i] == 'A') {
                value10 = 9;
                digitsValue[i] = value10;
            } else if (charDigs[i] == 'X') {
                value11 = 5;
                digitsValue[i] = value11;
            } else if (charDigs[i] == 'S') {
                value12 = 10;
                digitsValue[i] = value12;
            }
            //System.out.println(digitsValue[i]);
        }
        if(charDigits.chars().count() == 4){
            int digit1 = digitsValue[0];
            int digit2 = digitsValue[1];

            String digit3String = "";
            int digit3 = (int) Math.pow(10, digitsValue[2]); //https://www.insomnia.gr/forums/topic/182265-%CF%80%CF%89%CF%82-%CF%85%CF%88%CF%8E%CE%BD%CE%BF%CF%85%CE%BC%CE%B5-%CF%83%CE%B5-%CE%B4%CF%8D%CE%BD%CE%B1%CE%BC%CE%B7-java/
            if(digit3 == (int) Math.pow(10,0) || digit3 == (int) Math.pow(10, 1) || digit3 == (int) Math.pow(10,2)){
                digit3String = "Ω";
            } else if(digit3 == (int) Math.pow(10,3) || digit3 == (int) Math.pow(10,4) || digit3 == (int) Math.pow(10,5)){
                digit3String = "kΩ";
            } else if (digit3 == (int) Math.pow(10,6) || digit3 == (int) Math.pow(10,7) || digit3 == (int) Math.pow(10,8)){
                digit3String = "ΜΩ";
            } else if (digit3 == (int) Math.pow(10,9) || digit3 == (int) Math.pow(10,10) || digit3 == (int) Math.pow(10,11)){
                digit3String = "GΩ";
            }

            int digit4 = digitsValue[3];
            String result1 = Integer.toString(digit1) + "." + Integer.toString(digit2)  + digit3String +  "+/-" + Integer.toString(digit4) + "%";
            System.out.println("Your result: " + result1);
        } else if(charDigits.chars().count() == 5){
            int digit1 = digitsValue[0];
            int digit2 = digitsValue[1];
            int digit3 = digitsValue[2];

            String digit4String = "";
            int digit4 = (int) Math.pow(10, digitsValue[3]); //https://www.insomnia.gr/forums/topic/182265-%CF%80%CF%89%CF%82-%CF%85%CF%88%CF%8E%CE%BD%CE%BF%CF%85%CE%BC%CE%B5-%CF%83%CE%B5-%CE%B4%CF%8D%CE%BD%CE%B1%CE%BC%CE%B7-java/
            if(digit4 == (int) Math.pow(10,0) || digit4 == (int) Math.pow(10, 1) || digit4 == (int) Math.pow(10,2)){
                digit4String = "Ω";
            } else if(digit4 == (int) Math.pow(10,3) || digit4 == (int) Math.pow(10,4) || digit4 == (int) Math.pow(10,5)){
                digit4String = "kΩ";
            } else if (digit4 == (int) Math.pow(10,6) || digit4 == (int) Math.pow(10,7) || digit4 == (int) Math.pow(10,8)){
                digit4String = "ΜΩ";
            } else if (digit4 == (int) Math.pow(10,9) || digit4 == (int) Math.pow(10,10) || digit4 == (int) Math.pow(10,11)){
                digit4String = "GΩ";
            }

            int digit5 = digitsValue[4];
            String result2 = Integer.toString(digit1) + "." + Integer.toString(digit2) + "." + Integer.toString(digit3)  + digit4String  + "+/-" + Integer.toString(digit5) + "%";
            System.out.println("Your result: " + result2);
        }
    }
}
