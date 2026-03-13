package org.example.OOPChallenges.ProducerConsumerProblem;

public class Drop {
    private int contents;
    private boolean available = false;

    public synchronized void put(int value){
        while(available){
            try{
                wait(); //buffer is full, wait for consumer to take something
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        contents = value;
        available = true;
        notify(); //notify waiting consumer that new item is available
    }
    public synchronized int take(){
        while(!available){
            try{
                wait(); //buffer is empty, wait for producer to put something
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        available = false;
        notify(); //notify waiting producer that space is available
        return contents;
    }
}
