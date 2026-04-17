package org.example.W3Schools.JavaSmallProjectAndEx.Ex21;

public class Main {
    public static void main(String[] args) {
        int num = 121;
        System.out.println(num + " is palindrome: " + isPalindrome(num));
        System.out.println(num + " is palindrome: " + isPalV2(num));
    }
    private static boolean isPalindrome(int num){
        String s = String.valueOf(num);
        int left = 0, right = s.length() - 1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right))
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    private static boolean isPalV2(int num){
        if(num < 0) return false;
        int original = num;
        int reversed = 0;
        while (num > 0){
            int digit = num %10;
            reversed = (reversed * 10) + digit;
            num/=10;

        }
        return original == reversed;
    }



}
