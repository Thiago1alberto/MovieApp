package com.example.movieapp102.api

import com.example.movieapp102.model.User
import com.example.movieapp102.response.MovieSearchResponse
import retrofit2.Call
import retrofit2.http.*

interface Endpoint {
    @FormUrlEncoded
    @Headers("Content-Type : application/x-www-form-urlencoded")
    @POST("authentication/token/validate_with_login")
    fun authenticate(@Field("username") username: String
                    ,@Field("password") password: String,@Query("api_key") apiKey: String): Call<User>

    @GET
    fun searchMovie(@Query("api_key") apiKey: String,@Query("query") query: String) : Call<MovieSearchResponse>
}