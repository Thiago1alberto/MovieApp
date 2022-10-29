package com.example.movieapp102.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.movieapp102.R
import com.example.movieapp102.model.Movie
import com.example.movieapp102.request.NetworkUtils
import com.example.movieapp102.response.MovieSearchResponse
import com.example.movieapp102.util.Credentials
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
    }

    override fun onClick(view: View) {
        if(view.id == R.id.button_cancel_search_movie){
            toMainActivity()
        }else if(view.id == R.id.button_search_movie){

        }
    }

    private fun toMainActivity() {
        val toPage = Intent(this,MainActivity::class.java)
        startActivity(toPage)
    }
    private fun getRetrofit(query: String){
       val movie = NetworkUtils.getMovie()
       val responseCall : Call<MovieSearchResponse> = movie.searchMovie(Credentials.API_KEY,query)
        responseCall.enqueue(object : Callback<MovieSearchResponse>{
            override fun onResponse(
                call: Call<MovieSearchResponse>,
                response: Response<MovieSearchResponse>
            ) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<MovieSearchResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}