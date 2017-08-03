package com.twu.biblioteca;

import java.util.*;

public class BibliotecaApp {
    public static void main(String[] args) {
        Books books = new Books();
        books.addBook(new Book("1","2","3"));
        books.addBook(new Book("4","5","6"));
        Books borrowBooks = new Books();

        Movies movies = new Movies();
        movies.addMovie(new Movie("1","2","3","4"));
        movies.addMovie(new Movie("5","6","7","8"));
        Movies borrowMovies = new Movies();

        User user = new User("lyf","123456",books,borrowBooks,movies,borrowMovies);


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
                        System.out.printf(user.getAllBooks().showList());
                        break;
                    case 2:
                        System.out.printf("Login\nName:");
                        String userN = input.next();
                        System.out.printf("Password:");
                        String pwd = input.next();
                        if(!user.login(userN,pwd)) {
                            System.out.printf("Wrong Account!\n");
                            break;
                        }

                        System.out.printf("Input the name of the book:\n");
                        String name = input.next();

                        System.out.printf(user.checkOutBook(name));
                        break;
                    case 3:
                        System.out.printf("Login\nName:");
                        userN = input.next();
                        System.out.printf("Password:");
                        pwd = input.next();
                        if(!user.login(userN,pwd)) {
                            System.out.printf("Wrong Account!\n");
                            break;
                        }

                        System.out.printf("Input the name of the book:\n");
                        name = input.next();

                        System.out.printf(user.returnBook(name));

                        break;
                    case 4:
                        System.out.printf("Name     Year     Director     Movie Rating\n");
                        System.out.printf(user.getAllMovies().showList());
                        break;
                    case 5:
                        System.out.printf("Input the name of the movie:\n");
                        name = input.next();
                        System.out.printf(user.checkOutMovie(name));
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
