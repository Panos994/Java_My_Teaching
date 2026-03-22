package org.example.OOPChallenges.AbstractExercisesW3Schools.AbstractExercise2;

public class Triangle extends Shape{
    private double a = 0.0;
    private double b = 0.0;
    private double c = 0.0;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    double calculateArea() {

        double s = (a + b + c) / 2;

        return Math.sqrt(s * (s-a) * (s-b) * (s-c));
    }

    @Override
    double calculatePerimeter() {

        return a + b + c;
    }
}
