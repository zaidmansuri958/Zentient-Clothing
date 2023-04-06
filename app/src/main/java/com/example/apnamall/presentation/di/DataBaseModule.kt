package com.example.apnamall.presentation.di

import android.content.Context
import androidx.room.Room
import com.example.apnamall.data.db.LikeDao
import com.example.apnamall.data.db.LikeDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {

    @Provides
    @Singleton
    fun provideLikeDataBase(@ApplicationContext context: Context): LikeDataBase {
        return Room.databaseBuilder(context,LikeDataBase::class.java,"like_db").build()
    }

    @Provides
    @Singleton
    fun provideLikeDao(likeDataBase: LikeDataBase): LikeDao {
        return likeDataBase.likeDao()
    }
}