package com.example.apnamall.presentation.di

import com.example.apnamall.data.repository.UserRepositoryImpl
import com.example.apnamall.data.repository.datasource.UserRemoteDataSource
import com.example.apnamall.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UserRepositoryModule {

    @Provides
    @Singleton
    fun provideUserRepository(userRemoteDataSource: UserRemoteDataSource):UserRepository{
        return UserRepositoryImpl(userRemoteDataSource)
    }


}