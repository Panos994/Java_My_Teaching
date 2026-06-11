package org.example.W3Schools.JavaSmallProjectAndEx.ExX1GPTResource;

public class Runner {
    public static void main(String[] args) {
        Ebook eb = new Ebook("Lord of the Rings","Tolkien", 1050, false, 150);
        Ebook eb2 = new Ebook("Lord of the Rings II","Tolkien", 1045, false, 150);
        Ebook eb3 = new Ebook("Lord of the Rings III","Tolkien", 1090, true, 150);

        eb.printBookDetails();
        eb2.printBookDetails();
        eb3.printBookDetails();
        eb2.printDownloadMessage();

        eb3.rentABook();
        eb2.rentABook();

        eb2.returnBook();

    }
}
