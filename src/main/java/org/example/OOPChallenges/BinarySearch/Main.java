package org.example.OOPChallenges.BinarySearch;

public class Main {
    public static void main(String[] args) {
        int a[] = { 2, 3, 4, 10, 40 };
        int n = a.length;
        int x = 10;
        int res = binarySearch(a, 0, n - 1, x);

        System.out.println("Element to be searched is : "
                + x);

        if(res == -1){
            System.out.println("Element is not present in the array");
        } else{
            System.out.println("element is present: " + res);
        }
    }
    public static int binarySearch(int[] arr, int left, int right, int n){
         left = 0;
         right = arr.length - 1;

        while (left <= right){
            int mid = left + (right - left) / 2; // arr[] a = {1,2,3,4} --> 1 + (4-1) / 2  = 2
            if(arr[mid] == n){
                return mid;
            }
            if(arr[mid] > n){
                return right = mid - 1;
            }
            if(arr[mid] < n){
                return left = mid + 1;
            }
        }
        return -1;
    }
}
