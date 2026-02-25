package org.example;

public class Star {
    private String name;
    private double age;

    private double volume;
    private double density;

    public Star(String name, double age, double density, double volume) {
        this.name = name;
        this.age = age;
        this.density = density;
        this.volume = volume;
    }

    public Star() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    @Override
    public String toString() {
        return "Star{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", volume=" + volume +
                ", density=" + density +
                '}';
    }
}
