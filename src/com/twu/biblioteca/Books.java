package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Books {
    private List<Book> books = new ArrayList<Book>();

    public Books(){}

    public List<Book> getBooks() {
        return books;
    }

    public String showList(){
        String result = "";
        for (Book book:this.books
                ) {
            String name = book.getName();
            String author = book.getAuthor();
            String year = book.getYear();
            result += name + "          " + author + "          " + year + "\n";
        }
        return result;
    }

    public boolean removeBook(Book book){
        return this.books.remove(book);
    }

    public boolean addBook(Book book){
        return this.books.add(book);
    }
}
