package com.example.apnamall.domain.use_case

import com.example.apnamall.data.model.cart.CartRequest
import com.example.apnamall.data.model.cart.CartResponseItem
import com.example.apnamall.data.util.Resource
import com.example.apnamall.domain.repository.CartRepository

class AddToCartUseCase(private val cartRepository: CartRepository) {

    suspend fun execute(product: CartRequest):Resource<CartResponseItem>{
        return cartRepository.addToCart(product)
    }
}