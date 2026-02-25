package org.example;

import java.util.ArrayList;

public class Party {
    private ArrayList<Character> listOfCharacters;

    public Party(ArrayList<Character> listOfCharacters) {
        this.listOfCharacters = listOfCharacters;
    }

    public ArrayList<Character> getListOfCharacters() {
        return listOfCharacters;
    }

    public void setListOfCharacters(ArrayList<Character> listOfCharacters) {
        this.listOfCharacters = listOfCharacters;
    }

    public boolean enterParty(){
        return false;
    }
    public boolean exitParty(){
        return false;
    }

    public ArrayList<Character> partyInfo(){
        return null;
    }


}
