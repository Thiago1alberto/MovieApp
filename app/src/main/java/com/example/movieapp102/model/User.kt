package com.example.movieapp.model

import com.google.gson.annotations.SerializedName

class User (
    @SerializedName("avatar")
    var avatar: Any,
    @SerializedName("username")
    var username: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("id")
    var id : Int,
    @SerializedName("include_adult")
    var adult: Boolean,
    @SerializedName("iso_3166_1")
    var country: String,
    @SerializedName("iso_3166_1")
    var language: String
)