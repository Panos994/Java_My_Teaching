package org.example.W3Schools.JavaSmallProjectAndEx.ExX15;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Song {
    private String title;
    private double duration;
    private String genre;

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                ", genre='" + genre + '\'' +
                '}';
    }
}
