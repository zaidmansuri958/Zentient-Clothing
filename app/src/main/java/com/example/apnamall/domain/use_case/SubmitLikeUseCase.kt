package com.example.apnamall.domain.use_case

import com.example.apnamall.data.model.like.LikeRequest
import com.example.apnamall.data.model.like.LikeResponseItem
import com.example.apnamall.data.util.Resource
import com.example.apnamall.domain.repository.LikeRepository
import kotlinx.coroutines.flow.Flow

class SubmitLikeUseCase(private val likeRepository: LikeRepository) {

    suspend fun execute(product: LikeRequest) = likeRepository.like(product)

}