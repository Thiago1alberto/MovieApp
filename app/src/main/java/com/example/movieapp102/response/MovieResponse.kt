package com.example.movieapp102.response

import com.example.movieapp102.model.Movie
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("results")
    @Expose
    val movie: Movie
) {
    override fun toString(): String {
        return "MovieResponse(movie=$movie)"
    }
}