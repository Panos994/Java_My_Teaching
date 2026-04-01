package org.example.W3Schools.LamdasW3Schools.LamdaOtherResource;

public class Main {
    public static void main(String[] args) {
        Hello hey = helperFunction();
        hey.sayHello();

    }
    public static Hello helperFunction(){
        return () -> System.out.println("Hello!");
    }
}
