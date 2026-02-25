package org.example;

import java.util.ArrayList;

public class Quest {
    private String goal;
    private Item itemReward;
    private int goldReward;

    public Quest(String goal, Item itemReward, int goldReward) {
        this.goal = goal;
        this.itemReward = itemReward;
        this.goldReward = goldReward;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public Item getItemReward() {
        return itemReward;
    }

    public void setItemReward(Item itemReward) {
        this.itemReward = itemReward;
    }

    public int getGoldReward() {
        return goldReward;
    }

    public void setGoldReward(int goldReward) {
        this.goldReward = goldReward;
    }

    public String goalInfo(){
        return "";
    }
    public Item itemRewardInfo(){
        return null;
    }

    public int goldInfo(){
        return -1;
    }
}
