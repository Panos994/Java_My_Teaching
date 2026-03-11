package org.example.OOPChallenges.ThreadClassAndRunnableInterface;

public class Main {
    public static void main(String[] args) {
        Thread t1 = new GoodMorningThread();
        Thread t2 = new HelloThread();
        Thread t3 = new ThankYouThread();

        t1.start();
        t2.start();
        t3.start();
    }
}
