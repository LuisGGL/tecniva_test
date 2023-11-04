package com.prueba.tecniva.data.entities.detail

import com.google.gson.annotations.SerializedName

data class Genres(
    @SerializedName("id"   ) val id   : Int?    = null,
    @SerializedName("name" ) val name : String? = null
)