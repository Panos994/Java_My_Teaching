package org.example.OOPChallenges.ThreadClassAndRunnableInterface;

public class GoodMorningThread extends Thread{

    public void run(){
        try{
            while(true){
                System.out.println("Good Morning!");
                Thread.sleep(1000); // Sleep for 1 second
            }
        } catch(InterruptedException e){
            System.out.println("Good Morning thread interrupted: " + e.getMessage());
        }
    }
}
