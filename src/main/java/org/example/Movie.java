package org.example;

import java.util.ArrayList;

class Movie extends TVShow {
    /*
     *Movie is extended from TVShow and has extra attribute length.
     */
    private String length;
    private String director;

    public Movie() {
        super();
    }

    public void setLength(String length) {
        this.length = length;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    @Override
    public String toString() {
        return "title:'"+ title + '\'' +
                ", director:'" + director + '\'' +
                ", genre:'" + genre + '\'' +
                ", year:'" + year + '\'' +
                ", length:'" + length + '\'' +
                ", rating:'" + rating + '\'' +
                ", cast:" + cast +
                '}';
    }
}
