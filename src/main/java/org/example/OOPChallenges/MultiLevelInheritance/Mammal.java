package org.example.OOPChallenges.MultiLevelInheritance;

public class Mammal {

    private int age;
    private String name;
    private double height;
    private double weight;
    private boolean male;

    public Mammal(int age, String name, double height, double weight, boolean male) {
        this.age = age;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.male = male;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    @Override
    public String toString() {
        return "Mammal{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", male=" + male +
                '}';
    }
}
