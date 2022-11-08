package com.example.movieapp102.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.movieapp102.model.Movie
import com.example.movieapp102.repository.MovieRepository

class MovieListViewModel : ViewModel() {

	private val movieRepository: MovieRepository = MovieRepository.getInstance()

	fun getMovies(): LiveData<List<Movie>> {
		return movieRepository.getMovies()
	}

	fun searchMovieApi(query: String) {
		movieRepository.searchMovie(query)
	}
}