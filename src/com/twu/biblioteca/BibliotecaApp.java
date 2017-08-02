package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {
    static String[][] books = {{"1", "2", "3"}, {"4", "5", "6"}};

    public static void main(String[] args) {
        System.out.println("***************   Welcome to Biblioteca!   ***************");


        while (true) {
            try {
                System.out.println("\n********************   Main Menu   ********************\nList Books(1)   Checkout Book(2)   Return book(3)   Quit(4)");
                Scanner input = new Scanner(System.in);
                int select = input.nextInt();
                switch (select) {
                    case 1:
                        System.out.printf("Name     Author     Year Published\n");
                        for (int i = 0; i < books.length; i++) {
                            for (int j = 0; j < books[0].length; j++) {
                                System.out.printf(books[i][j] + "          ");
                            }
                            System.out.printf("\n");
                        }
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    default:
                        System.out.printf("Select a valid option!\n");
                }

            } catch (Exception e) {
                System.out.printf("Select a valid option!\n");
            }
        }
    }
}
