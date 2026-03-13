package org.example.OOPChallenges.ProducerConsumerProblem;

public class Producer implements Runnable{
    private Drop drop;
    public Producer(Drop drop) {
        this.drop = drop;
    }

    @Override
    public void run() {
        for(int i = 0; i <= 10; i++){
            drop.put(i);
            System.out.println("Produced: " + i);
            try{
                Thread.sleep((int) (Math.random() * 1000));
            } catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }
}
