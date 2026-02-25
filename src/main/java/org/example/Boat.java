package org.example;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Boat {

    private String name;
    private ArrayDeque<Fisherman> crew = new ArrayDeque<>();

    public Boat() {
    }

    public Boat(String name) {
        this.name = name;
    }

    public void addFisherman(Fisherman f){
        crew.addLast(f); //αυτο λογικα επειδη ειναι ουρα λεει οτι μπαινουν στην σειρα - δηλαδη
    }

    public void startFishingContest(Stack<Fish> waters, int times){
        for(int i = 0; i < times; i++){
            for(Fisherman f : crew){
                f.fishing(waters.pop());
            }
        }
    }
    public void  startNetingContent(Stack<Fish> waters){
        for(Fisherman fishermans : crew){
            fishermans.neting(waters);
        }
    }

    public List<Fisherman> getFishingWinner(){
        double maxScore = Double.MIN_VALUE;
        List<Fisherman> winners = new ArrayList<>();
        for(Fisherman f : crew){
            if(f.getFishingScore() > maxScore) {
                maxScore = f.getFishingScore();
            }
        }
        //για ισοβαθμια
        for(Fisherman f : crew){
            if(f.getFishingScore() == maxScore){winners.add(f);}
        }
        return winners;

    }
    public List<Fisherman> getNetingWinner(){
        double maxScore = Double.MIN_VALUE;
        List<Fisherman> winners = new ArrayList<>();
        for(Fisherman f : crew){
            if(f.getNetingScore() > maxScore){ maxScore = f.getNetingScore();}
        }
        for(Fisherman f : crew){
            if(f.getNetingScore() == maxScore){ winners.add(f);}
        }
        return winners;
    }
}
