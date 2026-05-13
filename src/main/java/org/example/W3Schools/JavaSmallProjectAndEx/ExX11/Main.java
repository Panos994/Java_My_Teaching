package org.example.W3Schools.JavaSmallProjectAndEx.ExX11;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Library lb = new Library();
        Book b1 = new Book("Java Programming",  "1234567890");
        Book b12 = new Book("Python Programming",  "9890567890");

        lb.addBook(b1);
        lb.addBook(b12);
        lb.removeBook(b1);

        System.out.println("Books in library:");
        List<Book> books = lb.getBooks();
        for (Book b : books) {
            System.out.println(b.getTitle() + " - " + b.getISBN());
        }
    }
}
