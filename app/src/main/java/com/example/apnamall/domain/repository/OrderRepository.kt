package com.example.apnamall.domain.repository

import com.example.apnamall.data.model.cart.CartRequest
import com.example.apnamall.data.model.cart.CartResponse
import com.example.apnamall.data.model.cart.CartResponseItem
import com.example.apnamall.data.model.order.OrderRequest
import com.example.apnamall.data.model.order.OrderResponse
import com.example.apnamall.data.model.order.OrderResponseItem
import com.example.apnamall.data.model.user.User
import com.example.apnamall.data.util.Resource


interface OrderRepository {

    suspend fun getOrder(): Resource<OrderResponse>
    suspend fun submitOrder(order: OrderRequest): Resource<OrderResponseItem>
    suspend fun deleteOrder(orderId:String): Resource<OrderResponseItem>

}