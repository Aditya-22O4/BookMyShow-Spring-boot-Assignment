package com.bookmyshow.BMS.services;

import com.bookmyshow.BMS.model.Movie;
import com.bookmyshow.BMS.model.Theatre;
import com.bookmyshow.BMS.repository.MovieRepository;
import com.bookmyshow.BMS.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MovieServicesImp implements MovieServices{

    @Autowired
    private MovieRepository movieRepository;


    @Override
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie updateMovie(Movie movie) {
        Optional<Movie> movieObj = this.movieRepository.findById(movie.getMovieId());
        if(movieObj.isPresent()){
            Movie  movieUpdate = movieObj.get();
            movieUpdate.setMovieId(movie.getMovieId());
            movieUpdate.setMoviename(movie.getMoviename());
            movieUpdate.setDescription(movie.getDescription());
            return this.movieRepository.save(movieUpdate);
        }else {
            throw new RuntimeException("No Theater found with + " + movie.getMovieId());
        }
    }

    @Override
    public List<Movie> getAllMovie() {
        return this.movieRepository.findAll();
    }

    @Override
    public  Movie getMovieById(long movieid) {
        Optional<Movie> movieObj = this.movieRepository.findById(movieid);
        if(movieObj.isPresent()){
            return movieObj.get();
        }
        else {
            throw new RuntimeException("No movie found with id " + movieid);
        }
    }

    @Override
    public void deleteMovie(long movieid) {
        Optional<Movie> movieObj = this.movieRepository.findById(movieid);
        if(movieObj.isPresent()){
            movieRepository.delete(getMovieById(movieid));
        }
        else {
            throw new RuntimeException("No movie  found with id " + movieid);
        }
    }
}