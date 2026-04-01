package org.example.W3Schools.LamdasW3Schools.LamdaOtherResource2;

public class Main {
    public static void main(String[] args) {
        Multiply m5 = helperFunction();

        System.out.println(m5.multiplyBy5(10));
    }
    public static Multiply helperFunction(){
        return (n)->n*5;
    }
}
