package org.example.OOPChallenges.AbstractClassesShapesExercise;

abstract class Shape {

    private String shapeName;

    Shape(String name){
        this.shapeName = name;
    }
    // Abstract μέθοδος: Δεν έχει σώμα εδώ, υλοποιείται στα υποσχήματα
    abstract double calculateArea();

    void display(){
        System.out.println("Shape: " + shapeName + " | Area " + String.format("%.2f",calculateArea()));
    }

}
