package com.example.movieapp102.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.movieapp102.R
import com.example.movieapp102.databinding.ActivitySearchBinding
import com.example.movieapp102.model.Movie
import com.example.movieapp102.request.NetworkUtils
import com.example.movieapp102.response.MovieSearchResponse
import com.example.movieapp102.util.Credentials
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class SearchActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding : ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonSearchMovie.setOnClickListener(this)
        binding.buttonCancelSearchMovie.setOnClickListener(this)

    }

    override fun onClick(view: View) {

        if(view.id == R.id.button_cancel_search_movie){
            this.toMainActivity()
        }
//        if(view.id == R.id.button_search_movie){
//
//        }
    }

    private fun toMainActivity() {
        val toPage = Intent(this,MainActivity::class.java)
        startActivity(toPage)
    }
    private fun getRetrofit(query: String, callback: (List<Movie>)-> Unit)  {
        val movie = NetworkUtils.getMovie()
        val responseCall: Call<MovieSearchResponse> = movie.searchMovie(Credentials.API_KEY, query)
        responseCall.enqueue(object : Callback<MovieSearchResponse> {
            override fun onResponse(
                call: Call<MovieSearchResponse>,
                response: Response<MovieSearchResponse>
            ) {
                if (response.code() == 200) {
                    val movies: List<Movie> = ArrayList(response.body()!!.movies)
                    return callback(movies)
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