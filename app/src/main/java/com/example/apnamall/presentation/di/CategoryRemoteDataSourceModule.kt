package com.example.apnamall.presentation.di

import com.example.apnamall.data.api.ApiService
import com.example.apnamall.data.repository.datasource.CategoryRemoteDataSource
import com.example.apnamall.data.repository.datasource_impl.CategoryRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CategoryRemoteDataSourceModule {
    @Provides
    @Singleton
    fun provideCategoryRemoteDataSource(apiService: ApiService): CategoryRemoteDataSource {
        return CategoryRemoteDataSourceImpl(apiService)
    }
}