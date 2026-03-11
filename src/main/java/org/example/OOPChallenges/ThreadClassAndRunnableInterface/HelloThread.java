package org.example.OOPChallenges.ThreadClassAndRunnableInterface;

public class HelloThread extends Thread{
    public void run(){
        try{
            while(true){
                System.out.println("Hello");
                Thread.sleep(2000);
            }
        } catch(InterruptedException e){
            System.out.println("Hello Thread interrupted: " + e.getMessage());
        }
    }
}
