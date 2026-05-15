package org.example.W3Schools.StreamsW3Schools.StreamOtherResourceGPTEx1;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);
        int sum = nums.stream().filter(n-> n%2==0).mapToInt(n->n*n).sum();
        System.out.println("Sum of even numbers: " + sum);

        List<Integer> nums2 = List.of(10, 21, 4, 17, 8, 30);
        int max = nums2.stream().filter(n->n%2!=0).mapToInt(Integer::intValue).max().orElse(-1);
        System.out.println("Max odd number: " + max);


        List<String> items = List.of("  java", "Python ", "C++", " java ", "Go", "JAVA");
        int countDifferenctLangs = (int) items.stream().map(String::trim).map(String::toLowerCase).distinct().count();
        System.out.println("Number of different programming languages: " + countDifferenctLangs);

        long countDifferentLangs = items.stream().map(String::trim).map(String::toLowerCase).distinct().count();
        System.out.println("Number of different programming languages: " + countDifferenctLangs);
    }
}
