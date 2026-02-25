package org.example;

import java.util.regex.Pattern;

public class User {
    private String emailAddress;

    // Κατασκευαστής (Constructor)
    public User(String emailAddress) {
        // Ορίζουμε το email μόνο αν είναι έγκυρο
        if (isEmailAddress(emailAddress)) {
            this.emailAddress = emailAddress;
        } else {
            System.out.println("Μη έγκυρη διεύθυνση email. Ο χρήστης δεν δημιουργήθηκε.");
            this.emailAddress = null;
        }
    }

    // Η non-static μέθοδος.
    // Ελέγχει την ιδιότητα (field) 'emailAddress' του συγκεκριμένου αντικειμένου.
    public boolean isEmailValid() {
        return Pattern.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", this.emailAddress);
    }

    // Εδώ έχουμε μια static βοηθητική μέθοδο
    // Χρησιμοποιείται από τον κατασκευαστή για τον αρχικό έλεγχο
    public static boolean isEmailAddress(String address) {
        return Pattern.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", address);
    }
}
