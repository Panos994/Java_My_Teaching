package org.example.OOPChallenges.MultiLevelInheritance;

public class Main {
    public static void main(String[] args) {

        Mammal human = new Human(28, "George", 1.89, 100.9, true);
        System.out.println(human.toString());

        Mammal cat = new Cat(2, "Lucy", 0.3, 5.0, true);
        System.out.println(cat.toString());

        Human programmer = new Programmer(36,"George Orwell", 1.88, 85.0, true);
        System.out.println(programmer.toString());
    }
}
