package org.example;

public class Weapon extends Item{
    private String classOfWeapon;
    private int rangeOfAttack;
    private int attackInterval;

    public Weapon(int size, int requiredStr, int price, int requiredDex, int requiredIntel, String effect, int rarity, String classOfWeapon, int rangeOfAttack, int attackInterval) {
        super(size, requiredStr, price, requiredDex, requiredIntel, effect, rarity);
        this.classOfWeapon = classOfWeapon;
        this.rangeOfAttack = rangeOfAttack;
        this.attackInterval = attackInterval;
    }

    public String getClassOfWeapon() {
        return classOfWeapon;
    }

    public void setClassOfWeapon(String classOfWeapon) {
        this.classOfWeapon = classOfWeapon;
    }

    public int getRangeOfAttack() {
        return rangeOfAttack;
    }

    public void setRangeOfAttack(int rangeOfAttack) {
        this.rangeOfAttack = rangeOfAttack;
    }

    public int getAttackInterval() {
        return attackInterval;
    }

    public void setAttackInterval(int attackInterval) {
        this.attackInterval = attackInterval;
    }

    public boolean upgradeWeapon(){
        return false;
    }
}
