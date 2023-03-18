package com.example.apnamall.domain.use_case

import com.example.apnamall.data.model.slider.Slider
import com.example.apnamall.data.util.Resource
import com.example.apnamall.domain.repository.ProductRepository


class GetSliderUseCase(private val productRepository: ProductRepository) {

    suspend fun execute(): Resource<Slider> {
        return productRepository.getSliders()
    }
}