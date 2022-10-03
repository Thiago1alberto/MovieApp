package com.example.movieapp102.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.movieapp102.R
import com.example.movieapp.api.Endpoint
import com.example.movieapp.model.User
import com.example.movieapp.util.NetworkUtils
import com.example.movieapp102.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), View.OnClickListener{

    private val basePath = "https://api.themoviedb.org/3"

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener(this)
    }


    override fun onClick(view: View) {
        if (view.id == R.id.login_button) {
            login(binding.login.text.toString(),binding.password.text.toString())
        }
    }

    private fun login(login: String, password: String) {
        val retrofitClient = NetworkUtils.getRetrofit(basePath)
        val endpoint = retrofitClient.create(Endpoint::class.java )
        val callback = endpoint.authenticate(login,password)
        callback.enqueue(object : Callback<User>{
            override fun onResponse(call: Call<User>, response: Response<User>) {
              Toast.makeText(baseContext,"Login efetuado com sucesso!!",Toast.LENGTH_LONG).show()
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }
}