package com.example.apnamall.presentation.di

import com.example.apnamall.data.api.ApiService
import com.example.apnamall.data.repository.datasource.CategoryRemoteDataSource
import com.example.apnamall.data.repository.datasource.ProductRemoteDataSource
import com.example.apnamall.data.repository.datasource_impl.CategoryRemoteDataSourceImpl
import com.example.apnamall.data.repository.datasource_impl.ProductRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ProductRemoteDataSourceModule {

    @Provides
    @Singleton
     fun provideProductRemoteDataSource(apiService: ApiService): ProductRemoteDataSource {
        return ProductRemoteDataSourceImpl(apiService)
    }
}