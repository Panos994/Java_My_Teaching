package org.example.W3Schools.JavaSmallProjectAndEx.ExX17;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        //Write a Java program to create a class called "Movie" with attributes for title, director, actors, and reviews, and methods for adding and retrieving reviews.

        Movie mov = new Movie();
        mov.setTitle("Interstellar");
        mov.setDirector("Christopher Nolan");
        mov.getActors().addAll(List.of(new Actor("Matthew McConaughey"), new Actor("Anne Hathaway")));
        mov.addReview(new Review("Average movie", 5));
        mov.addReview(new Review("Average movie", 6));
        mov.addReview(new Review("Great movie", 7));
        mov.addReview(new Review("Great movie", 9));

        System.out.println(mov.getReviews());

    }
}
