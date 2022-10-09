package com.example.movieapp102.util

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkUtils {
    //Singleton instance for network
    companion object {
        private const val path = "https://api.themoviedb.org/3/"

        fun getRetrofit() : Retrofit{
            return Retrofit.Builder()
                .baseUrl(path)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

    }
}