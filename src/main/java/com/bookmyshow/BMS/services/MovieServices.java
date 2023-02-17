package com.bookmyshow.BMS.services;

import com.bookmyshow.BMS.model.Movie;
import com.bookmyshow.BMS.model.Theatre;
import com.bookmyshow.BMS.model.User;

import java.util.List;

public interface MovieServices {
    Movie createMovie(Movie movie);
    Movie updateMovie(Movie movie);
    List<Movie> getAllMovie();
    Movie getMovieById(long id );
    void deleteMovie(long id);
}
