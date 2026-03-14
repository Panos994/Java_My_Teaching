package org.example.OOPChallenges.UserDefinedPackages;

public class UserDefinedPackages {
    public static void main(String[] args) {
        try{
            MyMath math = new MyMath();
            int sum = math.add(5,6);
            long fact = math.factorial(4);

            System.out.println("sum is " + sum);
            System.out.println("factorial is: " + fact);
        } catch(IllegalArgumentException e){
            System.err.println("Error " + e.getMessage());
        }


    }
}
