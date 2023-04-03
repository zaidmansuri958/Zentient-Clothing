package com.example.apnamall.presentation.di

import com.example.apnamall.data.api.UserApiService
import com.example.apnamall.data.repository.datasource.CartRemoteDataSource
import com.example.apnamall.data.repository.datasource.OrderRemoteDataSource
import com.example.apnamall.data.repository.datasource_impl.CartRemoteDataSourceImpl
import com.example.apnamall.data.repository.datasource_impl.OrderRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class OrderRemoteDataSourceModule {

    @Provides
    @Singleton
    fun provideOrderRemoteDataSource(userApiService: UserApiService): OrderRemoteDataSource {
        return OrderRemoteDataSourceImpl(userApiService)
    }
}