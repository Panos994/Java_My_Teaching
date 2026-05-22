package org.example.W3Schools.JavaSmallProjectAndEx.ExX18;

import lombok.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Restaurant {
    private List<MenuItem> items = new ArrayList<>();
    private List<Rating> ratings = new ArrayList<>();

    public void addItem(MenuItem it){
        items.add(it);
    }

//    public void removeItem( String itName){
//        Iterator<MenuItem> iterator = items.iterator();
//        while(iterator.hasNext()){
//            MenuItem it = iterator.next();
//            if(it.getName().equals(itName)){
//                iterator.remove();
//            }
//        }
//
//    }

    public void removeItem(String itName){
        items.removeIf(it -> it.getName().equals(itName));
    }

    public void addRating(Rating r){
        ratings.add(r);
    }

    public double avgRating(){
        if(ratings.isEmpty()) return 0.0;
        double sum = 0;
        for(Rating r : ratings){
           sum+=r.getRank();
        }
        return sum/ratings.size();
    }
}
