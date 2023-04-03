package com.example.apnamall.data.repository.datasource

import com.example.apnamall.data.model.cart.CartRequest
import com.example.apnamall.data.model.cart.CartResponse
import com.example.apnamall.data.model.cart.CartResponseItem
import com.example.apnamall.data.model.user.User
import retrofit2.Response

interface CartRemoteDataSource {

    suspend fun getCart(): Response<CartResponse>
    suspend fun addToCart(product: CartRequest): Response<CartResponseItem>
    suspend fun deleteCartItem(orderId: String): Response<CartResponseItem>
    suspend fun getUser():Response<User>
}