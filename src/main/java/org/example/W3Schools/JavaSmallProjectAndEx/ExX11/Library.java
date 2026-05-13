package org.example.W3Schools.JavaSmallProjectAndEx.ExX11;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book b){
        this.books.add(b);
    }

    public void removeBook(Book b){
        this.books.remove(b);
    }
}
