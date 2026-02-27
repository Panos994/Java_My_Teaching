package org.example.OOPChallenges.AbstractClassesShapesExercise;

class Circle extends Shape{
    double radius;

    public Circle(double radius) {
        super("Circle");
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
