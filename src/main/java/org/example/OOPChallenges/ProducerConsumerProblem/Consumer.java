package org.example.OOPChallenges.ProducerConsumerProblem;

public class Consumer implements Runnable{
    private Drop drop;
    public Consumer(Drop drop){
        this.drop = drop;
    }
    @Override
    public void run() {
        for(int i = 0; i <= 10;i++){
            int value = drop.take();
            System.out.println("Consumed: " + value);
            try {
                Thread.sleep((int) Math.random() * 1500);
            } catch (InterruptedException e) {
               Thread.currentThread().interrupt();
            }
        }
    }
}
