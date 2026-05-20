package org.example.W3Schools.StreamsW3Schools.StreamOtherResourceGPTEx20;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> emails = List.of(
                "Panos994@gmail.com",
                "admin@GITHUB.com",
                "test@yahoo.com",
                "hello@gmail.com",
                "bot@github.com",
                "x@Yahoo.com"
        );

        List<String> filteredEmails = emails.stream().map(e-> e.substring(e.indexOf('@') + 1).toLowerCase())
                        .distinct().sorted().toList();
        System.out.println(filteredEmails);
    }
}
