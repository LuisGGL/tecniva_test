package com.prueba.tecniva.data.remote

import com.prueba.tecniva.data.entities.detail.DetailsResponse
import com.prueba.tecniva.data.entities.movies.MoviesResponse
import com.prueba.tecniva.data.network.base.Result

interface MoviesRemoteDataSource {

    suspend fun getMovies(page: Int): Result<MoviesResponse>
    suspend fun getMovieDetail(movieId: Int): Result<DetailsResponse>

}