package com.example.apnamall.presentation.di

import com.example.apnamall.data.db.LikeDao
import com.example.apnamall.data.repository.datasource.LikeLocalDataSource
import com.example.apnamall.data.repository.datasource_impl.LikeLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataSourceModule {
    @Provides
    @Singleton
     fun provideLocalDataSource(likeDao: LikeDao): LikeLocalDataSource {
        return LikeLocalDataSourceImpl(likeDao)
    }
}