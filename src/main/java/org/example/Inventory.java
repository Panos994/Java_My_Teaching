package org.example;

import java.util.ArrayList;

public class Inventory {

    private ArrayList<Item> items;
    private String type;
    private int size;

    public Inventory(String type, int size) {
        this.items = new ArrayList<>();
        this.type = type;
        this.size = size;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }



    public Item getItem(Item item){
        for(Item it : items){
            if(item.equals(it)){
                return it;
            }
        }
        return null;
    }

    public void putItem(Item item){
        this.items.add(item);
    }
}
