package org.example.ArraysChallenges.bmiexercise6;

public class Person {

    private String name;
    private double height;
    private double weight;
    private String status;

    public Person(String name, double height, double weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double bmicalculation() {
        return this.weight / Math.pow(height,2);
    }

    public String bmistatus() {
        double bmi = bmicalculation();
        if (bmi < 18.5) {
            return "UnderWeight";
        } else if (bmi < 25) {
            return "Healthy weight";
        } else if(bmi < 30){
            return "Overweight";

        }else{
            return "Obese (need doctor)";
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", status=" + bmistatus() +
                ", bmi='" + bmicalculation() + '\'' +
                '}';
    }
}
