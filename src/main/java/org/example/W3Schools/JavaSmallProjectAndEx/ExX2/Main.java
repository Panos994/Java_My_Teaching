package org.example.W3Schools.JavaSmallProjectAndEx.ExX2;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Charlie","Breed1");
        Dog dog2 = new Dog("Cha","Breed2");

        dog.setName("Charlievdf");
        dog2.setBreed("Breed2vdf");

        System.out.println("Dog 1: " + dog.getName() + ", " + dog.getBreed());

    }
}
