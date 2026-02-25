package org.example;

public class Equipment extends Item{

    private String type;
    private int armor;

    public Equipment(int size, int requiredStr, int price, int requiredDex, int requiredIntel, String effect, int rarity, String type, int armor) {
        super(size, requiredStr, price, requiredDex, requiredIntel, effect, rarity);
        this.type = type;
        this.armor = armor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public boolean upgradeEquipment(){
        return false;
    }
}
