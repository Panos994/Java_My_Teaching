package org.example.OOPChallenges.runtimepolymorphism;

public class Main {
    public static void main(String[] args) {
        Animal animal;

        animal = new Cat();  //Στο runtime, το αντικείμενο που αναφέρεται καθορίζει ποια μέθοδο - Αυτό λέγεται dynamic method dispatch και είναι το βασικό χαρακτηριστικό του runtime polymorphism.
        animal.sound(); // Output: meow!

        animal = new Animal();
        animal.sound();  // Εκτυπώνει: Animal makes a sound
    }
}
