package org.example.W3Schools.StreamsW3Schools.StreamOtherResourceGPTEx16;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);
        int sum = nums.stream().filter(n->n%2==0).mapToInt(n->n*n).sum();
        System.out.println("Sum of squares of even numbers: " + sum);

        List<String> words = Arrays.asList("Apple", "an", "angle", "Bob", "aBC", "axe");
        int count = (int) words.stream().filter(s->s.toLowerCase().startsWith("a")).count();
        System.out.println("Count of words starting with 'a': " + count);
        int count2 =  words.stream().filter(s->s.toLowerCase().startsWith("a")).filter(s->s.length() > 3).mapToInt(String::length).sum();
        System.out.println("Count of words starting with 'a': " + count);
    }
}
