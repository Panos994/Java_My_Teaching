package org.example.OOPChallenges.ClassInvokeExercise;

public class Main {
    public static void main(String[] args) {
        TestClass testClass = new TestClass("GeorgeTest", 27);

        testClass.incrementAge();
        System.out.println(testClass.toString());
    }
}
