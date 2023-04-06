package com.example.apnamall.domain.use_case

import com.example.apnamall.data.model.like.LikeRequest
import com.example.apnamall.data.model.like.LikeResponse
import com.example.apnamall.data.util.Resource
import com.example.apnamall.domain.repository.LikeRepository
import kotlinx.coroutines.flow.Flow

class GetLikeUseCase(private val likeRepository: LikeRepository) {
        fun execute(): Flow<List<LikeRequest>> {
        return likeRepository.getLike()
    }
}