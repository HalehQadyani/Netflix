package org.example;

import java.util.ArrayList;

class TVShow {
    /*
     *The TVShow should have a title , genre, release year, duration and a rating.
     *The TVShow should have an ArrayList of the cast.
     */

    protected String title;
    protected String genre;
    protected String year;
    protected String duration;
    protected String rating;

    protected ArrayList<String> cast = new ArrayList<String>();

    public TVShow(){}

//    public TVShow(String title, String genre, String year, String duration, String rating,ArrayList<String> cast){
//        this.title=title;
//        this.genre=genre;
//        this.year=year;
//        this.duration=duration;
//        this.rating=rating;
//        this.cast=cast;
//    }


    public void setYear(String year) {
        this.year = year;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCast(ArrayList<String> cast) {
        this.cast = cast;
    }


    public String getDuration() {
        return duration;
    }

    public String getGenre() {
        return genre;
    }

    public String getRating() {
        return rating;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }


    public ArrayList<String> getCast() {
        return cast;
    }

    @Override
    public String toString() {
        return "title:'" + title + '\'' +
                ", genre:'" + genre + '\'' +
                ", year:'" + year + '\'' +
                ", duration:'" + duration + '\'' +
                ", rating:'" + rating + '\'' +
                ", cast:" + cast +
                '}';
    }
}