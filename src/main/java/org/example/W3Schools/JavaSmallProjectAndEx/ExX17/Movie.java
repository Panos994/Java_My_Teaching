package org.example.W3Schools.JavaSmallProjectAndEx.ExX17;

import com.beust.ah.A;
import lombok.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Movie {
    private String title;
    private String director;
    private List<Actor> actors = new ArrayList<>();
    private List<Review> reviews = new ArrayList<>();



    public void addReview(Review rev){
        reviews.add(rev);
    }

    public List<Review> getReviews(){
        return Collections.unmodifiableList(reviews);
    }

}
