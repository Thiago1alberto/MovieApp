package com.example.movieapp102.repository;

import androidx.lifecycle.LiveData;

import com.example.movieapp102.model.Movie;
import com.example.movieapp102.request.MovieApiClient;

import java.util.List;

public class MovieRepository {

    private static MovieRepository instance;

    private final MovieApiClient movieApiClient;


    public static MovieRepository getInstance() {
        if (instance == null) {
            instance = new MovieRepository();

        }
        return instance;
    }

    private MovieRepository() {
        movieApiClient = MovieApiClient.getInstance();
    }

    public LiveData<List<Movie>> getMovies() {
        return movieApiClient.getMovies();
    }

    public void searchMovieApi(String query,int page) { movieApiClient.searchMovieApi(query,page);}

}