package org.example.OOPChallenges.MethodOverloading;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,5,10};
        int target = 15;
        findSumOfATarget(arr);
        findSumOfATarget(arr, target);
    }

    private static void findSumOfATarget(int[] arr){
        int targetSum = 15;
        int sum = 0;
        for(int i = 0; i < arr.length;i++){
            sum+=arr[i];
        }
        printRes(sum, targetSum);
    }

    private static void findSumOfATarget(int[] arr, int targetSum){
        int sum = 0;
        for(int i = 0; i < arr.length;i++){
            sum+=arr[i];
        }
        printRes(sum, targetSum);
    }
    private static void printRes(int sum, int target){
        if(sum == target){
            System.out.println("Target sum " + target + " found!");
        } else {
            System.out.println("Sum is " + sum + " not in the target" + target);
        }
    }
}
