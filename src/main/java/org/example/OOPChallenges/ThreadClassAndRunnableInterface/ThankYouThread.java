package org.example.OOPChallenges.ThreadClassAndRunnableInterface;

public class ThankYouThread extends Thread{
    public void run(){
        try{
            while(true){
                System.out.println("Thank you!");
                Thread.sleep(3000);
            }
        } catch(InterruptedException e){
            System.out.println("Thread was interrupted" + e.getMessage());
        }
    }
}
