package org.example;

import java.util.Random;

public class Samurai {
    private String name;
    private WeaponType weaponType;

    private boolean doubleweapon;
    private boolean hasHorse;
    private boolean hasArmor;
    private Type type;

    private double hitpower;
    private double life;

    public Samurai() {
    }

    ;

    public Samurai(String name) {
        this.name = name;
    }

    public Samurai(String name, WeaponType weaponType, boolean doubleweapon, boolean hasHorse, boolean hasArmor, Type type, double hitpower, double life) {
        this.name = name;
        this.weaponType = weaponType;
        this.doubleweapon = doubleweapon;
        this.hasHorse = hasHorse;
        this.hasArmor = hasArmor;
        this.type = type;
        this.hitpower = hitpower;
        this.life = life;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public boolean isDoubleweapon() {
        return doubleweapon;
    }

    public void setDoubleweapon(boolean doubleweapon) {
        this.doubleweapon = doubleweapon;
    }

    public boolean isHasHorse() {
        return hasHorse;
    }

    public void setHasHorse(boolean hasHorse) {
        this.hasHorse = hasHorse;
    }

    public boolean isHasArmor() {
        return hasArmor;
    }

    public void setHasArmor(boolean hasArmor) {
        this.hasArmor = hasArmor;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public double getHitpower() {
        return hitpower;
    }

    public void setHitpower(double hitpower) {
        this.hitpower = hitpower;
    }

    public double getLife() {
        return life;
    }

    public void setLife(double life) {
        this.life = life;
    }

    public double defend(double val) {
         double reduction = 0.0;
        if (hasArmor && hasHorse) {
            reduction = 15.0;
        } else if (hasArmor) {
            reduction = 10.0;
        } else if(hasHorse){
            reduction = 5.0;
        }
        return val - reduction;
    }

    public double getWeaponPower() {
        double katana = 10.0, yumi = 15.00, naginata = 20.00, wakizashi = 5.0;
        if (weaponType.equals(WeaponType.katana)) {
            return doubleweapon ? katana * 1.8 : katana;
        } else if (weaponType.equals(WeaponType.yumi)) {
            return doubleweapon ? yumi * 1.8 : yumi;
        } else if (weaponType.equals(WeaponType.naginata)) {
            return doubleweapon ? naginata * 1.8 : naginata;
        } else {
            return doubleweapon ? wakizashi * 1.8 : wakizashi;
        }
    }

    public double attack() {
        Random rand = new Random();
        hitpower = rand.nextDouble(10,20);
        if (type.equals(Type.military)) {
            System.out.println(name + " shouts haaaaiiii!");

            return hitpower + 10.0;

        } else {
            System.out.println(name + " shouts haaaaiiii!");
            return hitpower + 5.0 + (hitpower / 4.0);
        }
    }

    public void checkState() {
        if (life <= 0.0) {
            life = 0.0;
            System.out.println(name + " ...died!");
        } else {
            System.out.println(name + " remaining life " + Math.ceil(life));
        }
    }
    public void print() {
        System.out.println("Name is " + name + " and his weapon is " + weaponType + " and has " + ((doubleweapon) ? " double weapons" : "has not double weapons") + " and has " + ((hasHorse) ? "a horse" : "not a horse") + " and has  " +
                ((hasArmor) ? " an armor" : "not an armor") + " and he is a " + type + ". His hitpower is: " + hitpower + " and remaining life is: " + Math.ceil(life));
    }
    //helper method reveive damage για να δεχεται επιθεσεις
    public void reveiveDamage(double damage){
        double fdamage = defend(damage);
        if(fdamage <= 0) fdamage = 0;
        life-=fdamage;
        checkState();
    }
}
