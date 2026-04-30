package org.example.W3Schools.JavaSmallProjectAndEx.ExX3;

public class Main {
    public static void main(String[] args) {
        Rectangle r = new Rectangle(5, 10);
        double area = rectangleCalcArea(r);
        System.out.println("Area of the rectangle: " + area);

        double perim = rectangleCalcPerimeter(r);
        System.out.println("Perimeter of the rectangle: " + perim);
    }
    private static double rectangleCalcArea(Rectangle temp){
        return temp.getHeight() * temp.getWidth();
    }

    private static double rectangleCalcPerimeter(Rectangle temp){
        return 2 * (temp.getHeight() + temp.getWidth());
    }

}
