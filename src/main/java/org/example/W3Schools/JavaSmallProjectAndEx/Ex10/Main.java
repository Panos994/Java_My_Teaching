package org.example.W3Schools.JavaSmallProjectAndEx.Ex10;

public class Main {
    public static void main(String[] args) {
        fibonacci(10);
    }
    private static void fibonacci(int n){
        int num = 0;
        int num2 = 1;
        if (n > 1) {
            System.out.print(", " + num2);
        }
        for(int i = 3; i <=n; i++){
            int nextNum = num + num2;
            System.out.println("," + nextNum);
            num = num2;
            num2 = nextNum;


            System.out.println("Fib sequence " + num);
        }

    }
}
