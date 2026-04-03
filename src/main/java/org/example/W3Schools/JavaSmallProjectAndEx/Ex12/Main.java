package org.example.W3Schools.JavaSmallProjectAndEx.Ex12;

public class Main {
    public static void main(String[] args) {
       vowelCounter("Hello World");
    }

    private static void vowelCounter(String str){
        int vowelCount = 0;
        for(int i = 0; i <= str.length()-1; i++){
            if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'o' || str.charAt(i) == i){
                vowelCount++;
            }
        }
        System.out.println("Number of vowels in the string: " + vowelCount);
    }
}
