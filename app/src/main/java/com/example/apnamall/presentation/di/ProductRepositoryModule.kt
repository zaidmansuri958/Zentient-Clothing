package com.example.apnamall.presentation.di

import com.example.apnamall.data.repository.ProductRepositoryImpl
import com.example.apnamall.data.repository.datasource.ProductRemoteDataSource
import com.example.apnamall.domain.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ProductRepositoryModule {
    @Provides
    @Singleton
     fun provideProductRepository(productRemoteDataSource: ProductRemoteDataSource):ProductRepository{
        return ProductRepositoryImpl(productRemoteDataSource)
    }
}