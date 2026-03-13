package org.example.OOPChallenges.ProducerConsumerProblem;

public class Main {
    public static void main(String[] args) {
        Drop drop = new Drop();
        Thread producerThread = new Thread(new Producer(drop));
        Thread consumerThread = new Thread(new Consumer(drop));

        producerThread.start();
        consumerThread.start();
    }
}
