package com.prueba.tecniva.data.entities.detail

import com.google.gson.annotations.SerializedName

data class DetailsResponse(
    @SerializedName("adult"                 ) val adult               : Boolean?                       = null,
    @SerializedName("genres"                ) val genres              : ArrayList<Genres>              = arrayListOf(),
    @SerializedName("homepage"              ) val homepage            : String?                        = null,
    @SerializedName("id"                    ) val id                  : Int?                           = null,
    @SerializedName("original_title"        ) val originalTitle       : String?                        = null,
    @SerializedName("overview"              ) val overview            : String?                        = null,
    @SerializedName("poster_path"           ) val posterPath          : String?                        = null,
    @SerializedName("release_date"          ) val releaseDate         : String?                        = null,
    @SerializedName("spoken_languages"      ) val spokenLanguages     : ArrayList<SpokenLanguages>     = arrayListOf()
)