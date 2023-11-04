package com.prueba.tecniva.data.network.base

sealed class Result<out T> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val error: Exception) : Result<Nothing>()
}

val Result<*>.isSuccess
    get() = this is Result.Success

fun <T, R> Result<T>.map(transform: T.() -> R) =
    if (isSuccess) Result.Success(transform(getData())) else Result.Error(getError())

fun <T> Result<T>.onResult(onSuccess: (data: T) -> Unit, onError: (Exception) -> Unit) =
    when {
        isSuccess -> onSuccess(getData())
        else -> onError(getError())
    }

fun <T> Result<T>.getData() = (this as Result.Success).data

fun <T> Result<T>.getError() = (this as Result.Error).error