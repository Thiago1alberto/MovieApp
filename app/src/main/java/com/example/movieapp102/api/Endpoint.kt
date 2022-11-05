package com.example.movieapp102.api

import com.example.movieapp102.response.MovieSearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Endpoint {

    @GET("search/movie")
    fun searchMovie(@Query("api_key") apiKey: String,@Query("query") query: String) : Call<MovieSearchResponse>

    @GET("movie/popular")
    fun getPopularMovies(@Query("api_key")apiKey: String): Call<MovieSearchResponse>
}