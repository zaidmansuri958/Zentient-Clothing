package com.example.apnamall.domain.repository

import com.example.apnamall.data.model.cart.CartRequest
import com.example.apnamall.data.model.cart.CartResponse
import com.example.apnamall.data.model.cart.CartResponseItem
import com.example.apnamall.data.model.user.User
import com.example.apnamall.data.util.Resource


interface CartRepository {

    suspend fun getCart(): Resource<CartResponse>
    suspend fun addToCart(order:CartRequest): Resource<CartResponseItem>
    suspend fun deleteCartItem(orderId:String): Resource<CartResponseItem>
    suspend fun getUser():Resource<User>

}