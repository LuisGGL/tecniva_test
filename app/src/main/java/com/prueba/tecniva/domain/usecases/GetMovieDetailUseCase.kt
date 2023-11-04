package com.prueba.tecniva.domain.usecases

import com.prueba.tecniva.data.entities.detail.DetailsResponse
import com.prueba.tecniva.data.network.base.Result
import com.prueba.tecniva.data.repository.MoviesRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(
    private val repository: MoviesRepository,
    private val coroutineDispatcher: CoroutineDispatcher
) {
    suspend fun execute(param: Int): Result<DetailsResponse> {
        return try {
            withContext(coroutineDispatcher) {
                repository.getMovieDetail(param)
            }
        } catch (e: Exception) {
            Result.Error(e)
        }

    }
}