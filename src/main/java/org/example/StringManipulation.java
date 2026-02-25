package org.example;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringManipulation {

    public static String getUserInput() {
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    public static void print(String tempMsg) {
        System.out.println(tempMsg);
    }

    public static void reverseString(String str){
        char[] c = str.toCharArray();
        for(int i = c.length-1; i >= 0;i--){
            System.out.print(str.charAt(i));
        }
    }
    public static void upperAndLowerCase(String str){ //ΗELP εψαξα για την μεθοδο
        char[] c = str.toCharArray();
        for(int i = 0; i < c.length; i++){
            if(i%2==0){
                 c[i] = Character.toLowerCase(str.charAt(i));
            } else {
                c[i] = Character.toUpperCase(str.charAt(i));
            }
            System.out.print(c[i]);
        }
    }

    public static void representOddInASCII(String str){  //ΗELP
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            int ascii = (int) c;   // δεν το εβρισκα --> https://stackoverflow.com/questions/16458564/convert-character-to-ascii-numeric-value-in-java
            if(i%2!=0){
               System.out.print(ascii + " ");
            } else {
                System.out.print(c);
            }
        }
    }
    public static void sortString(String str){
        char[] c = str.toCharArray();
        Arrays.sort(c);
        for(int i = c.length - 1; i >= 0; i--){
            System.out.print(c[i]);
        }
    }

    public static void transferLetter(String str){
        char[] charArr = str.toCharArray();
        for(int i = 0; i < charArr.length-1;i+=2){ //ειδα αυτο στο for για το swap γιατι ειχα κολλησει --> https://www.bing.com/search?q=method%20forswapAdjacentChars%20in%20java&qs=n&form=QBRE&sp=-1&lq=0&pq=method%20forswapadjacentchars%20in%20java&sc=12-35&sk=&cvid=66D639C955144FFB8E54299A2D5989C5   --> γιατι κανω +=2
            char temp = charArr[i];
            charArr[i] = charArr[i+1];
            charArr[i+1] = temp;
            if(charArr[i] == 'Ω'){
                charArr[i] = 'A';
            }if(charArr[i] == 'ω'){
                charArr[i] = 'α';
            }
        }
        System.out.print(charArr);
    }
    public static void diplayAlphabet(String str){
        int increment = 0;
        //char[] c = str.toCharArray();
        char value1;
        String value = "";
        Map<Character, String> alpbet = new HashMap<>();
        alpbet.put('Α',"1");
        alpbet.put('Β',"2");
        alpbet.put('Γ',"3");
        alpbet.put('Δ',"4");
        alpbet.put('Ε',"5");
        alpbet.put('Ζ',"6");
        alpbet.put('Η',"7");
        alpbet.put('Θ',"8");
        alpbet.put('Ι',"9");
        alpbet.put('Κ',"10");
        alpbet.put('Λ',"11");
        alpbet.put('Μ',"12");
        alpbet.put('Ν',"13");
        alpbet.put('Ξ',"14");
        alpbet.put('Ο',"15");
        alpbet.put('Π',"16");
        alpbet.put('Ρ',"17");
        alpbet.put('Σ',"18");
        alpbet.put('Τ',"19");
        alpbet.put('Υ',"20");
        alpbet.put('Φ',"21");
        alpbet.put('Χ',"22");
        alpbet.put('Ψ',"23");
        alpbet.put('Ω',"24");
        for(int i = 0; i < str.length();i++){
            //for(int j = 0; j < alpbet.size(); j++){
            for(Map.Entry<Character,String> set : alpbet.entrySet()){ // δεν το ηξερα και το ειδα εδω πως να φερνω εψαξα το 1ο και 2ο κλειδι με iteraion Map --> https://www.geeksforgeeks.org/java/how-to-iterate-hashmap-in-java/
                if(set.getKey().equals(str.charAt(i))){
                    value1 = set.getKey();
                    value = set.getValue();
                    System.out.println("For the input of: " + value1 + " position in Greek Alphabet is: " + value);
                }
            }
        }
    }

    public static void consonantsBeforeVowels(String str){
        char v;
        char conson;
        String vow = "";
        String cons = "";
        String finalResult = "";
        for(int i = 0; i < str.length();i++){
            if(str.charAt(i) == 'Α' || str.charAt(i) == 'Ε' || str.charAt(i) == 'Η' || str.charAt(i) == 'Ι' || str.charAt(i) == 'Ο' || str.charAt(i) == 'Υ' || str.charAt(i) == 'Ω') {
                 v = str.charAt(i);
                 vow += Character.toString(v);
            } else if (!(str.charAt(i) == 'Α' || str.charAt(i) == 'Ε' || str.charAt(i) == 'Η' || str.charAt(i) == 'Ι' || str.charAt(i) == 'Ο' || str.charAt(i) == 'Υ' || str.charAt(i) == 'Ω')) {
                 conson = str.charAt(i);
                 cons += Character.toString(conson);
            }
            finalResult = cons + vow;
        }
        System.out.println(finalResult);
    }
    public static void main(String[] args) {
        print("Welcome new user, please give me a string of latin alphabet characters, bigger or equals to 6 and smaller or equals to 12 (without symbols or digits): ");
        String input = "";
        Pattern pat = Pattern.compile("[!#$%^&*()@;'<>?/|:1234567890]");   ////ΗELP find and match απο Pattern για regex - stackoverflow
        boolean notValid = true;
        do {
            notValid = false; //μπαινω μεσα και το notValid γινεται false, αν τυχον γινει true για τους παρακαατω λόγους θα συνεχισει η λουπα (στο while λεω notValid να ειναι true. Ειδαλλως θα βγω απο την επαναληψη.

            input = getUserInput();
            Matcher m = pat.matcher(input);
            if (input.length() < 6 || input.length() > 12) {
                print("Invalid length of characters. Try again");
                notValid = true;
            }

            if(m.find()){
                print("Invalid special characters. Try again"); //https://stackoverflow.com/questions/756567/regular-expression-for-excluding-special-characters
                //matches ειναι για να ματσαρει ακριβως το pattern! Tο find ειναι εστω και ενα χαρακτηρα αν βρει
                notValid = true;
            }
        } while (input.length() < 6 || input.length() > 12 || notValid);
        print("I will print your string in various ways >>>>>>");

        print("1st way in reverse: ");
        reverseString(input);
        print("\n");
        print("2nd way >> i) odd position-> lowercase || ii) even position->uppercase: ");
        upperAndLowerCase(input);

        print("\n");
        print("3rd way >> i) odd position-> ASCII code represenations: ");
        representOddInASCII(input);

        print("\n");
        print("4rth way represent string sorted DESC: ");
        sortString(input);

        print("\n");
        print("5th way change every letter with its next - and for the case that the letter is the last of the alphabet should become first letter of alphabet (e.g. Ω --> Α)");
        transferLetter(input);

        print("\n");
        print("6th way. Show the number of position in the Greek alphabet in Uppercase (e.g. Γ --> 3)");
        diplayAlphabet(input);

        print("\n");
        print("7th way. Show consonants first and vowels second");
        consonantsBeforeVowels(input);
    }
}
