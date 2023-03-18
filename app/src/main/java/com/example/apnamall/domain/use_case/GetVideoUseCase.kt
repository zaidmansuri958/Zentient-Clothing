package com.example.apnamall.domain.use_case

import com.example.apnamall.data.model.video.Video
import com.example.apnamall.data.util.Resource
import com.example.apnamall.domain.repository.ProductRepository

class GetVideoUseCase(private val productRepository: ProductRepository) {
    suspend fun execute():Resource<Video>{
        return productRepository.getVideo()
    }
}