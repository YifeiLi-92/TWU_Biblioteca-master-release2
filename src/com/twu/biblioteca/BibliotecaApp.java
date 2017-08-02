package com.twu.biblioteca;

import java.util.*;

public class BibliotecaApp {
    static List<String> books = new ArrayList<String>() {{
        add("1,2,3");
        add("4,5,6");
    }};
    static List<String> appearBooks = new ArrayList<String>();


    public static void main(String[] args) {
        System.out.println("***************   Welcome to Biblioteca!   ***************");
        Scanner input = new Scanner(System.in);


        int flag = 0;
        while (true) {
            try {
                System.out.println("\n********************   Main Menu   ********************\nList Books(1)   Checkout Book(2)   Return book(3)   Quit(4)");

                int select = input.nextInt();
                switch (select) {
                    case 1:
                        System.out.printf("Name     Author     Year Published\n");
                        for (int i = 0; i < books.size(); i++) {
                            String name = books.get(i).split(",")[0];
                            String author = books.get(i).split(",")[1];
                            String year = books.get(i).split(",")[2];
                            System.out.printf(name + "          " + author + "          " + year + "          \n");
                        }
                        break;
                    case 2:
                        System.out.printf("Input the name of the book:\n");
                        String name = input.next();

                        int out = 0;
                        int i = 0;
                        for(i = 0;i < books.size();i++){
                            String nameInList = books.get(i).split(",")[0];
                            String checkoutBook = "";
                            if(name.equals(nameInList)){
                                checkoutBook = books.get(i);
                                books.remove(i);
                                appearBooks.add(checkoutBook);
                                System.out.printf("Thank you! Enjoy the book.\n");
                                out = 1;
                                break;
                            }
                        }
                        if(out == 0)
                            System.out.printf("That book is not available.\n");
                        break;
                    case 3:
                        out = 0;
                        System.out.printf("Input the name of the book:\n");
                        name = input.next();

                        i = 0;
                        for(i = 0;i < appearBooks.size();i++){
                            String nameInList = appearBooks.get(i).split(",")[0];
                            String returnBook = "";
                            if(name.equals(nameInList)){
                                returnBook = appearBooks.get(i);
                                appearBooks.remove(i);
                                books.add(returnBook);
                                System.out.printf("Thank you for returning the book.\n");
                                out = 1;
                                break;
                            }
                        }
                        if(out == 0)
                            System.out.printf("That is not a valid book to return.\n");
                        break;
                    case 4:
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
