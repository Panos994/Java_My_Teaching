package org.example;
//OOP logic ...
public class Paragraph {

    private int totalWords;
    private String vowels;

    private String consonants;
    private String punctuations;


    private int totalLength;
    private String content;

    public Paragraph() {
    }

    public Paragraph(String content){
        this.content = content;
        totalLength = content.length();
        totalWords = countWords();
        vowels = getVowels();
    }


    public int countWords() {
        return content.split("\\s").length;
    }

    //αντιστοιχα για τα φωνηεντα
    //και συμφωνα

    public String getConsonants() {
        return consonants;
    }

    public void setConsonants(String consonants) {
        this.consonants = consonants;
    }

    public String getVowels() {
        String vow = "αάεέοόυύώωηήιί";
        vowels = "";
        for(int i = 0;i<content.length();i++){
            if(vow.contains(Character.toString(content.charAt(i)))){ //todo:
                vowels+=content.charAt(i);
            }
        }
        return vowels;
    }

    public void setVowels(String vowels) {
        this.vowels = vowels;
    }

    public String getPunctuations() {
        return punctuations;
    }

    public void setPunctuations(String punctuations) {
        this.punctuations = punctuations;
    }

    public int countVowels(){
        String vow = "αάεέοόυύώωηήιί";
        int count = 0; //για να επιστρέψω και το πληθος των φωνηέντων
        for(int i = 0;i<content.length();i++){
            if(vow.contains(Character.toString(content.charAt(i)))){
                count++;
            }
        }
        return count;
    }
    public int countConsonants(){
        String cons = "ςρτθπσδφγξκλζχψβνμ";
        int count = 0;
        for(int i = 0; i < content.length();i++){
            if(cons.contains(Character.toString(content.charAt(i)))){
                count++;
            }
        }
        return count;
    }
}
