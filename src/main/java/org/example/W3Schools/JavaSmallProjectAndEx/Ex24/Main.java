package org.example.W3Schools.JavaSmallProjectAndEx.Ex24;

public class Main {
    public static void main(String[] args) {
        String test = "Hey Mister J";
        System.out.println(reverseAstr(test));
    }
    private static String reverseAstr(String str){
        String reversed = "";
        for(int i = str.length() - 1; i >= 0;i--){
            reversed += str.charAt(i);
        }
        return reversed;
    }
}
