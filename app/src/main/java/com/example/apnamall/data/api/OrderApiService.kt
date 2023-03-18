package com.example.apnamall.data.api

import com.example.apnamall.data.model.order.OrderRequest
import com.example.apnamall.data.model.order.OrderResponse
import com.example.apnamall.data.model.order.OrderResponseItem
import com.example.apnamall.data.model.product.Product
import com.example.apnamall.data.model.product.ProductItem
import com.example.apnamall.data.model.user.User
import retrofit2.Response
import retrofit2.http.*

interface OrderApiService {

    @GET("/userOrder")
    suspend fun getOrder(): Response<OrderResponse>

    @POST("/userOrder")
    suspend fun order(@Body product: OrderRequest): Response<OrderResponseItem>

    @DELETE("/userOrder/{orderId}")
    suspend fun deleteOrder(@Path("orderId") orderId:String): Response<OrderResponseItem>

    @GET("/user")
    suspend fun getUser():Response<User>
}