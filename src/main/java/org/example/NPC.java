package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class NPC extends Character implements IInteractable{
    private ArrayList<Quest> availableQuests;


    public NPC(String name, boolean friendly, boolean playable, int hp, int mp, String attackType1, String attackType2, String passiveSkills, String activeSkills, float movementSpeed, int dex, int intel, int str, int lvl, PassiveTree passiveTree, Inventory inventory, String class1, Weapon weapon, ArrayList<Equipment> equipment, int gold, ArrayList<Quest> availableQuests) {
        super(name, friendly, playable, hp, mp, attackType1, attackType2, passiveSkills, activeSkills, movementSpeed, dex, intel, str, lvl, passiveTree, inventory, class1, weapon, equipment, gold);
        this.availableQuests = availableQuests;
    }

    public ArrayList<Quest> getAvailableQuests() {
        return availableQuests;
    }

    public void setAvailableQuests(ArrayList<Quest> availableQuests) {
        this.availableQuests = availableQuests;
    }

    public void trade(){

    }

    public void talk(){

    }

    public void hire(){

    }

    public void acceptQuest(){

    }
    public void completeQuest(){

    }

    @Override
    public void interact(Player player) {
        System.out.println("Hello, I am " + getName());
        Scanner sc = new Scanner(System.in);
        System.out.println("Options [1] for talking, [2] for trading, [3] completing quest, [4] hiring!");
        System.out.println("Choose your action: ");
        String action = sc.next();
        if(action.equals("1")){
            if(!player.isHasActiveQuest()){
                System.out.println(getName() + " : Can you collect 150 gold for me? I will reward you");
                player.setHasActiveQuest(true);
                player.setGoldGoal(150);
            } else {
                System.out.println(getName() + " : 'How is your quest going? You need " + player.getGoldGoal() + " gold'");
            }
        }else if(action.equals("2")){
        if(player.isHasActiveQuest() && player.getGold() >= player.getGoldGoal()){
            System.out.println(getName() + " Amazing you did it! Here is your reward: 50XP");
            player.setGold(player.getGold() - player.getGoldGoal()); // Παίρνει το χρυσό
            player.setHasActiveQuest(false); //quest τελος
            player.setLvl(player.getLvl() + 1); //reward
        } else {
            System.out.println(getName() + "you have not finished the task!");
        }
    }

    }
}
