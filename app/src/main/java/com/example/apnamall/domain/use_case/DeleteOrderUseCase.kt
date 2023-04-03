package com.example.apnamall.domain.use_case

import com.example.apnamall.data.model.order.OrderResponseItem
import com.example.apnamall.data.util.Resource
import com.example.apnamall.domain.repository.OrderRepository


class DeleteOrderUseCase(private val orderRepository: OrderRepository) {
    suspend fun execute(orderId: String): Resource<OrderResponseItem> {
        return orderRepository.deleteOrder(orderId)
    }
}