package com.example.movieapp102.model

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("adult")
    var adult: Boolean,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("budget")
    var budget: Int,
    @SerializedName("genres")
    var genresEntity: List<GenresEntity>,
    @SerializedName("homepage")
    val homepage: String,
    @SerializedName("id")
    var id: Int,
    @SerializedName("imdb_id")
    val imdbId: String,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("production_companies")
    var productionCompaniesEntity: List<ProductionCompaniesEntity>,
    @SerializedName("production_countries")
    var productionCountriesEntity: List<ProductionCountriesEntity>,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("revenue")
    var revenue: Int,
    @SerializedName("runtime")
    var runtime: Int,
    @SerializedName("spoken_languages")
    var spokenLanguagesEntity: List<SpokenLanguagesEntity>,
    @SerializedName("status")
    val status: String,
    @SerializedName("tagline")
    val tagline: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("video")
    var video: Boolean,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    var voteCount: Int
){
    data class SpokenLanguagesEntity(
        @SerializedName("iso_639_1")
        val iso6391: String,
        @SerializedName("name")
        val name: String
    )

    data class ProductionCountriesEntity(
        @SerializedName("iso_3166_1")
        val iso31661: String,
        @SerializedName("name")
        val name: String
    )

    data class ProductionCompaniesEntity(
        @SerializedName("id")
        var id: Int,
        @SerializedName("logo_path")
        val logoPath: String,
        @SerializedName("name")
        val name: String,
        @SerializedName("origin_country")
        val originCountry: String
    )

    data class GenresEntity(
        @SerializedName("id")
        var id: Int,
        @SerializedName("name")
        val name: String
    )
}

