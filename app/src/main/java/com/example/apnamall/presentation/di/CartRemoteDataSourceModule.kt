package com.example.apnamall.presentation.di

import com.example.apnamall.data.api.UserApiService
import com.example.apnamall.data.repository.datasource.CartRemoteDataSource
import com.example.apnamall.data.repository.datasource_impl.CartRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CartRemoteDataSourceModule {

    @Provides
    @Singleton
    fun provideCartRemoteDataSource(userApiService: UserApiService):CartRemoteDataSource{
        return CartRemoteDataSourceImpl(userApiService)
    }
}