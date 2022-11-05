package com.example.movieapp102.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.movieapp102.R
import com.example.movieapp102.databinding.ActivityMainBinding
import com.example.movieapp102.request.NetworkUtils
import com.example.movieapp102.response.MovieSearchResponse
import com.example.movieapp102.util.Credentials
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonToSearch.setOnClickListener(this)
        binding.aperte.setOnClickListener(this)
    }


    override fun onClick(view: View) {
        if(view.id == R.id.button_search_movie)
            toSearchPage()
        if(view.id == R.id.aperte)
            getPopularMovies()
    }

    private fun toSearchPage(){
        val toPage = Intent(this,SearchActivity::class.java)
        startActivity(toPage)
    }

    private fun getPopularMovies(){
        val movieApi = NetworkUtils.getMovie()
        val responseCall = movieApi.getPopularMovies(Credentials.API_KEY)
        responseCall.enqueue(object : Callback<MovieSearchResponse>{
            override fun onResponse(
                call: Call<MovieSearchResponse>,
                response: Response<MovieSearchResponse>
            ) {
                if (response.code() == 200){
                    val popularMovieResponse = ArrayList(response.body()!!.movies)
                    Log.v("tag",popularMovieResponse.toString())


                }
            }
            override fun onFailure(call: Call<MovieSearchResponse>, t: Throwable) {
                println("Falha na requisição dos filmes populares : Erro " + t.message)
            }

        })
    }

    fun getFreeToWatchMovies(){

    }

    fun getLasTrailers(){

    }

}