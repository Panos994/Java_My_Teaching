package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

public class Encrypt {
    public static String encryptStringThis(String str) {
        //str.getChars(0, 7, array, 0);
        char[] c = str.toCharArray();
       // char[] c = new char[str.length()];

        //str.getChars(0, str.length(), c, 0);
        int c1 = 0;
        String c1s = " ";
        c1 = (int) c[0];
        c1s = Integer.toString(c1);
        char[] c1c = c1s.toCharArray();
        char[] copy = new char[c.length + c1c.length - 1];
        for (int i = 0; i < c1c.length; i++) {
            copy[i] = c1c[i];
        }
        copy[c1c.length] = c[c.length - 1];
        for (int i = 2; i < c.length - 1; i++) {
            copy[i + c1c.length - 1] = c[i];
        }
        copy[(c.length + c1c.length - 1) - 1] = c[1];

//              copy[i] = c[i];
//              copy[copy.length-1] = c[1];
//              copy[c1c.length-1] = c[c.length-1];
//              copy[c.length-1] = c[1];
//              copy[0] = c1c[0];
//              copy[1] = c1c[1];
//              copy[c.length - 1] = c[2];
//              copy[2] = c[c.length - 1];
        // }
        //System.out.println(Arrays.toString(copy));
//        String[] str2 = new String[c.length];
//        for(int i = 0; i < str.length();i++){
//            str2[i] = c[i];
//        }
        return new String(copy);
    }
    public static String encryptThis(String str){
        StringJoiner sj = new StringJoiner(" ");
        String[] strArr = str.split(" ");

        for (int i = 0; i < strArr.length;i++){
            //System.out.println(encryptStringThis(strArr[i]));
            String encrWord = encryptStringThis(strArr[i]);
            sj.add(encrWord);
            //System.out.println(sj);
        }
        // System.out.println(String.join(" ", res));
        System.out.println(sj.toString());
        return sj.toString();



        //String[] words = str.split("\\s"); //https://www.w3schools.com/java/java_howto_count_words.asp
//        StringBuilder res = new StringBuilder();
//        for(int i = 0; i < words.length; i++){
//            String encrWord = encryptCharThis(words[i]);  //https://www.bing.com/search?q=String+builder+and+append&form=ANNH01&refig=69143ce2c2ca41d884fc03d62ba0dc03&pc=DCTS
//            res.append(encrWord);
//             if(i < words.length-1){
//                 res.append(" ");  //https://www.bing.com/search?q=String+builder+and+append&form=ANNH01&refig=69143ce2c2ca41d884fc03d62ba0dc03&pc=DCTS
//             }
//        }
        //return res.toString();   //https://www.bing.com/search?q=String+builder+and+append&form=ANNH01&refig=69143ce2c2ca41d884fc03d62ba0dc03&pc=DCTS
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------------
    //Εχ2
    public static String consecutiveLetters(String[] str){ //είχα δει παρόμοια πρόσφατα απο εδώ https://www.w3resource.com/java-exercises/array/index.php
        int c = str[0].charAt(0) + 1; //ουσιαστικά εδω λαμβανει την πρωτη συμβολοσειρα του πινακα και παιρνει πχ το απο το {"a,"b","c"... το α!
        for(int i = 1; i < str.length;i++, c++){
            if(str[i].charAt(0)!=c){
                return String.valueOf((char) c);
            }
        }
        // Return an empty string if no letter is missing.
        return "";
    }
    //or
    public static void conseLetters(String str){
        char[] c = str.toCharArray();
        char missinhCh = ' ';
        Arrays.sort(c);
        boolean isMissing = false;
        for(int i = 0; i < c.length-1;i++){
            char c233 = str.charAt(i);
            char next = str.charAt(i+1);
             missinhCh = (char)(c233+1);
            if(c233!=next){
                isMissing = true;
            }
        }
        System.out.print(String.valueOf(missinhCh));
    }
}
