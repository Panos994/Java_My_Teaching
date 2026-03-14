package org.example.OOPChallenges.UserDefinedPackages;

public class MyMath {

    public int add(int a, int b){
        return a + b;
    }

    public long factorial(int n){
        if (n < 0) throw new IllegalArgumentException("Number must be non-negative");
        // Base case: το 0! και το 1! ισούται με 1
        if (n <= 1) return 1;
        return factorial(n-1) * n;
    }
}
