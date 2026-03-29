package org.example.W3Schools.JavaSmallProjectAndEx.Ex8;

public class Main {
    public static void main(String[] args) {
        int n = 17;
        System.out.println(isPrime(n));
    }
    private static boolean isPrime(int n){
        if(n < 2){
            return false;
        }
        for(int i = 2; i<= Math.sqrt(n); i++){
            if(n%i==0) {
                return false;
            }
        }
        return true;
    }
}
