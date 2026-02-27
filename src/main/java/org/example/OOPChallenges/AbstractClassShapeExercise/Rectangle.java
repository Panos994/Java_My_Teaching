package org.example.OOPChallenges.AbstractClassShapeExercise;

class Rectangle extends Shape {
    double width, height;

    Rectangle(double width, double height) {
        super("Rectangle");
        this.width = width;
        this.height = height;
    }

    @Override
    double calculateArea() {
        return width * height;
    }
}
