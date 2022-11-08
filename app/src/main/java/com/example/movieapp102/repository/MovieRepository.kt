package com.example.movieapp102.repository

import androidx.lifecycle.LiveData
import com.example.movieapp102.model.Movie
import com.example.movieapp102.request.MovieApi

object MovieRepository {

	private var instance: MovieRepository = getInstance()

	private val movieApi: MovieApi = MovieApi.getInstance()

	fun getInstance(): MovieRepository {
		return instance
	}

	fun getMovies(): LiveData<List<Movie>> {
		return movieApi.getMovies()
	}

	fun searchMovie(query : String){
		movieApi.searchMovieApi(query)
	}

}