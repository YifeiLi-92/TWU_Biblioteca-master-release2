package com.twu.biblioteca;

public class User {
    private String name;
    private String password;
    private Books allBooks;
    private Books borrowBooks;
    private Movies allMovies;
    private Movies borrowMovies;

    public User(String name, String password, Books allBooks, Books borrowBooks, Movies allMovies, Movies borrowMovies) {
        this.name = name;
        this.password = password;
        this.allBooks = allBooks;
        this.borrowBooks = borrowBooks;
        this.allMovies = allMovies;
        this.borrowMovies = borrowMovies;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Books getAllBooks() {
        return allBooks;
    }

    public Books getBorrowBooks() {
        return borrowBooks;
    }

    public Movies getAllMovies() {
        return allMovies;
    }

    public Movies getBorrowMovies() {
        return borrowMovies;
    }

    public boolean login(String name, String password){
        return name.equals(this.name) && password.equals(this.password);
    }

    public String checkOutBook(String bookName){
        String result = "";

        int out = 0;
        for (Book book: this.allBooks.getBooks()
                ) {
            String nameInList = book.getName();
            if(bookName.equals(nameInList)){
                this.allBooks.removeBook(book);
                this.borrowBooks.addBook(book);
                result = "Thank you! Enjoy the book.\n";
                out = 1;
                break;
            }
        }
        if(out ==  0)
            result = "That book is not available.\n";

        return result;
    }

    public String returnBook(String bookName){
        String result = "";

        int out = 0;
        for (Book book:this.borrowBooks.getBooks()
                ) {
            String nameInList = book.getName();
            if(bookName.equals(nameInList)){
                this.borrowBooks.removeBook(book);
                this.allBooks.addBook(book);
                result = "Thank you for returning the book.\n";
                out = 1;
                break;
            }
        }
        if(out == 0)
            result  = "That is not a valid book to return.\n";

        return result;
    }

    public String checkOutMovie(String movieName){
        String result = "";

        int out = 0;
        for (Movie movie:this.allMovies.getMovies()
                ) {
            String nameInList = movie.getName();
            if(movieName.equals(nameInList)) {
                this.allMovies.removeMovie(movie);
                this.borrowMovies.addMovie(movie);
                result = "Thank you! Enjoy the movie.\n";
                out = 1;
                break;
            }
        }
        if(out == 0)
            result = "That book is not available.\n";

        return result;
    }
}
