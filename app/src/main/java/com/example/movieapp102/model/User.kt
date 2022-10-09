package com.example.movieapp102.model

import com.google.gson.annotations.SerializedName

data class User (

    @SerializedName("avatar")
    var avatar: AvatarEntity,
    @SerializedName("id")
    var id: Int,
    @SerializedName("iso_639_1")
    val iso6391: String,
    @SerializedName("iso_3166_1")
    val iso31661: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("include_adult")
    var includeAdult: Boolean,
    @SerializedName("username")
    val username: String
){
    data class AvatarEntity(
        @SerializedName("gravatar")
        var gravatar: GravatarEntity
    )

    data class GravatarEntity(
        @SerializedName("hash")
        val hash: String
    )
}

