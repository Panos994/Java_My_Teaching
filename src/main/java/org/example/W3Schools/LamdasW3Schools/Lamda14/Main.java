package org.example.W3Schools.LamdasW3Schools.Lamda14;

import javax.print.DocFlavor;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        //madam
        String strPali = "madam";
        PalindromeChecker isPali = () -> {
            int left = 0, right = strPali.length() -1;
            while(left < right){
                if(strPali.charAt(left) == strPali.charAt(right)){
                    return true;
                }
                left++;
                right--;

            }
            return false;
        };

        System.out.println(isPali.isPalindrome());

        //or without interface
        Predicate<String> isPalindrome = s -> {
            String rev = new StringBuilder(s).reverse().toString();
            return s.equals(rev);
        };
        System.out.println(isPalindrome.test(strPali));
    }
}
