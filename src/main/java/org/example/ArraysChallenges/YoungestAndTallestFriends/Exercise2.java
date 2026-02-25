package org.example.ArraysChallenges.YoungestAndTallestFriends;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Exercise2 {
    public static void main(String[] args) {

        List<Friend> friendList = new ArrayList<>(List.of(new Friend("Amar",25,1.78), new Friend("Akbar", 26,1.91),new Friend("Anthony", 27,1.80)));
        Collections.sort(friendList);
        for(Friend friend : friendList){
            System.out.println("Name and age and Height sorted Asc are: " + friend.getName() +" " + friend.getAge() + " " + friend.getHeight());
        }
        System.out.println();
        for(int i = friendList.size() - 1; i >= 0; i--){
            System.out.println("Name and age and Height sorted are Desc: " + friendList.get(i).getName() +" " + friendList.get(i).getAge() + " " + friendList.get(i).getHeight());


        }

        friendList.sort(Comparator.comparing(Friend::getHeight).reversed());
        System.out.println("\nAnd Height sorted: ");
        for(Friend friend : friendList){
            System.out.println("Name: " + friend.getName() + " Height is: " + friend.getHeight());
        }




    }
}
