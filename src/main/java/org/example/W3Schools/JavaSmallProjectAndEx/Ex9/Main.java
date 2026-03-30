package org.example.W3Schools.JavaSmallProjectAndEx.Ex9;

public class Main {
    public static void main(String[] args) {
        int num = 5;

        System.out.println(factorial(num));

        System.out.println(forLoopFactorial(num));
    }
    private static int factorial(int n){ //recursion
        if(n == 1){
            return 1;
        }
        return n * factorial(n - 1);
    }

    //or with a for loop
    private static int forLoopFactorial(int n){
        int factorial = 1;
        for(int i = 1; i <= n; i++){
            factorial*=i;
        }
        //System.out.println("Factorial of " + n + " is " + factorial);
        return factorial;
    }
}
