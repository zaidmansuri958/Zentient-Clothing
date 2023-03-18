package com.example.apnamall.presentation.di

import com.example.apnamall.data.api.ApiService
import com.example.apnamall.data.repository.datasource.UserRemoteDataSource
import com.example.apnamall.data.repository.datasource_impl.UserRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UserRemoteDataSourceModule {
    @Provides
    @Singleton
    fun provideUserRemoteDataSource(apiService: ApiService): UserRemoteDataSource {
        return UserRemoteDataSourceImpl(apiService)
    }
}