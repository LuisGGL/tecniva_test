package com.prueba.tecniva.data.network

import com.google.gson.GsonBuilder
import com.prueba.tecniva.util.constants.Constants.TIMEOUT
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetworkBuilder {

    fun getRetrofitBuilder() = Retrofit.Builder().addConverterFactory(
        GsonConverterFactory.create(
            GsonBuilder()
                .create()
        )
    )

    fun getOkHttpBuilder() = OkHttpClient.Builder().apply {
        connectTimeout(TIMEOUT, TimeUnit.SECONDS)
        readTimeout(TIMEOUT, TimeUnit.SECONDS)
        writeTimeout(TIMEOUT, TimeUnit.SECONDS)
    }

    fun loggingInterceptor(): Interceptor =
        run {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.apply {
                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            }
        }

}