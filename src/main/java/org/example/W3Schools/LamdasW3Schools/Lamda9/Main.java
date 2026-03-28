package org.example.W3Schools.LamdasW3Schools.Lamda9;

import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Predicate<Integer> numPrime = n -> {
            for(int i = 2; i < Math.sqrt(n); i++){
                if(n <= 1 && n % i == 0){
                    return true;
                }
            }

            return true;
        };
        int n = 17;
        boolean isPrime = numPrime.test(n);
        System.out.println(n + " is prime: " + isPrime);
    }


}
