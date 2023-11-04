package com.prueba.tecniva.data.repository

import com.prueba.tecniva.data.entities.detail.DetailsResponse
import com.prueba.tecniva.data.entities.movies.MoviesResponse
import com.prueba.tecniva.data.network.base.Result
import com.prueba.tecniva.data.remote.MoviesRemoteDataSource
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val remoteDataSource: MoviesRemoteDataSource,
): MoviesRepository {

    override suspend fun getMovies(page: Int): Result<MoviesResponse> =
        remoteDataSource.getMovies(page)

    override suspend fun getMovieDetail(movieId: Int): Result<DetailsResponse> =
        remoteDataSource.getMovieDetail(movieId)

}