package org.example;

import java.util.ArrayList;

public abstract class Character {
    private String name;
    private boolean friendly;
    private boolean playable;
    private int hp;
    private int mp;

    private String attackType1;
    private String attackType2;
    private String passiveSkills;
    private String activeSkills;
    private float movementSpeed;

    private int dex;
    private int str;
    private int intel;
    private int lvl;
    private PassiveTree passiveTree;
    private Inventory inventory;
    private String class1;
    private Weapon weapon;
    private ArrayList<Equipment> equipment;

    private int gold;

    public Character(String name, boolean friendly, boolean playable, int hp, int mp, String attackType1, String attackType2, String passiveSkills, String activeSkills, float movementSpeed, int dex, int intel, int str, int lvl, PassiveTree passiveTree, Inventory inventory, String class1, Weapon weapon, ArrayList<Equipment> equipment,int gold) {
        this.name = name;
        this.friendly = friendly;
        this.playable = playable;
        this.hp = hp;
        this.mp = mp;
        this.attackType1 = attackType1;
        this.attackType2 = attackType2;
        this.passiveSkills = passiveSkills;
        this.activeSkills = activeSkills;
        this.movementSpeed = movementSpeed;
        this.dex = dex;
        this.intel = intel;
        this.str = str;
        this.lvl = lvl;
        this.passiveTree = passiveTree;
        this.inventory = inventory;
        this.class1 = class1;
        this.weapon = weapon;
        this.equipment = equipment;
        this.gold = gold;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFriendly() {
        return friendly;
    }

    public void setFriendly(boolean friendly) {
        this.friendly = friendly;
    }

    public boolean isPlayable() {
        return playable;
    }

    public void setPlayable(boolean playable) {
        this.playable = playable;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public String getAttackType1() {
        return attackType1;
    }

    public void setAttackType1(String attackType1) {
        this.attackType1 = attackType1;
    }

    public String getAttackType2() {
        return attackType2;
    }

    public void setAttackType2(String attackType2) {
        this.attackType2 = attackType2;
    }

    public String getPassiveSkills() {
        return passiveSkills;
    }

    public void setPassiveSkills(String passiveSkills) {
        this.passiveSkills = passiveSkills;
    }

    public String getActiveSkills() {
        return activeSkills;
    }

    public void setActiveSkills(String activeSkills) {
        this.activeSkills = activeSkills;
    }

    public float getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(float movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    public int getDex() {
        return dex;
    }

    public void setDex(int dex) {
        this.dex = dex;
    }

    public int getStr() {
        return str;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public int getIntel() {
        return intel;
    }

    public void setIntel(int intel) {
        this.intel = intel;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public PassiveTree getPassiveTree() {
        return passiveTree;
    }

    public void setPassiveTree(PassiveTree passiveTree) {
        this.passiveTree = passiveTree;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public ArrayList<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(ArrayList<Equipment> equipment) {
        this.equipment = equipment;
    }

    public int getGold(){
        return gold;
    }
    public void setGold(int gold){
        this.gold = gold;
    }

    public void move(){

    }
    public void attack(){

    }

    private void die(){

    }
}
