package com.prueba.tecniva.data.network.base


abstract class BaseRemoteDataSource {
    protected suspend fun <Out> getResult(
        call: suspend () -> Out
    ): Result<Out> = try {
        Result.Success(call())
    } catch (e: Exception) {
        Result.Error(e)
    }
}