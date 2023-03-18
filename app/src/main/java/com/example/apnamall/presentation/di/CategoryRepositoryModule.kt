package com.example.apnamall.presentation.di

import com.example.apnamall.data.repository.CategoryRepositoryImpl
import com.example.apnamall.data.repository.datasource.CategoryRemoteDataSource
import com.example.apnamall.domain.repository.CategoryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CategoryRepositoryModule {

    @Provides
    @Singleton
    fun provideCategoryRepository(categoryRemoteDataSource: CategoryRemoteDataSource): CategoryRepository {
        return CategoryRepositoryImpl(categoryRemoteDataSource)
    }
}