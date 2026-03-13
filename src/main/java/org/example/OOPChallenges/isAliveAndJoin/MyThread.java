package org.example.OOPChallenges.isAliveAndJoin;

public class MyThread extends Thread{
    public void run(){
        try{
            for(int i = 0; i < 5; i++){
                System.out.println(getName() + " is running " + i);
                Thread.sleep(500); // Sleep for 500 milliseconds
            }
        } catch(InterruptedException e){
            System.out.println("Thread was interrupted: " + e.getMessage());
        }
    }
}
