package org.example.OOPChallenges.MultipleCatchesClauses;

public class Main {
    public static void main(String[] args) {

        try{
            int[] numbers = {1,2,3};
            System.out.println(numbers[5]); // ArrayIndexOutOfBoundsException
            int result = 10 / 0; // ArithmeticException
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        } catch (ArithmeticException e){
            System.out.println("Caught ArithmeticException: " + e.getMessage());
        } catch (Exception e){
            System.out.println("Caught Exception: " + e.getMessage());
        }
        System.out.println("Program continues after handling exceptions.");

    }
}
