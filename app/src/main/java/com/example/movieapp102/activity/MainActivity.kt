package com.example.movieapp102.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.movieapp102.R
import com.example.movieapp102.api.Endpoint
import com.example.movieapp102.model.User
import com.example.movieapp102.util.NetworkUtils
import com.example.movieapp102.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), View.OnClickListener{

    private val apiKey = "7b03b26cbdc121320895102838a4e80e"
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }


    override fun onClick(view: View) {

    }

}