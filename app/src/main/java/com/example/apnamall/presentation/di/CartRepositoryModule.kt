package com.example.apnamall.presentation.di

import com.example.apnamall.data.repository.CartRepositoryImpl
import com.example.apnamall.data.repository.datasource.CartRemoteDataSource
import com.example.apnamall.domain.repository.CartRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CartRepositoryModule {
    @Provides
    @Singleton
    fun provideOrderRepository(orderRemoteDataSource: CartRemoteDataSource):CartRepository{
        return CartRepositoryImpl(orderRemoteDataSource)
    }
}