package org.example.OOPChallenges.interfaceprogram;
//interface inheritance (ή καλύτερα, υλοποίηση interface).
public class Dog implements Animal{
    @Override
    public void sound() {
        System.out.println("barking!");
    }
}
