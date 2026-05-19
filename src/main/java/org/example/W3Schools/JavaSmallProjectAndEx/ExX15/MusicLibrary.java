package org.example.W3Schools.JavaSmallProjectAndEx.ExX15;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Setter
@AllArgsConstructor
public class MusicLibrary {
    Random rand = new Random();
    private List<Song> songs;

    public MusicLibrary() {
        songs = new ArrayList<>();
    }

    public void addSong(Song s){
        songs.add(s);
    }
    public void removeSong(Song s){
        songs.remove(s);
    }

    public Song randomSong(){
        if(songs.isEmpty()){
            System.out.println("No songs in the library");
            return null;
        }
        int randomIdx = rand.nextInt(songs.size());
        System.out.println(songs.get(randomIdx).getTitle() + " is playing");
        return songs.get(randomIdx);

    }


}
