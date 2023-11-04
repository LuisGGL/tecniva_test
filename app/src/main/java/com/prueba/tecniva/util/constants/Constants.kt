package com.prueba.tecniva.util.constants

object Constants {
    const val EMPTY_STRING = ""

    const val HEADER_AUTHORIZATION = "Authorization"
    const val BEARER = "Bearer"
    const val TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJjYmQxZWU2Y2FlNjNiNWE0N2RhMDdiM2QzZjZiZGY4OCIsInN1YiI6IjY1NDUxYzk4NDFhNTYxMzM2ODgyZWE3ZiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.IYPAbh25SNzp7AW-FBUtH5Czk8tML1-N_xltCeiai6w"
    const val BASE_URL = "https://api.themoviedb.org/"
    const val BASE_IMAGE = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/"

    const val TIMEOUT = 60L
}

fun emptyString() = Constants.EMPTY_STRING