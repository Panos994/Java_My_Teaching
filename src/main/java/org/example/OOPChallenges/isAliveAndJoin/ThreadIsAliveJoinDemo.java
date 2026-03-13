package org.example.OOPChallenges.isAliveAndJoin;

public class ThreadIsAliveJoinDemo {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.setName("Thread-1");
        t1.start();

        System.out.println(t1.getName() + " is alive: " + t1.isAlive());

        try{
            t1.join();
        } catch(InterruptedException e){
            System.out.println("Thread is interrupted" + e.getMessage());
        }

        System.out.println(t1.getName() + " is alive after join: " + t1.isAlive());
        System.out.println("Main thread is exiting");
    }
}
