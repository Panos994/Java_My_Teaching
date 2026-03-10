package org.example.OOPChallenges.UserDefinedException;

public class UserDefinedException {
    public static void checkNum(int number) throws CustomExcpetion {
        if(number < 0){
            throw new CustomExcpetion("Negative number is not allowed: " + number);
        } else {
            System.out.println("Number is valid: " + number);
        }
    }
}
