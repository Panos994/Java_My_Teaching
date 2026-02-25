package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class PassiveTree {
    private ArrayList<Integer> alreadyLearnedSkills;
    private int amountOfAvailablePoints;

    public PassiveTree(int amountOfAvailablePoints) {
        this.amountOfAvailablePoints = amountOfAvailablePoints;
        this.alreadyLearnedSkills = new ArrayList<>();
    }

    public ArrayList<Integer> getAlreadyLearnedSkills() {
        return alreadyLearnedSkills;
    }

    public void setAlreadyLearnedSkills(ArrayList<Integer> alreadyLearnedSkills) {
        this.alreadyLearnedSkills = alreadyLearnedSkills;
    }

    public int getAmountOfAvailablePoints() {
        return amountOfAvailablePoints;
    }

    public void setAmountOfAvailablePoints(int amountOfAvailablePoints) {
        this.amountOfAvailablePoints = amountOfAvailablePoints;
    }

    public void showPassiveTree(){
        System.out.println("Passive Tree has as already learned skills: " + this.alreadyLearnedSkills + " and amount of available points: " + this.amountOfAvailablePoints);
    }

    public void learnNewSkill(int newSkillId){
        if(amountOfAvailablePoints > 0){
            alreadyLearnedSkills.add(newSkillId);
            amountOfAvailablePoints--;
            System.out.println("Skill " + newSkillId +  " learned!");
        } else {
            System.out.println("Not enough points!");
        }
    }

    public void resetAllPoints(){
        this.amountOfAvailablePoints = 0;
    }
}
