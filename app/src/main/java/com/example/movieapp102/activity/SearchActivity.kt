package com.example.movieapp102.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.movieapp102.R
import com.example.movieapp102.databinding.ActivitySearchBinding
import com.example.movieapp102.model.Movie
import com.example.movieapp102.request.NetworkUtils
import com.example.movieapp102.response.MovieSearchResponse
import com.example.movieapp102.util.Credentials
import com.example.movieapp102.viewmodel.MovieListViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class SearchActivity : AppCompatActivity(), View.OnClickListener {
	private lateinit var binding: ActivitySearchBinding
	private lateinit var movieListViewModel: MovieListViewModel
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivitySearchBinding.inflate(layoutInflater)
		setContentView(binding.root)


		//observerToAny()

		binding.buttonSearchMovie.setOnClickListener(this)
		binding.buttonCancelSearchMovie.setOnClickListener(this)

	}

	override fun onClick(view: View) {

		if (view.id == R.id.button_cancel_search_movie) {
			this.toMainActivity()
		}
		if (view.id == R.id.button_search_movie) {
			this.getMovieSearch(binding.textSearchMovie.text.toString())
		}
	}

	private fun toMainActivity() {
		val toPage = Intent(this, MainActivity::class.java)
		startActivity(toPage)
	}

//	private fun observerToAny() {
//		movieListViewModel.movies
//			.observe(this) {
//				if (it.isNotEmpty()) {
//					for (movie in it) {
//						Log.v("Tag", "Movie" + movie.title)
//					}
//				}
//			}
//	}

//	private fun searchMovieApi(query: String) {
//		movieListViewModel.searchMovieApi(query, 1)
//	}

	private fun getMovieSearch(query: String) {
		val movie = NetworkUtils.getMovie()
		val responseCall: Call<MovieSearchResponse> =
			movie.searchMovie(Credentials.API_KEY, query, 1)
		responseCall.enqueue(object : Callback<MovieSearchResponse> {
			override fun onResponse(
				call: Call<MovieSearchResponse>,
				response: Response<MovieSearchResponse>
			) {
				if (response.code() == 200) {
					val movies: List<Movie> = ArrayList(response.body()!!.movies)
					for (movie in movies) {
						Log.v("tag", "Movie name: ${movie.title}")
					}
				} else {
					try {
						Log.v("Tag", "Erro" + response.errorBody().toString())
					} catch (e: IOException) {
						e.printStackTrace()
					}
				}
			}

			override fun onFailure(call: Call<MovieSearchResponse>, t: Throwable) {
			}

		})
	}
}