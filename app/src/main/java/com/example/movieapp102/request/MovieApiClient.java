package com.example.movieapp102.request;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.movieapp102.AppExecutors;
import com.example.movieapp102.model.Movie;
import com.example.movieapp102.response.MovieSearchResponse;
import com.example.movieapp102.util.Credentials;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Response;

public class MovieApiClient {
    private MutableLiveData<List<Movie>> movies;
    private static MovieApiClient instance;
    private RetrieveMoviesRunnable retrieveMoviesRunnable;

    public static MovieApiClient getInstance() {
        if (instance != null) {
            instance = new MovieApiClient();
        }
        return instance;
    }

    private MovieApiClient() {
        this.movies = new MutableLiveData<>();
    }


    public LiveData<List<Movie>> getMovies() {
        return movies;
    }

    public void searchMovieApi(String query, int page) {
        if (retrieveMoviesRunnable != null) {
            retrieveMoviesRunnable = null;
        }
        retrieveMoviesRunnable = new RetrieveMoviesRunnable(query,page);

        final Future myHandler = AppExecutors.getInstance().networkIO()
                .submit(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
        AppExecutors.getInstance().networkIO().schedule(new Runnable() {
            @Override
            public void run() {
                myHandler.cancel(true);
            }
        }, 5000, TimeUnit.MILLISECONDS);


    }

    private class RetrieveMoviesRunnable implements Runnable {

        private String query;
        private int page;
        private Boolean cancelRequest;

        public RetrieveMoviesRunnable(String query, int page) {
            this.query = query;
            this.page = page;
            this.cancelRequest = false;
        }

        @Override
        public void run() {

            try {
                Response<MovieSearchResponse> response = getMovies(query,page).execute();
                if (cancelRequest) {
                    return;
                }
                if (response.code() == 200) {
                    List<Movie> list = new ArrayList<>(((MovieSearchResponse) response.body()).getMovies());
                    movies.postValue(list);
                } else {
                    Log.v("Tag", "Error: " + response.errorBody().toString());
                    movies.postValue(null);
                }
            } catch (IOException e) {
                e.printStackTrace();
                movies.postValue(null);
            }


        }

        private Call<MovieSearchResponse> getMovies(String query, int page){
            return NetworkUtils.Companion.getMovie()
                    .searchMovie(Credentials.API_KEY, query,page);
        }

        private void cancelRequest() {
            Log.v("Tag", "Canceling request");
            cancelRequest = true;
        }
    }
}


