package org.example.W3Schools.LamdasW3Schools.Lamda21;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        int sumPrime = primes.stream().filter(Main::isPrime).mapToInt(Integer::intValue).sum();
        System.out.println("Sum of prime numbers: " + sumPrime);
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
