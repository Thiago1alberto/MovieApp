package com.example.movieapp102.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.movieapp102.R
import com.example.movieapp102.databinding.ActivityMainBinding
import com.example.movieapp102.model.Movie

class MainActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }


    override fun onClick(view: View) {
        if(view.id == R.id.button_search_movie){
        	toSearchPage()
        }
    }

    private fun toSearchPage(){
        val toPage = Intent(this,SearchActivity::class.java)
        startActivity(toPage)
    }

}