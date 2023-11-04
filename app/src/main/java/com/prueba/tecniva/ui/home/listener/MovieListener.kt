package com.prueba.tecniva.ui.home.listener

import com.prueba.tecniva.data.entities.movies.Results

interface MovieListener {
    fun onMovieClicked(movie: Results)
}