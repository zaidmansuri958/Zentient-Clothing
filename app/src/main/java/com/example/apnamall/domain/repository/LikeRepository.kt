package com.example.apnamall.domain.repository

import com.example.apnamall.data.model.like.LikeRequest
import kotlinx.coroutines.flow.Flow

interface LikeRepository {
    fun getLike(): Flow<List<LikeRequest>>
    suspend fun like(product: LikeRequest)
    suspend fun likedOrNot(productId:String):Boolean

    suspend fun removeLike(productId: String)

}