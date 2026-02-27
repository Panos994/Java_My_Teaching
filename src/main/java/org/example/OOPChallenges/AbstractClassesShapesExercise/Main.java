package org.example.OOPChallenges.AbstractClassesShapesExercise;

public class Main {
    public static void main(String[] args) {
        Shape myCircle = new Circle(5.0);
        Shape myRectangle = new Rectangle(4.0, 6.0);

        myCircle.display();
        myRectangle.display();
    }
}

