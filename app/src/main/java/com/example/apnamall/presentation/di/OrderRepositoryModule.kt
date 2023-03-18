package com.example.apnamall.presentation.di

import com.example.apnamall.data.repository.OrderRepositoryImpl
import com.example.apnamall.data.repository.datasource.OrderRemoteDataSource
import com.example.apnamall.domain.repository.OrderRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class OrderRepositoryModule {
    @Provides
    @Singleton
    fun provideOrderRepository(orderRemoteDataSource: OrderRemoteDataSource):OrderRepository{
        return OrderRepositoryImpl(orderRemoteDataSource)
    }
}