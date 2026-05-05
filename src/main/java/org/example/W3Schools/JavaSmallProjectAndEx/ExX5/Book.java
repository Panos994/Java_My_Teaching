package org.example.W3Schools.JavaSmallProjectAndEx.ExX5;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Book {
    private String title;
    @Setter
    private String author;
    @Getter
    private int ISBN;

    private List<Book> bookList;

    public Book(String title, String author, int ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        bookList = new ArrayList<>();

    }

    public Book() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String normalizeISBN(int ISBN) {
        if (ISBN > 0) {
            return "GRATHBOOKL" + this.ISBN;
        }
        return null;
    }


    public static void addBook(List<Book> list, String title, String author, int ISBN) {

        list.add(new Book(title, author, ISBN));

    }

    public static void removeBook(List<Book> list, String title, String author, int ISBN) {

        list.remove(new Book(title, author, ISBN));

    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, ISBN);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return ISBN == book.ISBN && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }
}
