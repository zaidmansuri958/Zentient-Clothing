package com.example.apnamall.domain.use_case

import com.example.apnamall.data.model.like.LikeResponse
import com.example.apnamall.data.util.Resource
import com.example.apnamall.domain.repository.LikeRepository

class GetLikeUseCase(private val likeRepository: LikeRepository) {
    suspend fun execute(): Resource<LikeResponse> {
        return likeRepository.getLike()
    }
}