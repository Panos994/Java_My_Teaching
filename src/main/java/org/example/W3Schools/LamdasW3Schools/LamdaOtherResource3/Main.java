package org.example.W3Schools.LamdasW3Schools.LamdaOtherResource3;

public class Main {
    public static void main(String[] args) {
      addition(5, 10);

    }
    private static void addition(int a, int b){
        AddingInterfac sum = ()->{
             int sum1 = 0;
             sum1 = a + b;
            System.out.println(sum1);
             return sum1;
        };
        sum.add();
    }
}
