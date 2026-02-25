package org.example.exercice1;

public class Counter {
    int val;

    public Counter(){

    }

    public Counter(int x){
        val = x;
    }

    public int getValue(){
        return val;
    }
    public void increment(){
        val++;
    }

    public void incrementBy(int s){
        val += s;
    }
    public void reset(){
        val = 0;
    }

}
