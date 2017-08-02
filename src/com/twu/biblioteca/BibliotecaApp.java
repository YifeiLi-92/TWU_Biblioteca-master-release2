package com.twu.biblioteca;

import java.util.*;

public class BibliotecaApp {
    private static List<String> books = new ArrayList<String>() {{
        add("1,2,3");
        add("4,5,6");
    }};
    private static List<String> appearBooks = new ArrayList<String>();

    private static List<String> movies = new ArrayList<String>(){{
        add("1,2,3,4");
        add("5,6,7,8");
    }};
    private static List<String> appearMovies = new ArrayList<String>();

    private static String userName = "l";
    private static String password = "123456";

    public static void main(String[] args) {
        System.out.println("***************   Welcome to Biblioteca!   ***************");
        Scanner input = new Scanner(System.in);


        int flag = 0;
        int i = 0;
        while (true) {
            try {
                System.out.println("\n********************   Main Menu   ********************\nList Books(1)   Check-out Book(2)   Return book(3)   " +
                        "\nList Movies(4)     Check-out Movies(5)     Quit(6)");

                int select = input.nextInt();
                switch (select) {
                    case 1:
                        System.out.printf("Name     Author     Year Published\n");
                        i = 0;
                        for (String book:books
                             ) {
                            String name = book.split(",")[0];
                            String author = book.split(",")[1];
                            String year = book.split(",")[2];
                            System.out.printf(name + "          " + author + "          " + year + "\n");
                            i++;
                        }
                        break;
                    case 2:
                        System.out.printf("Login\nName:");
                        String userN = input.next();
                        System.out.printf("Password:");
                        String pwd = input.next();
                        if(!userName.equals(userN) || !password.equals(pwd)) {
                            System.out.printf("Wrong Account!\n");
                            break;
                        }

                        System.out.printf("Input the name of the book:\n");
                        String name = input.next();

                        int out = 0;
                        for (String book: books
                             ) {
                            String nameInList = book.split(",")[0];
                            if(name.equals(nameInList)){
                                books.remove(book);
                                appearBooks.add(book);
                                System.out.printf("Thank you! Enjoy the book.\n");
                                out = 1;
                                break;
                            }
                        }
                        if(out == 0)
                            System.out.printf("That book is not available.\n");
                        break;
                    case 3:
                        System.out.printf("Login\nName:");
                        userN = input.next();
                        System.out.printf("Password:");
                        pwd = input.next();
                        if(!userName.equals(userN) || !password.equals(pwd)) {
                            System.out.printf("Wrong Account!\n");
                            break;
                        }

                        out = 0;
                        System.out.printf("Input the name of the book:\n");
                        name = input.next();

                        for (String appearBook:appearBooks
                             ) {
                            String nameInList = appearBook.split(",")[0];
                            if(name.equals(nameInList)){
                                appearBooks.remove(appearBook);
                                books.add(appearBook);
                                System.out.printf("Thank you for returning the book.\n");
                                out = 1;
                                break;
                            }
                        }
                        if(out == 0)
                            System.out.printf("That is not a valid book to return.\n");
                        break;
                    case 4:
                        System.out.printf("Name     Year     Director     Movie Rating\n");
                        for (String movie:movies
                             ) {
                            name = movie.split(",")[0];
                            String year = movie.split(",")[1];
                            String director = movie.split(",")[2];
                            String movieRating = movie.split(",")[3];
                            System.out.printf(name + "          " + year + "          " + director + "         " + movieRating + "\n");
                        }
                        break;
                    case 5:
                        System.out.printf("Input the name of the movie:\n");
                        name = input.next();

                        out = 0;
                        for (String movie:movies
                             ) {
                            String nameInList = movie.split(",")[0];
                            if(name.equals(nameInList)) {
                                movies.remove(movie);
                                appearBooks.add(movie);
                                System.out.printf("Thank you! Enjoy the movie.\n");
                                out = 1;
                                break;
                            }
                        }
                        if(out == 0)
                            System.out.printf("That book is not available.\n");
                        break;
                    case 6:
                        flag = 1;
                        break;
                    default:
                        System.out.printf("Select a valid option!\n");
                }

            } catch (Exception e) {
                System.out.printf("Select a valid option!\n");
            }
            if (flag == 1)
                break;
        }
    }
}
