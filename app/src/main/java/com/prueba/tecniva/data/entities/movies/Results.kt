package com.prueba.tecniva.data.entities.movies

import com.google.gson.annotations.SerializedName

data class Results(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("original_language")
    val originalLanguage : String? = null,
    @SerializedName("original_title")
    val originalTitle: String? = null,
    @SerializedName("overview")
    val overview: String? = null,
    @SerializedName("release_date")
    val releaseDate: String? = null,
    @SerializedName("poster_path")
    val posterPath: String? = null,
)
