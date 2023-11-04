package com.prueba.tecniva.data.remote

import com.prueba.tecniva.data.entities.detail.DetailsResponse
import com.prueba.tecniva.data.entities.movies.MoviesResponse
import com.prueba.tecniva.data.network.base.Result
import com.prueba.tecniva.data.network.base.BaseRemoteDataSource
import com.prueba.tecniva.data.service.MovieService
import javax.inject.Inject

class MoviesRemoteDataSourceImpl @Inject constructor(
    private val service: MovieService
): BaseRemoteDataSource(), MoviesRemoteDataSource {

    override suspend fun getMovies(page: Int): Result<MoviesResponse> = getResult {
        service.getMovies(page = page)
    }

    override suspend fun getMovieDetail(movieId: Int): Result<DetailsResponse>  = getResult {
        service.getMovieDetail(movieId = movieId)
    }

}