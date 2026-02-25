package org.example;

import java.util.ArrayList;

public class Monster extends Character{

    private String monsterRace;
    private String monsterRank;


    public Monster(String name, boolean friendly, boolean playable, int hp, int mp, String attackType1, String attackType2, String passiveSkills, String activeSkills, float movementSpeed, int dex, int intel, int str, int lvl, PassiveTree passiveTree, Inventory inventory, String class1, Weapon weapon, ArrayList<Equipment> equipment, int gold, String monsterRace, String monsterRank) {
        super(name, friendly, playable, hp, mp, attackType1, attackType2, passiveSkills, activeSkills, movementSpeed, dex, intel, str, lvl, passiveTree, inventory, class1, weapon, equipment, gold);
        this.monsterRace = monsterRace;
        this.monsterRank = monsterRank;
    }

    public String getMonsterRace() {
        return monsterRace;
    }

    public void setMonsterRace(String monsterRace) {
        this.monsterRace = monsterRace;
    }

    public String getMonsterRank() {
        return monsterRank;
    }

    public void setMonsterRank(String monsterRank) {
        this.monsterRank = monsterRank;
    }

    private ArrayList<Item> dropAwards(){
        return null;
    }
}
