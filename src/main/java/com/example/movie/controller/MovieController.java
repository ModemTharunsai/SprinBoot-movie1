package com.example.movie.controller;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.movie.model.Movie;
import com.example.movie.service.MovieJpaService;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class MovieController {
    @Autowired
    public MovieJpaService movieService;

    @GetMapping("/movies")
    public ArrayList<Movie> getMovies() {
        return movieService.getMovies();
    }

    @GetMapping("/movies/{movieId}")
    public Movie getMovieById(@PathVariable("movieId") int movieId) {
        return movieService.getMovieById(movieId);
    }

    @PostMapping("/movies")
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);

    }
    
    @PutMapping("/movies/{movieId}")
    public Movie updatedMovie(@PathVariable("movieId") int movieId, @RequestBody Movie movie) {
        return movieService.updatedMovie(movieId,movie);
    }
    
    @DeleteMapping("/movies/{movieId}")
    public void deleteSong(@PathVariable("movieId") int movieId) {
        movieService.deleteMovie(movieId);
    }
}
