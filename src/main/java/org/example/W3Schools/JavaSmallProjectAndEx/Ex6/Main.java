package org.example.W3Schools.JavaSmallProjectAndEx.Ex6;

public class Main {
    public static void main(String[] args) {
        String test = "noon";
        System.out.println(palindromeChecker(test));
        System.out.println(palindromeChecker2(test));
    }
    private static boolean palindromeChecker(String input){
        StringBuilder sb = new StringBuilder(input);
        if(input.equals(sb.reverse().toString())){
            return true;
        } else {
            return false;
        }
    }

    //or
    private static boolean palindromeChecker2(String input){
      int left = 0, right = input.length() - 1;
      while(left < right){
          if(input.charAt(left) == input.charAt(right)){
              return true;
          }
          left++;
          right--;
      }
      return false;
    }
}
