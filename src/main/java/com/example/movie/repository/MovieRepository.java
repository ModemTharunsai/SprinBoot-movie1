package com.example.movie.repository;
import com.example.movie.model.Movie;

import java.util.ArrayList;

public interface MovieRepository {
    ArrayList<Movie>getMovies();

    Movie getMovieById(int MovieId);
    Movie addMovie(Movie movie);
    Movie updatedMovie(int MovieId,Movie movie);
    void deleteMovie(int MovieId);

}
