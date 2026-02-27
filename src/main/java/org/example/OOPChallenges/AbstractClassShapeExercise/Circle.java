package org.example.OOPChallenges.AbstractClassShapeExercise;

class Circle extends Shape {
    double radius;

    Circle(double radius) {
        super("Circle");
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
