package com.example.apnamall.data.repository.datasource

import com.example.apnamall.data.model.like.LikeRequest
import com.example.apnamall.data.model.like.LikeResponse
import com.example.apnamall.data.model.like.LikeResponseItem
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface LikeLocalDataSource {

    fun getLike(): Flow<List<LikeRequest>>
    suspend fun insertLike(product: LikeRequest)
    suspend fun likedOrNot(productId:String):Boolean
    suspend fun removeLike(productId: String)
}