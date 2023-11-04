package com.prueba.tecniva.domain.usecases

import com.prueba.tecniva.data.entities.movies.MoviesResponse
import com.prueba.tecniva.data.network.base.Result
import com.prueba.tecniva.data.repository.MoviesRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val repository: MoviesRepository,
    private val coroutineDispatcher: CoroutineDispatcher
) {
    suspend fun execute(param: Int): Result<MoviesResponse> {
        return try {
            withContext(coroutineDispatcher) {
                repository.getMovies(param)
            }
        } catch (e: Exception) {
            Result.Error(e)
        }

    }
}