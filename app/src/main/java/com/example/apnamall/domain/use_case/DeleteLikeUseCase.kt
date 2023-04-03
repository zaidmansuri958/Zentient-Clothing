package com.example.apnamall.domain.use_case

import com.example.apnamall.data.model.like.LikeResponseItem
import com.example.apnamall.data.util.Resource
import com.example.apnamall.domain.repository.LikeRepository

class DeleteLikeUseCase(private val likeRepository: LikeRepository) {

    suspend fun execute(likeId:String):Resource<LikeResponseItem>{
        return likeRepository.deleteLike(likeId)
    }
}