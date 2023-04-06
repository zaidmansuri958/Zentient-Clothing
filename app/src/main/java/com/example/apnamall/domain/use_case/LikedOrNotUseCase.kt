package com.example.apnamall.domain.use_case

import com.example.apnamall.domain.repository.LikeRepository

class LikedOrNotUseCase(private val likeRepository: LikeRepository) {
    suspend fun execute(productId: String): Boolean {
        return likeRepository.likedOrNot(productId)
    }
}