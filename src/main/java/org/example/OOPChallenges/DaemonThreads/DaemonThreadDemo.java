package org.example.OOPChallenges.DaemonThreads;

public class DaemonThreadDemo {
    public static void main(String[] args) {
        DaemonThreads dt = new DaemonThreads();
        dt.setDaemon(true);
        dt.start();

        try{
            Thread.sleep(3000);
        } catch(InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Main thread ending, JVM will exit and daemon thread will stop.");
    }
}
