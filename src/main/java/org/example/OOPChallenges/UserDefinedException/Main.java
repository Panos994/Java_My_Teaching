package org.example.OOPChallenges.UserDefinedException;

public class Main {
    public static void main(String[] args) {
       try{
           UserDefinedException.checkNum(10);
           UserDefinedException.checkNum(-5);
       } catch(CustomExcpetion e){
           System.out.println("Caught exception: " + e.getMessage());
       }
    }
}
