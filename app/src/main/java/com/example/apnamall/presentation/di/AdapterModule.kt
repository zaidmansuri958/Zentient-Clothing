package com.example.apnamall.presentation.di

import com.example.apnamall.presentation.adapter.*
import com.example.apnamall.presentation.adapter.home_screen.*
import com.example.apnamall.presentation.adapter.product.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.annotation.Signed
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AdapterModule {

    @Provides
    @Singleton
    fun provideBestSellerAdapter(): BestSellerAdapter {
        return BestSellerAdapter()
    }

    @Provides
    @Singleton
    fun provideMenTopAdapter(): MenTopItemsAdapter {
        return MenTopItemsAdapter()
    }

    @Provides
    @Singleton
    fun provideSliderAdapter(): ImageSliderAdapter {
        return ImageSliderAdapter()
    }

    @Provides
    @Singleton
    fun provideTopDiscountAdapter(): TopDiscountAdapter {
        return TopDiscountAdapter()
    }

    @Provides
    @Singleton
    fun provideWomenTopAdapter(): WomenTopItemsAdapter {
        return WomenTopItemsAdapter()
    }

    @Provides
    @Singleton
    fun provideCategoryAdapter(): CategoryAdapter {
        return CategoryAdapter()
    }

    @Provides
    @Singleton
    fun provideProductAdapter(): ProductAdapter {
        return ProductAdapter()
    }

    @Provides
    @Singleton
    fun provideCartAdapter(): CartAdapter {
        return CartAdapter()
    }

    @Provides
    @Singleton
    fun provideVideoAdapter(): VideoAdapter {
        return VideoAdapter()
    }

    @Provides
    @Singleton
    fun provideViewPagerAdapter(): ProductViewPagerAdapter {
        return ProductViewPagerAdapter()
    }
    @Provides
    @Singleton
    fun provideLikeAdapter(): LikeAdapter {
        return LikeAdapter()
    }


}