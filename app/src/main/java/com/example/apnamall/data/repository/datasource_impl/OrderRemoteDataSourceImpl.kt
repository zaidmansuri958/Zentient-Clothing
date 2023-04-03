package com.example.apnamall.data.repository.datasource_impl

import com.example.apnamall.data.api.UserApiService
import com.example.apnamall.data.model.order.OrderRequest
import com.example.apnamall.data.model.order.OrderResponse
import com.example.apnamall.data.model.order.OrderResponseItem
import com.example.apnamall.data.repository.datasource.OrderRemoteDataSource
import retrofit2.Response

class OrderRemoteDataSourceImpl(private val userApiService: UserApiService) :
    OrderRemoteDataSource {
    override suspend fun getOrder(): Response<OrderResponse> {
        return userApiService.getOrder()
    }

    override suspend fun submitOrder(product: OrderRequest): Response<OrderResponseItem> {
        return userApiService.submitOrder(product)
    }

    override suspend fun deleteOrder(orderId: String): Response<OrderResponseItem> {
        return userApiService.deleteOrder(orderId)
    }

}