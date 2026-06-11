package org.example.W3Schools.JavaSmallProjectAndEx.ExX1GPTResource;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Ebook extends LibraryBook{

    private int fileSizeMb;

    public Ebook(String title, String author, int pages, boolean isBorrowed, int fileSizeMb) {
        super(title, author, pages, isBorrowed);
        this.fileSizeMb = fileSizeMb;
    }

    public void printDownloadMessage(){
        System.out.println("File size: " + fileSizeMb + "Ebook is downloading...");
    }
}
