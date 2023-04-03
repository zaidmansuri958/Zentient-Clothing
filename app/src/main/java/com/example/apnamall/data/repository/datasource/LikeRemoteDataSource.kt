package com.example.apnamall.data.repository.datasource

import com.example.apnamall.data.model.like.LikeRequest
import com.example.apnamall.data.model.like.LikeResponse
import com.example.apnamall.data.model.like.LikeResponseItem
import retrofit2.Response

interface LikeRemoteDataSource {
    suspend fun getLike(): Response<LikeResponse>
    suspend fun like(product: LikeRequest): Response<LikeResponseItem>
    suspend fun deleteLike(likeId: String): Response<LikeResponseItem>
}