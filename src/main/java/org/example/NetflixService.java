package org.example;

import java.util.ArrayList;

class NetflixService {
    /*
     *The NetflixService should have an Arraylist of users, tv shows and movies.
     *The NetflixService should have a User object which represents current user.
     */
    public ArrayList<TVShow> tvShowList = new ArrayList<TVShow>();
    public ArrayList<Movie> movieList = new ArrayList<Movie>();
    private ArrayList<User> userList = new ArrayList<User>();


    public void addTVShow(TVShow tvShow){
        tvShowList.add(tvShow);
        System.out.println(tvShow.getTitle() + " added successfully");
    }

    public void removeTVShow(String title){
        int ind=showIndex(title);

        if(ind!=-1) {
            tvShowList.remove(ind);
            System.out.println(title + " removed successfully");
        }

        else{
            System.out.println("there is no such show in our archive");
        }
    }

    public void addMovie(Movie movie){
        movieList.add(movie);
        System.out.println(movie.getTitle() + " added successfully");
    }

    public void removeMovie(String title){
        int ind=movieIndex(title);

        if(ind!=-1) {
            movieList.remove(ind);
            System.out.println(title + " removed successfully");
        }

        else{
            System.out.println("there is no such movie in our archive");
        }
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public void updateUser(User user){
        userList.remove(user);
        userList.add(user);
    }

    public boolean passwordCheck(String username, String password) {
        int ind= userIndex(username);

        if(userList.get(ind).getPassword().equals(password)){
            return true;
        }
        return false;
    }

    public ArrayList<TVShow> searchtByTitle(String title) {
        ArrayList<TVShow> result=new ArrayList<TVShow>();


        for(int i=0;i<tvShowList.size();i++){
            if (tvShowList.get(i).getTitle().contains(title)){
                result.add(tvShowList.get(i));
            }
        }

        if(result.size()>0) {
            return result;
        }

        else{
            System.out.println("there was no show available with this title");
            return null;
        }
    }

    public ArrayList<TVShow> searchtByGenre(String genre) {
        ArrayList<TVShow> result=new ArrayList<TVShow>();
        for(int i=0;i<tvShowList.size();i++){
            if (tvShowList.get(i).getGenre().equals(genre)){
                result.add(tvShowList.get(i));
            }
        }

        if(result.size()>0) {
            return result;
        }

        else{
            System.out.println("there was no show available with this genre");
            return null;
        }
    }

    public ArrayList<TVShow> searchtByReleaseYear(String year) {
        ArrayList<TVShow> result=new ArrayList<TVShow>();

        for(int i=0;i<tvShowList.size();i++){
            if (tvShowList.get(i).getYear().equals(year)){
                result.add(tvShowList.get(i));
            }
        }

        if(result.size()>0) {
            return result;
        }

        else{
            System.out.println("there was no show available starting this year");
            return null;
        }
    }

    public ArrayList<TVShow> searchtByCast(String cast) {
        ArrayList<TVShow> result=new ArrayList<TVShow>();

        for(int i=0;i<tvShowList.size();i++){
            if (tvShowList.get(i).getCast().contains(cast)){
                result.add(tvShowList.get(i));
            }
        }

        if(result.size()>0) {
            return result;
        }

        else{
            System.out.println("there was no show available with this actor");
            return null;
        }
    }


    public ArrayList<Movie> searchmByTitle(String title) {
        ArrayList<Movie> result=new ArrayList<Movie>();
        for(int i=0;i<movieList.size();i++){
            if (movieList.get(i).getTitle().contains(title)){
                result.add(movieList.get(i));
            }
        }

        if(result.size()>0) {
            return result;
        }

        else{
            System.out.println("there was no movie available with this title");
            return null;
        }
    }

    public ArrayList<Movie> searchmByGenre(String genre) {
        ArrayList<Movie> result=new ArrayList<Movie>();
        for(int i=0;i<movieList.size();i++){
            if (movieList.get(i).getGenre().equals(genre)){
                result.add(movieList.get(i));
            }
        }

        if(result.size()>0) {
            return result;
        }

        else{
            System.out.println("there was no movie available with this genre");
            return null;
        }
    }

    public ArrayList<Movie> searchmByReleaseYear(String year) {
        ArrayList<Movie> result=new ArrayList<Movie>();

        for(int i=0;i<movieList.size();i++){
            if (movieList.get(i).getYear().equals(year)){
                result.add(movieList.get(i));
            }
        }

        if(result.size()>0) {
            return result;
        }

        else{
            System.out.println("there was no movie available starting this year");
            return null;
        }
    }

    public ArrayList<Movie> searchmByCast(String cast) {
        ArrayList<Movie> result=new ArrayList<Movie>();
        for(int i=0;i<movieList.size();i++){
            if (movieList.get(i).getCast().contains(cast)){
                result.add(movieList.get(i));
            }
        }

        if(result.size()>0) {
            return result;
        }

        else{
            System.out.println("there was no movie available with this actor");
            return null;
        }
    }


    public int userIndex(String username){
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUsername().equals(username)) {
                return i;
            }
        }

        //-1 indicates that the user doesn't exist in the library
        return -1;
    }

    public int showIndex(String title){
        for (int i = 0; i < tvShowList.size(); i++) {
            if (tvShowList.get(i).getTitle().equals(title)) {
                return i;
            }
        }

        //-1 indicates that the show doesn't exist in the library
        return -1;
    }

    public int movieIndex(String title){
        for (int i = 0; i < movieList.size(); i++) {
            if (movieList.get(i).getTitle().equals(title)) {
                return i;
            }
        }

        //-1 indicates that the movie doesn't exist in the library
        return -1;
    }

    public boolean doesUsernameExist(String username){
        int ind=userIndex(username);

        if(ind!=-1){
            return true;
        }

        else{
            return false;
        }
    }

    public User searchUser(String username){
        int ind=userIndex(username);
        return userList.get(ind);
    }
}


