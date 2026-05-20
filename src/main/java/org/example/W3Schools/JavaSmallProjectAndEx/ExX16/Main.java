package org.example.W3Schools.JavaSmallProjectAndEx.ExX16;

public class Main {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle();
        rect.setWidth(5);
        rect.setHeight(10);
        rect.setRadius(0);

        System.out.println(rect.calcPerimeter());
        System.out.println(rect.calculateArea());

        Shape[] shapes = {
                new Rectangle(4,5,3),
                new Circle(3),
                new Triangle(2,3,0)
        };

        for(Shape s : shapes){
            System.out.println(s.calcPerimeter());
            System.out.println(s.calculateArea());
        }
    }
}
