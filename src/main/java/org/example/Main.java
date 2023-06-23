package org.example;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;

public class Main {


    public static void main(String[] args) {
        runMenu();
    }

    public static void runMenu() {
        NetflixService service = new NetflixService();

        Scanner scan = new Scanner(System.in);

        String username, password;
        boolean k = true;

        while (true) {
            k = true;
            System.out.println("what program do you want to open? \n 1.netflix (for admins) \n 2.netflix");
            int role = Integer.valueOf(scan.nextLine());

            switch (role) {

                case 1:
                    adminMenu(service);
                    break;


                case 2:
                    k = true;
                    while (k) {
                        System.out.println("1.sign up \n2.log in\n3.exit");

                        System.out.println("insert an number: ");
                        int choice = Integer.valueOf(scan.nextLine());

                        switch (choice) {
                            case 1:
                                User user = createAccount(service);

                                if (user != null) {
                                    service.addUser(user);
                                }
                                break;

                            case 2:
                                User loggedIn = logIn(service);

                                if (loggedIn != null) {
                                    System.out.println("you successfully logged in");
                                    userMenu(service,loggedIn);
                                }

                                break;

                            case 3:
                                k = false;
                                break;


                        }
                    }
                    break;
            }
        }
    }

    public static void adminMenu(NetflixService service){
        boolean k = true;
        Scanner scan=new Scanner(System.in);
        while (k) {
            System.out.println("what do you want to do? \n1.add a movie \n2.remove a movie");
            System.out.println("3.add a tv show \n4.remove a tv show \n5.exit");

            System.out.println("insert an number: ");
            int choice = Integer.valueOf(scan.nextLine());

            switch (choice) {
                case 1:
                    while (true) {
                        service.addMovie(inputMovie());

                        System.out.println("do you want to add another movie? yes/no");

                        String ch = scan.nextLine();

                        if (!ch.equals("yes")) {
                            break;
                        }

                    }
                    break;

                case 2:
                    while (true) {
                        System.out.println("insert name of the movie you want to remove: ");
                        service.removeMovie(scan.nextLine());

                        System.out.println("do you want to remove another movie? yes/no");
                        String ch = scan.nextLine();

                        if (!ch.equals("yes")) {
                            break;
                        }
                    }
                    break;

                case 3:
                    while (true) {
                        System.out.println("insert name of the TV show you want to add: ");
                        service.addTVShow(inputShow());

                        System.out.println("do you want to add another show? yes/no");
                        String ch = scan.nextLine();

                        if (!ch.equals("yes")) {
                            break;
                        }
                    }
                    break;

                case 4:
                    while (true) {
                        System.out.println("insert name of the TV show you want to remove: ");
                        service.removeTVShow(scan.nextLine());

                        System.out.println("do you want to check another book? yes/no");
                        String ch = scan.nextLine();

                        if (!ch.equals("yes")) {
                            break;
                        }
                    }
                    break;

                case 5:
                    k = false;
                    break;
            }
        }

    }

    public static void userMenu(NetflixService service, User user) {
        Scanner scan = new Scanner(System.in);
        boolean k = true;
        while (k) {
            System.out.println("1.search a movie\n2.search a TV show\n3.view favorites\n4.view recommendations\n" +
                    "5.log out");
            int choice = Integer.valueOf(scan.nextLine());

            switch (choice) {
                case 1:
                    ArrayList<Movie> result = searchMovie(service,user);

                    if(result!=null) {
                        viewAnArrayList(result);

                        System.out.println("select a movie");

                        int num = Integer.valueOf(scan.nextLine());

                        System.out.println("what do you want to do with " + result.get(num - 1).getTitle() + "?");
                        System.out.println("1.add to favorites\n2.like\n3.dislike\n4.watch");

                        switch (Integer.valueOf(scan.nextLine())) {
                            case 1:
                                if(!user.getWatched().contains(result.get(num - 1))){
                                    System.out.println("you don't have " + result.get(num - 1).getTitle() + " in your watched " +
                                            "list, do you wanna add it there first? yes/no");

                                    if(scan.nextLine().equals("yes")){
                                        user.watch(result.get(num - 1));
                                    }
                                }

                                user.addToFavoritesm(result.get(num - 1));
                                System.out.println(result.get(num - 1).getTitle() + " added to your favorites");
                                break;

                            case 2:
                                user.like(result.get(num - 1).getTitle());
                                break;

                            case 3:
                                user.dislike(result.get(num - 1).getTitle());
                                break;

                            case 4:
                                user.watch(result.get(num - 1));
                                break;
                        }
                    }

                    break;


                case 2:
                    ArrayList<TVShow> result1 =searchShow(service,user);

                    if(result1!=null) {
                        viewAnArrayList(result1);

                        System.out.println("select a show");

                        int num = Integer.valueOf(scan.nextLine());

                        System.out.println("what do you want to do with " + result1.get(num - 1).getTitle() + "?");
                        System.out.println("1.add to favorites\n2.like\n3.dislike\n4.watch");

                        switch (Integer.valueOf(scan.nextLine())) {
                            case 1:
                                if(!user.getWatched().contains(result1.get(num - 1))){
                                    System.out.println("you don't have " + result1.get(num - 1).getTitle() + " in your watched " +
                                            "list, do you wanna add it there first? yes/no");

                                    if(scan.nextLine().equals("yes")){
                                        user.watch(result1.get(num - 1));
                                    }
                                }

                                user.addToFavoritest(result1.get(num - 1));
                                System.out.println(result1.get(num - 1).getTitle() + " added to your favorites");
                                break;

                            case 2:
                                user.like(result1.get(num - 1).getTitle());
                                break;

                            case 3:
                                user.dislike(result1.get(num - 1).getTitle());
                                break;

                            case 4:
                                user.watch(result1.get(num - 1));
                                break;
                        }
                    }

                    break;

                case 3:
                    user.viewFavorites();
                    break;


                case 4:
                    if (user.favoriteTVshows.size() == 0 && user.favoriteMovies.size() == 0) {
                        System.out.println("you should pick a few favorite shows or movies to get recommendations");
                    }

                    else {
                        user.getRecommendationsByGenre(service);
                        user.getRecommendationsByDirector(service);
                    }

                    break;

                case 5:
                    service.updateUser(user);
                    k=false;
                    break;
            }
        }
    }


    public static ArrayList searchMovie (NetflixService service,User user){
        Scanner scan = new Scanner(System.in);
        ArrayList<Movie> result = new ArrayList<Movie>();

        System.out.println("what do want to search for?");
        System.out.println("1.title\n2.release year\n3.genre\n4.cast");

        int choice = Integer.valueOf(scan.nextLine());

        System.out.println("enter the text you want to search for");
        String input = scan.nextLine();


        System.out.println("where do you wanna search in?\n1.netflix archive\n2.favorite movies");
        switch (Integer.valueOf(scan.nextLine())) {
            case 1:
                switch (choice) {
                    case 1:
                        result = service.searchmByTitle(input);
                        break;

                    case 2:
                        result = service.searchmByReleaseYear(input);
                        break;

                    case 3:
                        result = service.searchmByGenre(input);
                        break;

                    case 4:
                        result = service.searchmByCast(input);
                        break;
                }
                break;


            case 2:
                switch (choice) {
                    case 1:
                        result = user.searchmByTitle(input);
                        break;

                    case 2:
                        result = user.searchmByReleaseYear(input);
                        break;

                    case 3:
                        result = user.searchmByGenre(input);
                        break;

                    case 4:
                        result = user.searchmByCast(input);
                }
                break;
        }

        return result;
    }


    public static ArrayList searchShow (NetflixService service,User user){

        Scanner scan = new Scanner(System.in);
        ArrayList<TVShow> result = new ArrayList<TVShow>();

        System.out.println("what do want to search for?");
        System.out.println("1.title\n2.release year\n3.genre\n4.cast");

        int choice = Integer.valueOf(scan.nextLine());

        System.out.println("enter the text you want to search for");
        String input = scan.nextLine();


        System.out.println("where do you wanna search in?\n1.netflix archive\n2.favorite shows");
        switch (Integer.valueOf(scan.nextLine())) {
            case 1:
                switch (choice) {
                    case 1:
                        result = service.searchtByTitle(input);
                        break;

                    case 2:
                        result = service.searchtByReleaseYear(input);
                        break;

                    case 3:
                        result = service.searchtByGenre(input);
                        break;

                    case 4:
                        result=service.searchtByCast(input);
                }
                break;


            case 2:
                switch (choice) {
                    case 1:
                        result = user.searchtByTitle(input);
                        break;

                    case 2:
                        result = user.searchtByReleaseYear(input);
                        break;

                    case 3:
                        result = user.searchtByGenre(input);
                        break;

                    case 4:
                        result = user.searchtByCast(input);

                }
                break;
        }

        return result;
    }


    public static User createAccount (NetflixService service){
        User user = new User();
        while (true) {
            Scanner scan = new Scanner(System.in);
            String mailPattern = "^[A-Za-z0-9_\\.]+@[A-Za-z0-9]+\\.[A-Za-z]{3}$";

            System.out.println("insert your email:");
            String email = scan.nextLine();

            if (!email.matches(mailPattern)) {
                System.out.println("please insert a valid email");
                System.out.println("do you want to try again? yes/no");
                String ch = scan.nextLine();

                if (!ch.equals("yes")) {
                    return null;
                }
            } else if (service.doesUsernameExist(email)) {
                System.out.println("you already hava an account with this email");
                System.out.println("do you want to try again? yes/no");
                String ch = scan.nextLine();

                if (!ch.equals("yes")) {
                    return null;
                }
            } else {
                user.setUsername(email);
                while (true) {
                    System.out.println("insert your password: ");
                    String password = scan.nextLine();
                    String passPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
                    if (!password.matches(passPattern)) {
                        System.out.println("your password should at least consist of eight characters," +
                                " one uppercase letter, one lowercase letter and one number");
                    } else {
                        System.out.println("re-enter your password");
                        if (password.equals(scan.nextLine())) {
                            user.setPassword(password);
                            System.out.println("you signed up successfully");
                            return user;
                        } else {
                            System.out.println("your entered passwords doesnt match");
                        }
                    }
                }
            }
        }
    }


    public static User logIn (NetflixService service){
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("username: ");
            String username = scan.nextLine();
            if (service.doesUsernameExist(username)) {
                System.out.println("password: ");
                String password = scan.nextLine();

                if (service.passwordCheck(username, password)) {
                    return service.searchUser(username);
                } else {
                    System.out.println("wrong password");

                    System.out.println("do you want to try again? yes/no");
                    String ch = scan.nextLine();

                    if (!ch.equals("yes")) {
                        return null;
                    }
                }
            } else {
                System.out.println("there is no such user with this email");
                System.out.println("do you want to try again? yes/no");
                String ch = scan.nextLine();

                if (!ch.equals("yes")) {
                    return null;
                }
            }
        }
    }

    //get information of a movie from user and returns a Movie
    public static Movie inputMovie () {
        Scanner scan = new Scanner(System.in);
        Movie movie = new Movie();

        ArrayList<String> cast = new ArrayList<String>();

        System.out.println("name: ");
        movie.setTitle(scan.nextLine());

        System.out.println("director: ");
        movie.setDirector(scan.nextLine());

        System.out.println("genre: ");
        movie.setGenre(scan.nextLine());

        System.out.println("release year: ");
        movie.setYear(scan.nextLine());

        System.out.println("length: ");
        movie.setLength(scan.nextLine());

        System.out.println("ratings: ");
        movie.setRating(scan.nextLine());

        System.out.println("cast (insert name and then press enter, if you're finished insert the word end");

        while (true) {
            String name = scan.nextLine();

            if (!name.equals("end")) {
                cast.add(name);
            } else {
                break;
            }
        }

        movie.setCast(cast);

        return movie;
    }

    //get information of a show from user and returns a TVShow
    public static TVShow inputShow () {
        Scanner scan = new Scanner(System.in);
        TVShow show = new TVShow();
        ArrayList<String> cast = new ArrayList<String>();

        System.out.println("name: ");
        show.setTitle(scan.nextLine());

        System.out.println("genre: ");
        show.setGenre(scan.nextLine());

        System.out.println("release year: ");
        show.setYear(scan.nextLine());

        System.out.println("ratings: ");
        show.setRating(scan.nextLine());

        System.out.println("cast: (insert name and then press enter, if you're finished insert the word end");

        while (true) {
            String name = scan.nextLine();

            if (!name.equals("end")) {
                cast.add(name);
            } else {
                break;
            }
        }

        show.setCast(cast);

        return show;
    }

    public static void viewAnArrayList (ArrayList list){
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i+1 + ". " + list.get(i));
        }
    }
}
