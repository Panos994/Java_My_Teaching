package org.example.W3Schools.JavaSmallProjectAndEx.ExX5;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Book b = new Book("978-3-16-148410-0", "The Great Gatsby",12345);
        System.out.println("ISBN normalization: " + b.normalizeISBN(b.getISBN()));

        List<Book> booksCollection = new ArrayList<>(List.of(new Book("The Great Gatsby 2", "GG",12345), new Book("To Kill a Mockingbird", "BRf",54321)));


        Book.addBook(booksCollection, "1984","George Orwell", 67890);


        for(Book bs : booksCollection){
            System.out.println("Title: " + bs.getTitle() + ", Author: " + bs.getAuthor() + ", ISBN: " + bs.getISBN());
        }
        System.out.println("%".repeat(400));
        Book.removeBook(booksCollection, "The Great Gatsby 2","GG", 12345);
        for(Book bs : booksCollection){
            System.out.println("Title: " + bs.getTitle() + ", Author: " + bs.getAuthor() + ", ISBN: " + bs.getISBN());
        }
    }


}
