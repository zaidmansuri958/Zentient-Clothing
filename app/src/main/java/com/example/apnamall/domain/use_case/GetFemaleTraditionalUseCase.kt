package com.example.apnamall.domain.use_case


import com.example.apnamall.data.model.product.Product
import com.example.apnamall.data.util.Resource
import com.example.apnamall.domain.repository.ProductRepository

class GetFemaleTraditionalUseCase(private val productRepository: ProductRepository) {

    suspend fun execute(): Resource<Product> {
       return productRepository.getFemaleTraditional()
    }
}