package com.example.apnamall.presentation.di

import com.example.apnamall.data.api.ApiService
import com.example.apnamall.data.api.OrderApiService
import com.example.apnamall.data.util.AuthInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetModule {
    @Provides
    @Singleton
    fun provideRetrofitBuilder(): Retrofit.Builder {
        return Retrofit.Builder().baseUrl("https://rich-jade-agouti-wig.cyclic.app/")
            .addConverterFactory(GsonConverterFactory.create())
    }

    @Provides
    @Singleton
    fun provideInterceptor(authInterceptor: AuthInterceptor): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(authInterceptor).build()
    }

    @Provides
    @Singleton
    fun provideProductApiService(retrofitBuilder: Retrofit.Builder): ApiService {
        return retrofitBuilder.build().create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideOrderApiService(
        retrofitBuilder: Builder,
        okHttpClient: OkHttpClient
    ): OrderApiService {
        return retrofitBuilder.client(okHttpClient).build().create(OrderApiService::class.java)
    }

}