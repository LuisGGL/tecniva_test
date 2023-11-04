package com.prueba.tecniva.data.di

import com.prueba.tecniva.data.remote.MoviesRemoteDataSource
import com.prueba.tecniva.data.remote.MoviesRemoteDataSourceImpl
import com.prueba.tecniva.data.repository.MoviesRepository
import com.prueba.tecniva.data.repository.MoviesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MoviesDataModule {

    @Binds
    abstract fun bindProductsDataSource(repository: MoviesRepositoryImpl): MoviesRepository

    @Binds
    abstract fun bindProductsRemote(repository: MoviesRemoteDataSourceImpl): MoviesRemoteDataSource

}