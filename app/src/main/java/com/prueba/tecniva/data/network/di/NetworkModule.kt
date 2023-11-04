package com.prueba.tecniva.data.network.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.prueba.tecniva.data.network.NetworkBuilder
import com.prueba.tecniva.data.network.NetworkBuilder.getOkHttpBuilder
import com.prueba.tecniva.data.network.NetworkBuilder.getRetrofitBuilder
import com.prueba.tecniva.data.service.MovieService
import com.prueba.tecniva.util.constants.Constants.BASE_URL
import okhttp3.Authenticator
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    private inline fun <reified T : Any> provideService(
        okHttpClient: OkHttpClient
    ): T =
        getRetrofitBuilder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()
            .create(T::class.java)

    @Singleton
    @Provides
    fun providesOkHttpClient(
        interceptor: Interceptor,
    ) = getOkHttpBuilder()
        .addInterceptor(interceptor)
        .addNetworkInterceptor(NetworkBuilder.loggingInterceptor())
        .build()

    @Singleton
    @Provides
    fun providesMoviesService(
        okHttpClient: OkHttpClient
    ) = provideService<MovieService>(okHttpClient)

}