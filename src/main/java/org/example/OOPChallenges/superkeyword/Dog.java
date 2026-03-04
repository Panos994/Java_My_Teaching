package org.example.OOPChallenges.superkeyword;

public class Dog extends Animal{

    private String breed;

    public Dog(String name, String breed) {
        super(name); // Call the constructor of the superclass (Animal)
        this.breed = breed;
    }

    @Override
    public void sound() {
        super.sound(); // Call the sound method of the superclass (Animal)
        System.out.println("Dog barks");
    }
}
