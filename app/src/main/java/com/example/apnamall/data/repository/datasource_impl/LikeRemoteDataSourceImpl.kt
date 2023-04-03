package com.example.apnamall.data.repository.datasource_impl

import com.example.apnamall.data.api.UserApiService
import com.example.apnamall.data.model.like.LikeRequest
import com.example.apnamall.data.model.like.LikeResponse
import com.example.apnamall.data.model.like.LikeResponseItem
import com.example.apnamall.data.repository.datasource.LikeRemoteDataSource
import retrofit2.Response

class LikeRemoteDataSourceImpl(private val userApiService: UserApiService):LikeRemoteDataSource {
    override suspend fun getLike(): Response<LikeResponse> {
        return userApiService.getLike()
    }

    override suspend fun like(product: LikeRequest): Response<LikeResponseItem> {
       return userApiService.like(product)
    }

    override suspend fun deleteLike(likeId: String): Response<LikeResponseItem> {
       return userApiService.deleteLikeItem(likeId)
    }

}