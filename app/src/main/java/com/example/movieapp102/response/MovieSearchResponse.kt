package com.example.movieapp102.response

import com.example.movieapp102.model.Movie
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MovieSearchResponse (
    @SerializedName("total_results")
    @Expose
    val totalCount:Int,
    @SerializedName("results")
    @Expose
    val movies:List<Movie>
)