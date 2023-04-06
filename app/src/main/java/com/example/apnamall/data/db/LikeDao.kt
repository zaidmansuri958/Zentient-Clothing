package com.example.apnamall.data.db

import androidx.room.*
import com.example.apnamall.data.model.like.LikeRequest
import kotlinx.coroutines.flow.Flow

@Dao
interface LikeDao {
    @Query("SELECT * FROM likesTable")
    fun getLikes(): Flow<List<LikeRequest>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLike(likeRequest: LikeRequest)

    @Query("SELECT EXISTS(SELECT * FROM likesTable Where _id =:productId)")
    suspend fun likedOrNot(productId:String):Boolean

    @Query("DELETE FROM likesTable Where _id=:productId")
    suspend fun removeLike(productId: String)

}