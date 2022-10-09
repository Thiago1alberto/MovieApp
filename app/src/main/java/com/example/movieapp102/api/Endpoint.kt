package com.example.movieapp102.api

import com.example.movieapp102.model.User
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface Endpoint {
    @FormUrlEncoded
    @Headers("Content-Type : application/x-www-form-urlencoded")
    @POST("authentication/token/validate_with_login")
    fun authenticate(@Field("username") username: String
                    ,@Field("password") password: String,@Query("api_key") apiKey: String): Call<User>
}