package org.example.OOPChallenges.DaemonThreads;

public class DaemonThreads extends Thread{ //daemon threads are background threads that run in the background and do not prevent the JVM from exiting when the program finishes. They are typically used for tasks that should run continuously in the background, such as monitoring or housekeeping tasks. When all non-daemon threads have finished executing, the JVM will exit, and any remaining daemon threads will be terminated.
    public void run() {
        try {
            while (true) {
                System.out.println("Daemon thread is running...");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Daemon thread interrupted.");
        } finally {
            System.out.println("Daemon thread finally block executed.");
        }
    }
}
