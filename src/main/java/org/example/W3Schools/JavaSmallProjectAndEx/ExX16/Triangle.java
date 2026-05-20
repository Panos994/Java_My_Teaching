package org.example.W3Schools.JavaSmallProjectAndEx.ExX16;


public class Triangle extends Shape {
    private double a, b, c;

    public Triangle(double a, double b, double c) {
        // (προαιρετικά) έλεγχος εγκυρότητας τριγώνου:
        // if (a + b <= c || a + c <= b || b + c <= a) throw new IllegalArgumentException("Invalid triangle");
        this.a = a; this.b = b; this.c = c;
    }

    @Override
    public double calculateArea() {
        double s = calcPerimeter() / 2.0;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double calcPerimeter() {
        return a + b + c;
    }
}
