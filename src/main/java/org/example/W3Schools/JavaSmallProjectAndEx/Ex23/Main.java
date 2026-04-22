package org.example.W3Schools.JavaSmallProjectAndEx.Ex23;

public class Main {
    public static void main(String[] args) {
        System.out.println(sumOfDigs(1234));

    }
    private static int sumOfDigs(int n){
        if(n == 0) return 1;
        int sum = 0;
        while(n !=0){
            int digit = n %10;
            sum+=digit;
            n/=10;

        }
        return sum;
    }
}
