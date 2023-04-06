package com.example.apnamall.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.apnamall.data.model.like.LikeRequest

@Database(entities = [LikeRequest::class], version = 1, exportSchema = false)
abstract class LikeDataBase : RoomDatabase() {
    abstract fun likeDao(): LikeDao
}