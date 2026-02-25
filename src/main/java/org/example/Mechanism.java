package org.example;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mechanism {

    public static void countLettersAndSymbolsAll() {
        Scanner sc = new Scanner(System.in);
        String[] par = {
                "Το 75% περίπου του εγκεφάλου μας αποτελείται από νερό.", "Ο ανθρώπινος εγκέφαλος έχει τη δυνατότητα να αποθηκεύσει χίλια terabyte πληροφοριών.", "Ο ανθρώπινος εγκέφαλος έχει περίπου 100 δισεκατομμύρια νευρώνες.", "Τα τεχνητά νευρωνικά δίκτυα μιμούνται το κεντρικό νευρικό σύστημα. Ωστόσο τα δίκτυα αυτά χρειάζονται 40 λεπτά για να επεξεργαστούν αυτό που ο ανθρώπινος εγκέφαλος επεξεργάζεται σε ένα δευτερόλεπτο.", "Υπάρχουν περίπου 160.000 χλμ. αιμοφόρων αγγείων στον ανθρώπινο εγκέφαλο. Το μήκος τους επαρκεί για να κάνει το γύρο της Γης τέσσερις φορές.", "ΦΑΙΆ ΟΥΣΊΑ: Έτσι ονομάζονται οι νευρώνες που είναι υπεύθυνοι για την ομιλία, την μνήμη και τον έλεγχο των μυών.", "Όταν αναπαύεται, ο ανθρώπινος εγκέφαλος παράγει αρκετή ενέργεια για να ανάψει μια λάμπα 25 watt.", "Οι επιστήμονες έχουν καταλήξει στο συμπέρασμα ότι ο εγκέφαλος φτάνει στην πλήρη ωριμότητά του στα 25 μας χρόνια.", "Η χαμηλότερη ταχύτητα με την οποία επεξεργάζεται ο εγκέφαλός μας την πληροφορία είναι 418 χλμ./ώρα.", "Ο εγκέφαλος του ανθρώπου δεν χάνει ποτέ την ικανότητά του να μαθαίνει και να αλλάζει. Αυτό οφείλεται στην ελαστικότητά του και στο γεγονός ότι δημιουργεί συνεχώς νέες συνάψεις."
        };
        Pattern pat = Pattern.compile("[\\p{Punct}a-zA-Z0-9]");
        int countVowels = 0;
        int countConsonants = 0;
        int otherCharacters = 0;
        String temp = "";
        for (String p : par) {
            temp += p;
        }
        char[] c = temp.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 'ά' || c[i] == 'α' || c[i] == 'ε' || c[i] == 'έ' || c[i] == 'η' || c[i] == 'Η' || c[i] == 'ο' || c[i] == 'ό' || c[i] == 'Ο' || c[i] == 'υ' || c[i] == 'ύ' || c[i] == 'Υ' || c[i] == 'ι' || c[i] == 'ί' || c[i] == 'ώ' || c[i] == 'ω') {
                countVowels++;
            } else if (pat.matcher(String.valueOf(c[i])).matches()) { //https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/regex/Pattern.html
                otherCharacters++;
            } else if (!(c[i] == 'ά' || c[i] == 'α' || c[i] == 'ε' || c[i] == 'έ' || c[i] == 'η' || c[i] == 'Η' || c[i] == 'ο' || c[i] == 'ό' || c[i] == 'Ο' || c[i] == 'υ' || c[i] == 'ύ' || c[i] == 'Υ' || c[i] == 'ι' || c[i] == 'ί' || c[i] == 'ώ' || c[i] == 'ω' || c[i] == ' ')) {
                countConsonants++;
            }
        }
        System.out.println("For the total paragraphs --> count of punctuations: " + otherCharacters);
        System.out.println("For the total paragraphs --> count of vowels: " + countVowels);
        System.out.println("For the total paragraphs --> count of consonants: " + countConsonants);
        int[] arrSorted = {countVowels, countConsonants, otherCharacters};
        Arrays.sort(arrSorted);
        for (int i = 0; i < arrSorted.length; i++) {
            System.out.println("For the total paragraphs --> count of punctuations, vowels, consonants sorted: " + arrSorted[i]);
        }

        System.out.println("\n" + "Παρακαλώ δώστε μία λέξη ή έναν αριθμό ή την λέξη 'βοηθεια' για περισσότερες πληροφορίες: ");

        String input = "";
        Pattern pat3 = Pattern.compile("^[Α-Ωα-ωάέήίόύώΆΈΉΊΌΎΏ]+$"); //https://stackoverflow.com/questions/46988374/regex-expression-in-java-for-upper-case-greek-letter     +     https://regexpattern.com/greek-latin-characters/#google_vignette
        input = sc.nextLine();
        while(input.length() < 3 || !(pat3.matcher(input).matches())) {
                System.out.println("Παρακαλώ, φροντίστε η λέξη που εισάγετε να έχει περισσότερο από 3 γράμματα και να είναι στην Ελληνική γλώσσα");
                input = sc.nextLine();

        }
        String regex = "\\b" + Pattern.quote(input) + "\\b";    //https://www.bing.com/search?q=check%20if%20a%20word%20exists%20in%20a%20String%20Java&qs=n&form=QBRE&sp=-1&ghc=1&lq=0&pq=check%20if%20a%20word%20exists%20in%20a%20string%20jav&sc=0-38&sk=&cvid=023B67BF47C1420B81503A93675A77CD
        Pattern pat2 = Pattern.compile(regex, Pattern.CASE_INSENSITIVE); //

        for (String p : par) {
            Matcher matcher = pat2.matcher(p);
            while (matcher.find()) {
                //if (input.contains(matcher.group())) {
                    System.out.println("input: " + input + " exists in paragraph: " + p);
                //}
            }
        }
        System.out.println();
        int inputNum = 0;
        //int countWords = 0;
        System.out.println("Παρακαλώ δώστε έναν αριθμό στο διάστημα [1-15] για την ελάχιστη καταμέτρηση λέξεων:");
        inputNum = sc.nextInt();
        while(inputNum < 1 || inputNum > 15){
            System.out.println("Παρακαλώ, δώστε αριθμό στο διάστημα [1-15].");
            inputNum = sc.nextInt();
        }
        //Pattern pat4 = Pattern.compile("[1-15]");
        for(String p : par){
            int paragraphWords = 0;
            //countWords = p.split("\\s").length;
            String[] words = p.split("\\s");
            for(String word : words){
                String tempStr = "";
                tempStr = word;
                //δεν εχω βαλει τον έλεγχο για τα CASE_SENSITIVE (ισως με αυτο να βρισκω λυση)
                if(word.equalsIgnoreCase(tempStr)){
                    if(word.length() > 3){
                        paragraphWords++;
                    }
                }
            }
            if(paragraphWords >= inputNum){
                System.out.println("words counts: " + paragraphWords + "  in this paragraph: " + p);
            }
        }

        System.out.println("\n" + "Παρακαλώ πληκτρολογήστε εκ νέου για περιγραφές: "); //TODO: αύριο καλύτερα αυτα που εχω φτιαξει για το Β να τα βαλω σε 4 μεθόδους και ίσως με switch case ή με if να εχω στην Main 1 input variable και να εκτυπωνει αναλογως τι δινει ο χρηστης
        String input3 = "";
        input3= sc.next();
        if(input3.equals("βοήθεια")){
            System.out.println("Ο εγκέφαλος αποτελεί το σπουδαιότερο και μεγαλύτερο τμήμα του κεντρικού νευρικού συστήματος. Βρίσκεται εντός του εγκεφαλικού κρανίου και περιβάλλεται από τρεις προστατευτικούς υμένες, τις μήνιγγες. Αποτελείται από δύο ημισφαίρια τα οποία χωρίζονται μεταξύ τους από την επιμήκη σχισμή. Από την κάτω επιφάνεια του εγκεφάλου εκφύονται οι εγκεφαλικές συζυγίες ή νεύρα και ξεκινά ο νωτιαίος μυελός." + "\n");
            System.out.println("Από το 1945 οι επιστήμονες γνωρίζουν, ότι ο εγκέφαλος είναι περίπου 73% νερό. Η καλή ενυδάτωση του εγκεφάλου είναι απαραίτητη. Αφυδάτωση της τάξης μόλις του 2% μπορεί να επηρεάσει την ικανότητα του ατόμου να εκτελεί καθήκοντα που αφορούν την προσοχή, την μνήμη και τις κινητικές δεξιότητες. Η χοληστερόλη είναι ένας τύπος λίπους που συχνά θεωρείται κακός για την υγεία του ατόμου. Είναι αλήθεια ότι η κατανάλωση υπερβολικής χοληστερόλης είναι κακή για την καρδιά. Ωστόσο, πολλοί άνθρωποι δεν γνωρίζουν ότι η χοληστερόλη παίζει σημαντικό ρόλο στον εγκέφαλο ενός ατόμου." + "\n");
        }

        System.out.println("\n" + "Παρακαλώ εισάγεται τιμή: "); //TODO - αύριο να καλείται μία switch - case στην main αναλόγως το input να εκτυπώνει!
        String input4 = "";
        input4 = sc.next();
        Pattern pat4 = Pattern.compile("^[\\p{Punct}]$"); //https://www.bing.com/search?q=greek%20punctuations%20in%20regex%20Java&qs=n&form=QBRE&sp=-1&ghc=1&lq=0&pq=greek%20punctuations%20in%20regex%20jav&sc=0-31&sk=&cvid=8865EBDFFF9E4D10A013F609A4AC759C

        Matcher matcher4 = pat4.matcher(input4);
        String answer = "";
        while(matcher4.find()){

            do{
                System.out.println("Θέλεις να τερματίσεις το πρόγραμμα ? Αν ναι πληκτρολόγησε ΝΑΙ");
                answer = sc.next();
            } while(!answer.equals("ΝΑΙ"));
        }

    }

    public static boolean userChoices(Scanner sc){
        //Scanner sc = new Scanner(System.in);
        String[] par = {
                "Το 75% περίπου του εγκεφάλου μας αποτελείται από νερό.", "Ο ανθρώπινος εγκέφαλος έχει τη δυνατότητα να αποθηκεύσει χίλια terabyte πληροφοριών.", "Ο ανθρώπινος εγκέφαλος έχει περίπου 100 δισεκατομμύρια νευρώνες.", "Τα τεχνητά νευρωνικά δίκτυα μιμούνται το κεντρικό νευρικό σύστημα. Ωστόσο τα δίκτυα αυτά χρειάζονται 40 λεπτά για να επεξεργαστούν αυτό που ο ανθρώπινος εγκέφαλος επεξεργάζεται σε ένα δευτερόλεπτο.", "Υπάρχουν περίπου 160.000 χλμ. αιμοφόρων αγγείων στον ανθρώπινο εγκέφαλο. Το μήκος τους επαρκεί για να κάνει το γύρο της Γης τέσσερις φορές.", "ΦΑΙΆ ΟΥΣΊΑ: Έτσι ονομάζονται οι νευρώνες που είναι υπεύθυνοι για την ομιλία, την μνήμη και τον έλεγχο των μυών.", "Όταν αναπαύεται, ο ανθρώπινος εγκέφαλος παράγει αρκετή ενέργεια για να ανάψει μια λάμπα 25 watt.", "Οι επιστήμονες έχουν καταλήξει στο συμπέρασμα ότι ο εγκέφαλος φτάνει στην πλήρη ωριμότητά του στα 25 μας χρόνια.", "Η χαμηλότερη ταχύτητα με την οποία επεξεργάζεται ο εγκέφαλός μας την πληροφορία είναι 418 χλμ./ώρα.", "Ο εγκέφαλος του ανθρώπου δεν χάνει ποτέ την ικανότητά του να μαθαίνει και να αλλάζει. Αυτό οφείλεται στην ελαστικότητά του και στο γεγονός ότι δημιουργεί συνεχώς νέες συνάψεις."
        };
        System.out.println("\n" + "Παρακαλώ δώστε μία λέξη ή έναν αριθμό ή την λέξη 'βοηθεια' για περισσότερες πληροφορίες: ");

        String input = "";
        Pattern pat3 = Pattern.compile("^[Α-Ωα-ωάέήίόύώΆΈΉΊΌΎΏ]+$"); //https://stackoverflow.com/questions/46988374/regex-expression-in-java-for-upper-case-greek-letter     +     https://regexpattern.com/greek-latin-characters/#google_vignette
        Pattern pat6 = Pattern.compile("^([1-9]|1[0-5])$");
        Pattern pat7 = Pattern.compile("^[\\p{Punct}]$");

        input = sc.nextLine();

        if(input.equalsIgnoreCase("βοηθεια")) {
            System.out.println("Ο εγκέφαλος αποτελεί το σπουδαιότερο και μεγαλύτερο τμήμα του κεντρικού νευρικού συστήματος. Βρίσκεται εντός του εγκεφαλικού κρανίου και περιβάλλεται από τρεις προστατευτικούς υμένες, τις μήνιγγες. Αποτελείται από δύο ημισφαίρια τα οποία χωρίζονται μεταξύ τους από την επιμήκη σχισμή. Από την κάτω επιφάνεια του εγκεφάλου εκφύονται οι εγκεφαλικές συζυγίες ή νεύρα και ξεκινά ο νωτιαίος μυελός." + "\n");
            System.out.println("Από το 1945 οι επιστήμονες γνωρίζουν, ότι ο εγκέφαλος είναι περίπου 73% νερό. Η καλή ενυδάτωση του εγκεφάλου είναι απαραίτητη. Αφυδάτωση της τάξης μόλις του 2% μπορεί να επηρεάσει την ικανότητα του ατόμου να εκτελεί καθήκοντα που αφορούν την προσοχή, την μνήμη και τις κινητικές δεξιότητες. Η χοληστερόλη είναι ένας τύπος λίπους που συχνά θεωρείται κακός για την υγεία του ατόμου. Είναι αλήθεια ότι η κατανάλωση υπερβολικής χοληστερόλης είναι κακή για την καρδιά. Ωστόσο, πολλοί άνθρωποι δεν γνωρίζουν ότι η χοληστερόλη παίζει σημαντικό ρόλο στον εγκέφαλο ενός ατόμου." + "\n");
            return false;
        } else if(pat3.matcher(input).matches()){
            while(input.length() < 3 || !(pat3.matcher(input).matches())) {
                System.out.println("Παρακαλώ, φροντίστε η λέξη που εισάγετε να έχει περισσότερο από 3 γράμματα και να είναι στην Ελληνική γλώσσα");
                input = sc.nextLine();
            }
            String regex = "\\b" + Pattern.quote(input) + "\\b";    //https://www.bing.com/search?q=check%20if%20a%20word%20exists%20in%20a%20String%20Java&qs=n&form=QBRE&sp=-1&ghc=1&lq=0&pq=check%20if%20a%20word%20exists%20in%20a%20string%20jav&sc=0-38&sk=&cvid=023B67BF47C1420B81503A93675A77CD
            Pattern pat2 = Pattern.compile(regex, Pattern.CASE_INSENSITIVE); //

            for (String p : par) {
                Matcher matcher = pat2.matcher(p);
                while (matcher.find()) {
                    //if (input.contains(matcher.group())) {
                    System.out.println("input: " + input + " exists in paragraph: " + p);
                    //}
                }
            }
            return false;
        } else if(pat6.matcher(input).matches()){
            System.out.println();
            int inputNum = Integer.parseInt(input);
            //int countWords = 0;
            System.out.println("Παρακαλώ δώστε έναν αριθμό στο διάστημα [1-15] για την ελάχιστη καταμέτρηση λέξεων:");


            //
            for(String p : par){
                int paragraphWords = 0;
                //countWords = p.split("\\s").length;
                String[] words = p.split("\\s");
                for(String word : words){
                    String tempStr = "";
                    tempStr = word;
                    //δεν εχω βαλει τον έλεγχο για τα CASE_SENSITIVE (ισως με αυτο να βρισκω λυση)
                    if(word.equalsIgnoreCase(tempStr)){
                        if(word.length() > 3){
                            paragraphWords++;
                        }
                    }
                }
                if(paragraphWords >= inputNum){ // δεν μετράει τα άρθρα
                    System.out.println("words counts: " + paragraphWords + "  in this paragraph: " + p);
                }
            }
            return false;

        } else if(pat7.matcher(input).matches()){
            //Matcher matcher4 = pat7.matcher(input);
            String answer = "";


            do{
                System.out.println("Θέλεις να τερματίσεις το πρόγραμμα ? Αν ναι πληκτρολόγησε ΝΑΙ");
                answer = sc.nextLine();
            } while(!answer.equals("ΝΑΙ") && !answer.equalsIgnoreCase("ΟΧΙ"));

            if(answer.equals("ΝΑΙ")){
                return true;
            } else {
                System.out.println("Άγνωστη είσοδος. Ξανα προσπαθήστε...");
            }
        }
        return false;

    }

    public static String[] getParagraph() {

        String[] par = {
                "Το 75% περίπου του εγκεφάλου μας αποτελείται από νερό.", "Ο ανθρώπινος εγκέφαλος έχει τη δυνατότητα να αποθηκεύσει χίλια terabyte πληροφοριών.", "Ο ανθρώπινος εγκέφαλος έχει περίπου 100 δισεκατομμύρια νευρώνες.", "Τα τεχνητά νευρωνικά δίκτυα μιμούνται το κεντρικό νευρικό σύστημα. Ωστόσο τα δίκτυα αυτά χρειάζονται 40 λεπτά για να επεξεργαστούν αυτό που ο ανθρώπινος εγκέφαλος επεξεργάζεται σε ένα δευτερόλεπτο.", "Υπάρχουν περίπου 160.000 χλμ. αιμοφόρων αγγείων στον ανθρώπινο εγκέφαλο. Το μήκος τους επαρκεί για να κάνει το γύρο της Γης τέσσερις φορές.", "ΦΑΙΆ ΟΥΣΊΑ: Έτσι ονομάζονται οι νευρώνες που είναι υπεύθυνοι για την ομιλία, την μνήμη και τον έλεγχο των μυών.", "Όταν αναπαύεται, ο ανθρώπινος εγκέφαλος παράγει αρκετή ενέργεια για να ανάψει μια λάμπα 25 watt.", "Οι επιστήμονες έχουν καταλήξει στο συμπέρασμα ότι ο εγκέφαλος φτάνει στην πλήρη ωριμότητά του στα 25 μας χρόνια.", "Η χαμηλότερη ταχύτητα με την οποία επεξεργάζεται ο εγκέφαλός μας την πληροφορία είναι 418 χλμ./ώρα.", "Ο εγκέφαλος του ανθρώπου δεν χάνει ποτέ την ικανότητά του να μαθαίνει και να αλλάζει. Αυτό οφείλεται στην ελαστικότητά του και στο γεγονός ότι δημιουργεί συνεχώς νέες συνάψεις."
        };
        String[] temp = new String[par.length];
        for (int i = 0; i < par.length; i++) {
            temp[i] = par[i];
        }
        return temp;
    }

    public static void countLettersAndSymbols(String[] paragraphs) {
        Arrays.sort(paragraphs, (a, b) -> Integer.compare(a.length(), b.length()));  //https://www.baeldung.com/java-sort-string-array-length-comparator -- 4rth example
        for (int i = 0; i < paragraphs.length; i++) {
            System.out.println("paragraph length: " + paragraphs[i].length() + " paragraph " + paragraphs[i]);
        }
        System.out.println();
        for (int i = 0; i < paragraphs.length; i++) {
            System.out.println("paragraph count of vowels, consonants and punctuations sorted from smaller to largert total symbols: ");
            countVowelsAndConsonants(paragraphs[i]);
        }
    }

    public static void countVowelsAndConsonants(String str) {
        //StringBuilder sb = new StringBuilder();
        Pattern pat = Pattern.compile("[\\p{Punct}a-zA-Z0-9]"); //https://www.bing.com/search?q=Punctuations+in+regex+Java&form=ANNH01&refig=693d67e19f71411e83d8957d98d5f3e5&pc=DCTS  ---> σημεια στιξης, αγγλικα, αριθμοι
        //Matcher matcher = pat.matcher(str);
        int countVowels = 0;
        int countConsonants = 0;
        int otherCharacters = 0;
        //String vowels = "αάεέηΗοόΟ....";
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 'ά' || c[i] == 'α' || c[i] == 'ε' || c[i] == 'έ' || c[i] == 'η' || c[i] == 'Η' || c[i] == 'ο' || c[i] == 'ό' || c[i] == 'Ο' || c[i] == 'υ' || c[i] == 'ύ' || c[i] == 'Υ' || c[i] == 'ι' || c[i] == 'ί' || c[i] == 'ώ' || c[i] == 'ω') {
                countVowels++;
            } else if (pat.matcher(String.valueOf(c[i])).matches()) { //https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/regex/Pattern.html
                otherCharacters++;
            } else if (!(c[i] == 'ά' || c[i] == 'α' || c[i] == 'ε' || c[i] == 'έ' || c[i] == 'η' || c[i] == 'Η' || c[i] == 'ο' || c[i] == 'ό' || c[i] == 'Ο' || c[i] == 'υ' || c[i] == 'ύ' || c[i] == 'Υ' || c[i] == 'ι' || c[i] == 'ί' || c[i] == 'ώ' || c[i] == 'ω' || c[i] == ' ')) {
                countConsonants++;
            }
        }
        int[] arrSorted = {countVowels, countConsonants, otherCharacters};
        Arrays.sort(arrSorted);
        for (int i = 0; i < arrSorted.length; i++) {
            System.out.println(arrSorted[i]);
        }
    }

    public static void countWords(String[] paragraphs) {  //https://www.w3schools.com/java/java_howto_count_words.asp
        int countWords = 0;
        for (int i = 0; i < paragraphs.length; i++) {    //ΔΕΝ ΤΟ ΚΑΤΑΦΕΡΑ ΑΚΡΙΒΩΣ
            //countWords = paragraphs[i].split("\\s").length;
            countWords = paragraphs[i].split("[\\p{Punct}\\s]+").length;  //καλύτερο αυτό που σπαει το κείμενο όπου βρει οποιοδήποτε σημείο στίξης (Punctuation) ή κενό (space)". Έτσι, θα μείνουν μόνο οι λέξεις (ελληνικές και αγγλικές).
            System.out.println("Count of different words: " + countWords + " for paragraph --> " + paragraphs[i]);
            System.out.println();

            String[] words = paragraphs[i].toLowerCase().split("[\\s.,:;!%?]+"); // https://www.bing.com/search?q=how%20to%20extract%20words%20in%20%20String%20in%20Java&qs=n&form=QBRE&sp=-1&lq=0&pq=how%20to%20extract%20words%20in%20%20stringin%20java&sc=12-38&sk=&cvid=8E629736BEDF45119974A14ADA980744
            boolean[] counted = new boolean[words.length];
            for (int j = 0; j < words.length; j++) {
                int countSimilarWords = 0;
                String currentW = words[j];
                if (currentW.isEmpty() || counted[j]) {
                    continue;
                }
                for (int k = 0; k < words.length; k++) {
                    if (currentW.equalsIgnoreCase(words[k])) {
                        countSimilarWords++;
                        counted[k] = true;
                    }
                }
                if (countSimilarWords > 1) {
                    System.out.println("Similar words were: " + currentW + " and similar words count: " + countSimilarWords);
                }
            }
        }
    }

}
