package com.example.apnamall.domain.use_case

import com.example.apnamall.data.model.cart.CartResponse
import com.example.apnamall.data.util.Resource
import com.example.apnamall.domain.repository.CartRepository

class GetCartUseCase(private val cartRepository: CartRepository) {

    suspend fun execute(): Resource<CartResponse> {
        return cartRepository.getCart()
    }
}