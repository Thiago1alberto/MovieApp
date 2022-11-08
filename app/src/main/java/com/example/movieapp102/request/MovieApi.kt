package com.example.movieapp102.request

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movieapp102.AppExecutors
import com.example.movieapp102.model.Movie
import com.example.movieapp102.response.MovieSearchResponse
import com.example.movieapp102.util.Credentials
import retrofit2.Call
import java.io.IOException
import java.util.concurrent.TimeUnit

object MovieApi {

	private val movies: MutableLiveData<List<Movie>> = MutableLiveData()
	private val instance: MovieApi = getInstance()
	private lateinit var retrieveMoviesRunnable: RetrieveMoviesRunnable

	fun getInstance(): MovieApi {
		return instance
	}

	fun getMovies(): LiveData<List<Movie>> {
		return movies
	}

	fun searchMovieApi(query: String) {

		retrieveMoviesRunnable = RetrieveMoviesRunnable(query)
		val myHandler = AppExecutors.networkIO().submit(retrieveMoviesRunnable)

		AppExecutors.getInstance().networkIO().schedule({
			//cancelling retrofit call
			myHandler.cancel(true)
		}, 3000, TimeUnit.MICROSECONDS)


	}

	class RetrieveMoviesRunnable(
		private var query: String
	) : Runnable {
		private var cancelRequest: Boolean = false
		override fun run() {
			//Response object
			try {
				val response = this.getMovies(query).execute()
				if (cancelRequest) {
					return
				}
				if (response.code() == 200) {
					val movieList: List<Movie> = ArrayList(response.body()!!.movies)
					//Sending data to live data
					movies.postValue(movieList)

				} else {
					Log.v("Tag", "Error" + response.errorBody().toString())
				}
			} catch (e: IOException) {
				e.printStackTrace()
				movies.postValue(emptyList())
			}


		}

		//Search Movies
		private fun getMovies(query: String): Call<MovieSearchResponse> {
			return NetworkUtils.getMovie().searchMovie(Credentials.API_KEY, query)
		}

		private fun cancelRequest() {
			Log.v("Tag", "Cancel search request")
			cancelRequest = true
		}
	}
}