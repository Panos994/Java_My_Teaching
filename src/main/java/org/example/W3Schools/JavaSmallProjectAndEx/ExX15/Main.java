package org.example.W3Schools.JavaSmallProjectAndEx.ExX15;

public class Main {
    public static void main(String[] args) {
        MusicLibrary musicLibrary = new MusicLibrary();

        musicLibrary.addSong(new Song("Bohemian Rhapsody", 3.56, "Rock"));
        musicLibrary.addSong(new Song("Bohemian Metal", 3.44, "Metal"));
        musicLibrary.addSong(new Song("Fallen", 3.56, "Metalcore"));
        musicLibrary.addSong(new Song("Metal Rhapsody", 3.56, "NU metal"));

        System.out.println("All songs in the library:");
        for(Song song : musicLibrary.getSongs()){
            System.out.println(song.getTitle() + " - " + song.getGenre() + " - " + song.getDuration() + " mins");
        }

        System.out.println("\nRandom song will be played");
        System.out.println(musicLibrary.randomSong());


    }
}
