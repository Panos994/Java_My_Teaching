package org.example.W3Schools.JavaSmallProjectAndEx.ExX4;

import org.checkerframework.checker.units.qual.C;

public class Main {
    public static void main(String[] args) {
        Circle c = new Circle(15.5);
        System.out.println("Area " + String.format("%.02f",c.getArea()) + " Circumference " + c.getCircumference());

    }
}
