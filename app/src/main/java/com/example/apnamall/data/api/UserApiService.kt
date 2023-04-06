package com.example.apnamall.data.api

import com.example.apnamall.data.model.like.LikeRequest
import com.example.apnamall.data.model.like.LikeResponse
import com.example.apnamall.data.model.like.LikeResponseItem
import com.example.apnamall.data.model.cart.CartRequest
import com.example.apnamall.data.model.cart.CartResponse
import com.example.apnamall.data.model.cart.CartResponseItem
import com.example.apnamall.data.model.order.OrderRequest
import com.example.apnamall.data.model.order.OrderResponse
import com.example.apnamall.data.model.order.OrderResponseItem
import com.example.apnamall.data.model.user.User
import retrofit2.Response
import retrofit2.http.*

interface UserApiService {

    @GET("/userCart")
    suspend fun getCart(): Response<CartResponse>

    @POST("/userCart")
    suspend fun addToCart(@Body product: CartRequest): Response<CartResponseItem>

    @DELETE("/userCart/{cartId}")
    suspend fun deleteCartItem(@Path("cartId") orderId:String): Response<CartResponseItem>


    @GET("/userOrder")
    suspend fun getOrder(): Response<OrderResponse>

    @POST("/userOrder")
    suspend fun submitOrder(@Body product: OrderRequest): Response<OrderResponseItem>

    @DELETE("/userOrder/{orderId}")
    suspend fun deleteOrder(@Path("orderId") orderId:String): Response<OrderResponseItem>

    @GET("/user")
    suspend fun getUser():Response<User>

}