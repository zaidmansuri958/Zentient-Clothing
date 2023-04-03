package com.example.apnamall.domain.use_case

import com.example.apnamall.data.model.cart.CartResponseItem
import com.example.apnamall.data.util.Resource
import com.example.apnamall.domain.repository.CartRepository

class DeleteCartItemUseCase(private val cartRepository: CartRepository) {

    suspend fun execute(orderId: String): Resource<CartResponseItem> {
        return cartRepository.deleteCartItem(orderId)
    }
}