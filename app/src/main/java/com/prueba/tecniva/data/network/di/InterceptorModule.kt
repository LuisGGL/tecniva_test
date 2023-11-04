package com.prueba.tecniva.data.network.di

import com.prueba.tecniva.data.network.interceptor.TecnivaInterceptor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor

@Module
@InstallIn(SingletonComponent::class)
abstract class InterceptorModule {
    @Binds
    abstract fun bindTecnivaInterceptor(interceptor: TecnivaInterceptor): Interceptor
}