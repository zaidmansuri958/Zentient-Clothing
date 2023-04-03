package com.example.apnamall.domain.repository

import com.example.apnamall.data.model.like.LikeRequest
import com.example.apnamall.data.model.like.LikeResponse
import com.example.apnamall.data.model.like.LikeResponseItem
import com.example.apnamall.data.util.Resource

interface LikeRepository {
    suspend fun getLike(): Resource<LikeResponse>
    suspend fun like(product: LikeRequest): Resource<LikeResponseItem>
    suspend fun deleteLike(likeId: String): Resource<LikeResponseItem>
}