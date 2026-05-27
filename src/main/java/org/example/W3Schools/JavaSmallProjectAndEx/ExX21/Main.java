package org.example.W3Schools.JavaSmallProjectAndEx.ExX21;

import org.checkerframework.checker.units.qual.C;

public class Main {
    public static void main(String[] args) {
        Car c = new Car("Wolkswagen","Touareg",2015,500);
        Truck tr = new Truck("Shelii","Hisr",2019,1000);

        System.out.println(c.toString());
        System.out.println(tr.toString());
    }
}
