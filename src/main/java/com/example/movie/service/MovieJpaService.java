package com.example.movie.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
 import org.springframework.web.server.ResponseStatusException;
 import com.example.movie.repository.MovieJpaRepository;
 import com.example.movie.model.Movie;
 import com.example.movie.repository.MovieRepository;
 import java.util.*;
 @Service
public class MovieJpaService implements MovieRepository{
    @Autowired
private MovieJpaRepository movieJpaRepository;
@Override
public ArrayList<Movie>getMovies(){
    List<Movie>movieList=movieJpaRepository.findAll();
ArrayList<Movie>movies=new ArrayList<>(movieList);
return movies;

}

@Override
public Movie getMovieById(int MovieId) {
    try{
Movie movie=movieJpaRepository.findById(MovieId).get();
return movie;
    }
    catch(Exception e){
throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}

@Override
public Movie addMovie(Movie movie) {
    movieJpaRepository.save(movie);
    return movie;
}

@Override
public Movie updatedMovie(int MovieId, Movie movie) {
    try{
Movie newmovie=movieJpaRepository.findById(MovieId).get();
if(movie.getMovieName()!=null){
    newmovie.setMovieName(movie.getMovieName());
}
if(movie.getLeadActor()!=null){
    newmovie.setLeadActor(movie.getLeadActor());
}
movieJpaRepository.save(newmovie);
return newmovie;
    }catch(Exception e){
throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}

@Override
public void deleteMovie(int MovieId) {
    try{
movieJpaRepository.deleteById(MovieId);
    }catch(Exception e){
throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    
}
}

