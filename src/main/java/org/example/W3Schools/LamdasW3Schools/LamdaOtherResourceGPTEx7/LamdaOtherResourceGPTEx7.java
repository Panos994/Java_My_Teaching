package org.example.W3Schools.LamdasW3Schools.LamdaOtherResourceGPTEx7;

import org.example.W3Schools.LamdasW3Schools.LamdaOtherResourceGPTEx5.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class LamdaOtherResourceGPTEx7 {
    public static void main(String[] args) {
        List<String> words = List.of("java", "C", "python", "Go", "JS");

        Predicate<String> wor = (s) -> s.length() >= 3;
        filterWords(words,wor).forEach(System.out::println);

    }

    static List<String> filterWords(List<String> words, Predicate<String> rule){
        List<String> out = new ArrayList<>();
        for(String s : words){
            if(rule.test(s)) out.add(s);
        }
        return out;
    }


}
