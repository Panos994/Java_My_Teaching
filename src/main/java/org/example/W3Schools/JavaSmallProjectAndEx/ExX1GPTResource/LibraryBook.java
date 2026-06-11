package org.example.W3Schools.JavaSmallProjectAndEx.ExX1GPTResource;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LibraryBook {
    private String title;
    private String author;
    private int pages;
    private boolean isBorrowed;


    public void rentABook(){
        if(this.isBorrowed){
            System.out.println("This book --> "  +  this.title + " is unavailable!Choose another one ");
        } else {
            System.out.println("Book is available " + this.title);
            this.isBorrowed = true;
        }
    }

    public void returnBook(){
        this.isBorrowed = false;
        System.out.println("Returning a book: " +  this.title + " and now is available");
    }

    public void printBookDetails(){
        System.out.printf("Book Details: %s --- %s --- %d %n",this.title,this.author,this.pages);
    }

}
