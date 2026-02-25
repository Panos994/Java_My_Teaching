package org.example;

import java.util.ArrayList;

public class Player extends Character{

    private int currentExp;
    private ArrayList<Quest> listOfQuests;
    private Party currentParty;

    private int positionX;
    private int  positionY;
    private Character lockedTarget;

    private boolean hasActiveQuest = false;

    private int goldGoal = 0;

    public Player(String name, boolean friendly, boolean playable, int hp, int mp, String attackType1, String attackType2, String passiveSkills, String activeSkills, float movementSpeed, int dex, int intel, int str, int lvl, PassiveTree passiveTree, Inventory inventory, String class1, Weapon weapon, ArrayList<Equipment> equipment, int gold, int currentExp, ArrayList<Quest> listOfQuests, Party currentParty, int positionX, int positionY, Character lockedTarget) {
        super(name, friendly, playable, hp, mp, attackType1, attackType2, passiveSkills, activeSkills, movementSpeed, dex, intel, str, lvl, passiveTree, inventory, class1, weapon, equipment, gold);
        this.currentExp = currentExp;
        this.listOfQuests = listOfQuests;
        this.currentParty = currentParty;
        this.positionX = positionX;
        this.positionY = positionY;
        this.lockedTarget = lockedTarget;
    }

    public Player(String name, boolean friendly, boolean playable, int hp, int mp, String attackType1, String attackType2, String passiveSkills, String activeSkills, float movementSpeed, int dex, int intel, int str, int lvl, PassiveTree passiveTree, Inventory inventory, String class1, Weapon weapon, ArrayList<Equipment> equipment, int gold, int positionY, int positionX) {
        super(name, friendly, playable, hp, mp, attackType1, attackType2, passiveSkills, activeSkills, movementSpeed, dex, intel, str, lvl, passiveTree, inventory, class1, weapon, equipment, gold);
        this.positionY = positionY;
        this.positionX = positionX;
    }

    public int getCurrentExp() {
        return currentExp;
    }

    public void setCurrentExp(int currentExp) {
        this.currentExp = currentExp;
    }

    public ArrayList<Quest> getListOfQuests() {
        return listOfQuests;
    }

    public void setListOfQuests(ArrayList<Quest> listOfQuests) {
        this.listOfQuests = listOfQuests;
    }

    public Party getCurrentParty() {
        return currentParty;
    }

    public void setCurrentParty(Party currentParty) {
        this.currentParty = currentParty;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public boolean isHasActiveQuest() {
        return hasActiveQuest;
    }

    public void setHasActiveQuest(boolean hasActiveQuest) {
        this.hasActiveQuest = hasActiveQuest;
    }

    public int getGoldGoal() {
        return goldGoal;
    }

    public void setGoldGoal(int goldGoal) {
        this.goldGoal = goldGoal;
    }

    public Character getLockedTarget() {
        return lockedTarget;
    }

    public void setLockedTarget(Character lockedTarget) {
        this.lockedTarget = lockedTarget;
    }

    public boolean pickUpItem(){
        return false;
    }

    public void pickUpGold(){

    }

    public void readAllQuests(){

    }

    public void endGame(){

    }
}
