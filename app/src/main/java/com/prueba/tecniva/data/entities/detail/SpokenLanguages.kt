package com.prueba.tecniva.data.entities.detail

import com.google.gson.annotations.SerializedName

data class SpokenLanguages (
    @SerializedName("english_name" ) val englishName : String? = null,
    @SerializedName("name"         ) val name        : String? = null
)