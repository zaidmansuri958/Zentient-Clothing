package com.example.apnamall.domain.use_case

import com.example.apnamall.data.model.order.OrderResponse
import com.example.apnamall.data.util.Resource
import com.example.apnamall.domain.repository.OrderRepository
import retrofit2.Response

class GetOrderUseCase(private val orderRepository: OrderRepository) {

    suspend fun execute():Resource<OrderResponse>{
        return orderRepository.getOrder()
    }
}