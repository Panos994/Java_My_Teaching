package org.example.OOPChallenges.MultiLevelInheritance;

public class Human extends Mammal {
    public Human(int age, String name, double height, double weight, boolean male) {
        super(age, name, height, weight, male);
    }

    @Override
    public String toString() {
        return "Human{} " + super.toString();
    }
}
