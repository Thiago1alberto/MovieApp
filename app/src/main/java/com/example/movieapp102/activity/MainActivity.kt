package com.example.movieapp102.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.movieapp102.databinding.ActivityMainBinding
import com.example.movieapp102.model.Movie

class MainActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val popularMovieList = ArrayList<Movie>()
        val freeForWatchList = ArrayList<Movie>()
        val lastTrailersList = ArrayList<Movie>()



    }


    override fun onClick(view: View) {

    }

}