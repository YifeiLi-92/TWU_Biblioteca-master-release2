package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Movies {
    private List<Movie> movies = new ArrayList<Movie>();

    public Movies() {}

    public List<Movie> getMovies() {
        return movies;
    }

    public String showList(){
        String result = "";
        for (Movie movie:this.movies
                ) {
            String name = movie.getName();
            String year = movie.getYear();
            String director = movie.getDirector();
            String movieRating = movie.getRating();
            result += name + "          " + year + "          " + director + "         " + movieRating + "\n";
        }
        return  result;
    }

    public  boolean removeMovie(Movie movie){
        return this.movies.remove(movie);
    }

    public boolean addMovie(Movie movie){
        return this.movies.add(movie);
    }
}
