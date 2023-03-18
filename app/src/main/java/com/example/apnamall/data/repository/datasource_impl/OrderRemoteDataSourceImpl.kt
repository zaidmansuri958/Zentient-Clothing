package com.example.apnamall.data.repository.datasource_impl

import com.example.apnamall.data.api.OrderApiService
import com.example.apnamall.data.model.order.OrderRequest
import com.example.apnamall.data.model.order.OrderResponse
import com.example.apnamall.data.model.order.OrderResponseItem
import com.example.apnamall.data.model.product.Product
import com.example.apnamall.data.model.product.ProductItem
import com.example.apnamall.data.model.user.User
import com.example.apnamall.data.repository.datasource.OrderRemoteDataSource
import retrofit2.Response

class OrderRemoteDataSourceImpl(private val orderApiService: OrderApiService) :
    OrderRemoteDataSource {
    override suspend fun getOrder(): Response<OrderResponse> {
        return orderApiService.getOrder()
    }

    override suspend fun submitOrder(product: OrderRequest): Response<OrderResponseItem> {
        return orderApiService.order(product)
    }

    override suspend fun deleteOrder(orderId: String): Response<OrderResponseItem> {
        return orderApiService.deleteOrder(orderId)
    }

    override suspend fun getUser(): Response<User> {
        return orderApiService.getUser()
    }
}