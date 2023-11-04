package com.prueba.tecniva.ui.home.epoxycontroller

import android.view.View
import com.airbnb.epoxy.EpoxyController
import com.prueba.tecniva.data.entities.movies.Results
import com.prueba.tecniva.itemMovie
import com.prueba.tecniva.ui.home.listener.MovieListener

class MovieController(
    private val listener: MovieListener
): EpoxyController() {
    var movies: List<Results> = emptyList()
        set(value) {
            field = value
            requestModelBuild()
        }

    override fun buildModels() {
        movies.forEach { movie ->
            itemMovie {
                id(movie.id)
                movie(movie)
                onClick { _: View ->
                    listener.onMovieClicked(movie)
                }
            }
        }
    }


}