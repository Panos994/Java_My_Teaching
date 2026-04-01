package org.example.W3Schools.JavaSmallProjectAndEx.Ex11;

public class Main {
    public static void main(String[] args) {
        System.out.println(isArmstrong(153));
    }
    private static boolean isArmstrong(int n){
        String nval = String.valueOf(n);
        int numOfDigits = nval.length();
        int sum = 0;
        int originalNum = n;
        while(n!=0){
            int digit = n % 10;
            n/=10;
            sum += Math.pow(digit, numOfDigits);

        }
        if(sum == originalNum){
            return true;
        }
        return false;
    }
}
