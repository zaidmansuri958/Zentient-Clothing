package com.example.apnamall.presentation.di

import com.example.apnamall.data.repository.LikeRepositoryImpl
import com.example.apnamall.data.repository.datasource.LikeRemoteDataSource
import com.example.apnamall.domain.repository.LikeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class LikeRepositoryModule {
    @Provides
    @Singleton
    fun provideLikeRepository(likeRemoteDataSource: LikeRemoteDataSource): LikeRepository {
        return LikeRepositoryImpl(likeRemoteDataSource)
    }
}