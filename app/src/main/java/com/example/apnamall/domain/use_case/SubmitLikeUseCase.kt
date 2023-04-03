package com.example.apnamall.domain.use_case

import com.example.apnamall.data.model.like.LikeRequest
import com.example.apnamall.data.model.like.LikeResponseItem
import com.example.apnamall.data.util.Resource
import com.example.apnamall.domain.repository.LikeRepository

class SubmitLikeUseCase(private val likeRepository: LikeRepository) {

    suspend fun execute(product: LikeRequest): Resource<LikeResponseItem> {
        return likeRepository.like(product)
    }
}