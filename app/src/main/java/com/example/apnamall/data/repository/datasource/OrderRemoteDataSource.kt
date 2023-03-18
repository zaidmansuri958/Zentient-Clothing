package com.example.apnamall.data.repository.datasource

import com.example.apnamall.data.model.order.OrderRequest
import com.example.apnamall.data.model.order.OrderResponse
import com.example.apnamall.data.model.order.OrderResponseItem
import com.example.apnamall.data.model.product.Product
import com.example.apnamall.data.model.product.ProductItem
import com.example.apnamall.data.model.user.User
import retrofit2.Response

interface OrderRemoteDataSource {

    suspend fun getOrder(): Response<OrderResponse>
    suspend fun submitOrder(product: OrderRequest): Response<OrderResponseItem>
    suspend fun deleteOrder(orderId: String): Response<OrderResponseItem>
    suspend fun getUser():Response<User>
}