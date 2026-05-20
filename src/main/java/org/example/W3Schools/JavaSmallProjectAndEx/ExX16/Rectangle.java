package org.example.W3Schools.JavaSmallProjectAndEx.ExX16;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Rectangle extends Shape{
    private double height;
    private double width;
    private double radius;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius){
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return height * width;
    }

    @Override
    public double calcPerimeter() {
        return 2 * Math.PI * radius;
    }


}
