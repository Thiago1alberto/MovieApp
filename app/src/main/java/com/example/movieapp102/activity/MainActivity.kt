package com.example.movieapp102.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.movieapp102.R
import com.example.movieapp102.databinding.ActivityMainBinding
import com.example.movieapp102.model.Movie
import com.example.movieapp102.request.NetworkUtils
import com.example.movieapp102.response.MovieSearchResponse
import com.example.movieapp102.util.Credentials
import com.example.movieapp102.viewmodel.MovieListViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), View.OnClickListener {

	private lateinit var binding: ActivityMainBinding
	private lateinit var movieListViewModel: MovieListViewModel

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)



		binding.buttonToSearch.setOnClickListener(this)
		binding.aperte.setOnClickListener(this)

	}


	override fun onClick(view: View) {
		if (view.id == R.id.button_to_search)
			toSearchPage()
		if(view.id == R.id.aperte) {
			getPopularMovies()

		}
	}



	private fun toSearchPage() {
		val toPage = Intent(this, SearchActivity::class.java)
		startActivity(toPage)
	}

//	private fun ObserverToAny(){
//		movieListViewModel.movies.observe(this,object:Observer<List<Movie>> {
//			override fun onChanged(t: List<Movie>?) {
//                if(t != null){
//	               for (movie in t){
//					   Log.v("Tag","onChanged " + movie.title)
//	               }
//                }
//			}
//		})
//	}



	private fun getPopularMovies() {
		val movieApi = NetworkUtils.getMovie()
		val responseCall = movieApi.getPopularMovies(Credentials.API_KEY)
		responseCall.enqueue(object : Callback<MovieSearchResponse> {
			override fun onResponse(
				call: Call<MovieSearchResponse>,
				response: Response<MovieSearchResponse>
			) {
				if (response.code() == 200) {
					val popularMovieResponse = ArrayList(response.body()!!.movies)
					Log.v("tag", popularMovieResponse.toString())
				} else {
					Log.v("Tag", "Error" + response.errorBody().toString())
				}
			}

			override fun onFailure(call: Call<MovieSearchResponse>, t: Throwable) {
				println("Falha na requisição dos filmes populares : Erro " + t.message)
			}

		})
	}


}