package org.example;

public abstract class Item {

    private int size;
    private int price;
    private int requiredStr;
    private int requiredDex;
    private int requiredIntel;
    private String effect;
    private int rarity;

    public Item(int size, int requiredStr, int price, int requiredDex, int requiredIntel, String effect, int rarity) {
        this.size = size;
        this.requiredStr = requiredStr;
        this.price = price;
        this.requiredDex = requiredDex;
        this.requiredIntel = requiredIntel;
        this.effect = effect;
        this.rarity = rarity;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRequiredStr() {
        return requiredStr;
    }

    public void setRequiredStr(int requiredStr) {
        this.requiredStr = requiredStr;
    }

    public int getRequiredDex() {
        return requiredDex;
    }

    public void setRequiredDex(int requiredDex) {
        this.requiredDex = requiredDex;
    }

    public int getRequiredIntel() {
        return requiredIntel;
    }

    public void setRequiredIntel(int requiredIntel) {
        this.requiredIntel = requiredIntel;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public int getRarity() {
        return rarity;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    public boolean equipItem(){
        return false;
    }

    public void dropItem(){

    }
}
