package org.example.OOPChallenges.AbstractExercisesW3Schools.AbstractExercise2;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        System.out.println("Area of this circle is: " + String.format("%.02f",circle.calculateArea()));
        System.out.println("Perimeter of this circle is: " + String.format("%.02f",circle.calculatePerimeter()));

        Shape triangle = new Triangle(4,5,6);
        System.out.println("Area of this triangle is: " + String.format("%.02f",triangle.calculateArea()));
        System.out.println("Perimeter of this triangle is: " + String.format("%.02f",triangle.calculatePerimeter()));
    }
}
