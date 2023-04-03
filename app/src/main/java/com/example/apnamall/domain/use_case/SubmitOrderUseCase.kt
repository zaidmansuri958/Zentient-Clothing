package com.example.apnamall.domain.use_case

import com.example.apnamall.data.model.cart.CartRequest
import com.example.apnamall.data.model.cart.CartResponseItem
import com.example.apnamall.data.model.order.OrderRequest
import com.example.apnamall.data.model.order.OrderResponseItem
import com.example.apnamall.data.util.Resource
import com.example.apnamall.domain.repository.OrderRepository

class SubmitOrderUseCase(private val orderRepository: OrderRepository) {
    suspend fun execute(product: OrderRequest): Resource<OrderResponseItem> {
        return orderRepository.submitOrder(product)
    }

}