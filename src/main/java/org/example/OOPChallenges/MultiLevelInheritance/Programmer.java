package org.example.OOPChallenges.MultiLevelInheritance;

public class Programmer extends Human{

    private String mainLanguage;

    public Programmer(int age, String name, double height, double weight, boolean male) {
        super(age, name, height, weight, male);
    }

    @Override
    public String toString(){
        return "Programmer [Language=" + mainLanguage + "] " + super.toString();
    }
}
