package org.example.W3Schools.JavaSmallProjectAndEx.ExX8;

public class Main {
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight("RED", 30);

        System.out.println("Initial color: " + trafficLight.getColor());
        System.out.println("Is red? " + trafficLight.isRed());
        System.out.println("Is green? " + trafficLight.isGreen());

        if (trafficLight.changeColor("GREEN")) {
            System.out.println("Color changed successfully.");
        } else {
            System.out.println("Invalid color.");
        }

        System.out.println("Current color: " + trafficLight.getColor());
        System.out.println("Is red? " + trafficLight.isRed());
        System.out.println("Is green? " + trafficLight.isGreen());
    }
}
