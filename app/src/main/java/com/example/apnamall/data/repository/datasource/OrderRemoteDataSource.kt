package com.example.apnamall.data.repository.datasource

import com.example.apnamall.data.model.cart.CartRequest
import com.example.apnamall.data.model.cart.CartResponse
import com.example.apnamall.data.model.cart.CartResponseItem
import com.example.apnamall.data.model.order.OrderRequest
import com.example.apnamall.data.model.order.OrderResponse
import com.example.apnamall.data.model.order.OrderResponseItem
import com.example.apnamall.data.model.user.User
import retrofit2.Response

interface OrderRemoteDataSource {

    suspend fun getOrder(): Response<OrderResponse>
    suspend fun submitOrder(product: OrderRequest): Response<OrderResponseItem>
    suspend fun deleteOrder(orderId: String): Response<OrderResponseItem>
}