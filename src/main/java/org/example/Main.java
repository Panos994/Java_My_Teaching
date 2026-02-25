package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Paragraphs paragraphs = new Paragraphs();
        Mechanism.countLettersAndSymbols(Mechanism.getParagraph());
        System.out.println();
        Mechanism.countWords(Mechanism.getParagraph());
        System.out.println();
        Mechanism.countLettersAndSymbolsAll();
        System.out.println();
        boolean exitProgram = false;
        while(!exitProgram){
            exitProgram = Mechanism.userChoices(sc);
        }
        sc.close();


        //OOP approcach:
        String[] par = {
                "Το 75% περίπου του εγκεφάλου μας αποτελείται από νερό.", "Ο ανθρώπινος εγκέφαλος έχει τη δυνατότητα να αποθηκεύσει χίλια terabyte πληροφοριών.", "Ο ανθρώπινος εγκέφαλος έχει περίπου 100 δισεκατομμύρια νευρώνες.", "Τα τεχνητά νευρωνικά δίκτυα μιμούνται το κεντρικό νευρικό σύστημα. Ωστόσο τα δίκτυα αυτά χρειάζονται 40 λεπτά για να επεξεργαστούν αυτό που ο ανθρώπινος εγκέφαλος επεξεργάζεται σε ένα δευτερόλεπτο.", "Υπάρχουν περίπου 160.000 χλμ. αιμοφόρων αγγείων στον ανθρώπινο εγκέφαλο. Το μήκος τους επαρκεί για να κάνει το γύρο της Γης τέσσερις φορές.", "ΦΑΙΆ ΟΥΣΊΑ: Έτσι ονομάζονται οι νευρώνες που είναι υπεύθυνοι για την ομιλία, την μνήμη και τον έλεγχο των μυών.", "Όταν αναπαύεται, ο ανθρώπινος εγκέφαλος παράγει αρκετή ενέργεια για να ανάψει μια λάμπα 25 watt.", "Οι επιστήμονες έχουν καταλήξει στο συμπέρασμα ότι ο εγκέφαλος φτάνει στην πλήρη ωριμότητά του στα 25 μας χρόνια.", "Η χαμηλότερη ταχύτητα με την οποία επεξεργάζεται ο εγκέφαλός μας την πληροφορία είναι 418 χλμ./ώρα.", "Ο εγκέφαλος του ανθρώπου δεν χάνει ποτέ την ικανότητά του να μαθαίνει και να αλλάζει. Αυτό οφείλεται στην ελαστικότητά του και στο γεγονός ότι δημιουργεί συνεχώς νέες συνάψεις."
        };
        Paragraph[] paragraphs = new Paragraph[par.length];
        System.out.println("-----------Counters of words, vowels, consonants of paragraphs: ");
        System.out.println();
        for(int i = 0; i < par.length;i++){
            paragraphs[i] = new Paragraph(par[i]);
            int vow = paragraphs[i].countVowels();
            int cons = paragraphs[i].countConsonants();
            int words = paragraphs[i].countWords();

            System.out.println("Paragraph " + (i + 1) + ":");
            System.out.println("Content: " + par[i]);
            System.out.println("Vowels:" + vow);
            System.out.println("Consontant: " + cons);
            System.out.println("Total words: " + words);
        }
    }
}