package org.example.W3Schools.StreamsW3Schools.StreamOtherResouceGPTExX2;

public class Person {
    String name;
    int age;
    double salary;

    Person(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return name + " (" + age + "), salary=" + salary;
    }
}
