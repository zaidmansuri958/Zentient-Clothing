package com.example.apnamall.domain.use_case

import com.example.apnamall.domain.repository.LikeRepository

class RemoveLikeUseCase(private val likeRepository: LikeRepository) {
    suspend fun execute(productId: String) {
        likeRepository.removeLike(productId)
    }
}