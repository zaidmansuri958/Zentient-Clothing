package com.example.apnamall.presentation.di

import com.example.apnamall.data.api.UserApiService
import com.example.apnamall.data.repository.datasource.LikeRemoteDataSource
import com.example.apnamall.data.repository.datasource_impl.LikeRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LikeRemoteDataSourceModule {

    @Provides
    @Singleton
    fun provideLikeRemoteDataSource(userApiService: UserApiService): LikeRemoteDataSource {
        return LikeRemoteDataSourceImpl(userApiService)
    }

}