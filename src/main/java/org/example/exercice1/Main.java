package org.example.exercice1;

public class Main {
    public static void main(String[] args) {
        Counter counter1 = new Counter();
        Counter counter2 = new Counter(5);
        Counter counter3 = new Counter(10);
        counter1.increment();
        counter2.increment();
        counter3.increment();
        counter1.incrementBy(10);
        counter2.incrementBy(10);
        counter3.incrementBy(10);
        counter3.reset();
        counter3.incrementBy(counter2.getValue());
        counter1.reset();
        counter1.incrementBy(counter2.getValue() + counter3.getValue());
        System.out.println("First counter is: " + counter1.getValue() + ", the 2nd counter is: " + counter2. getValue() + " and 3rd counter is: " + counter3.getValue());

    }
}