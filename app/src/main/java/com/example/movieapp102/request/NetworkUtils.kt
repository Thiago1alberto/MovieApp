package com.example.movieapp102.request

import com.example.movieapp102.api.Endpoint
import com.example.movieapp102.util.Credentials
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class NetworkUtils {
    //Singleton instance for network
    companion object {

        private fun getRetrofit() : Retrofit{
            return Retrofit.Builder()
                .baseUrl(Credentials.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        private val endPoint = getRetrofit().create(Endpoint::class.java)

        public fun getMovie(): Endpoint{
            return endPoint
        }
    }
}