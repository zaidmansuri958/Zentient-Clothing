package com.example.apnamall.presentation.di

import com.example.apnamall.data.repository.LikeRepositoryImpl
import com.example.apnamall.data.repository.datasource.LikeLocalDataSource
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
    fun provideLikeRepository(likeLocalDataSource: LikeLocalDataSource): LikeRepository {
        return LikeRepositoryImpl(likeLocalDataSource)
    }
}