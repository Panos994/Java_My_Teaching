package org.example.W3Schools.LamdasW3Schools.Lamda13;

public class Main {
    public static void main(String[] args) {
        String words = "Hello World, how are you!";
        WordCounter wordC = s ->s.split("\\s+").length;
        int ctr = wordC.countWords(words);
        System.out.println(ctr);

    }
}
