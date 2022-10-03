package com.example.movieapp.api

import com.example.movieapp.model.User
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST

interface Endpoint {
    @FormUrlEncoded
    @Headers("Content-Type : application/x-www-form-urlencoded")
    @POST("/authentication/token/validate_with_login")
    fun authenticate(@Field("username") username: String
                    ,@Field("password") password: String): Call<User>
}