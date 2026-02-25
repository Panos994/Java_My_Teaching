package org.example;

import java.util.Random;

public class Message {
    private static final Random rand = new Random();
    private String msg;

    public Message(){}

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static String getCriticalHitMessages(){

        String[] criticalHitMsgs = {"Critical Hit attack!!!", "Shouts Haiii Fatalityyy!!!" };

        return criticalHitMsgs[rand.nextInt(criticalHitMsgs.length)];
    }

    public static String getAgilityMessages(){
        String[] agilityMsgs = {"Agility defence!!!","Losing less life due to agility"};
        return agilityMsgs[rand.nextInt(agilityMsgs.length)];
    }
}
