package org.example.W3Schools.LamdasW3Schools.LamdaEx24;

import java.util.stream.LongStream;

public class Main {
    public static void main(String[] args) {
        int n = 176;
        System.out.println("Number: " + n);

        long largestPrimeFactor = findLargestPrimeFactor(n);
        System.out.println("Largest prime factor: " + largestPrimeFactor);
        n = 36;
        System.out.println("\nNumber: " + n);

        largestPrimeFactor = findLargestPrimeFactor(n);
        System.out.println("Largest prime factor: " + largestPrimeFactor);
    }
    private static long findLargestPrimeFactor(long n){
        for(long i = (long) Math.sqrt(n); i>=2; i--){
            if(n % i == 0 && isPrime((int)i)){
                return i;
            }
        }
        return n;
    }
    private static boolean isPrime(int n){
        return LongStream.rangeClosed(2,(long) Math.sqrt(n)).allMatch(i -> n%i != 0);
    }
}
