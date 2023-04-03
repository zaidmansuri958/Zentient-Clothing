package com.example.apnamall.data.repository.datasource_impl

import com.example.apnamall.data.api.UserApiService
import com.example.apnamall.data.model.cart.CartRequest
import com.example.apnamall.data.model.cart.CartResponse
import com.example.apnamall.data.model.cart.CartResponseItem
import com.example.apnamall.data.model.user.User
import com.example.apnamall.data.repository.datasource.CartRemoteDataSource
import retrofit2.Response

class CartRemoteDataSourceImpl(private val userApiService: UserApiService) :
    CartRemoteDataSource {
    override suspend fun getCart(): Response<CartResponse> {
        return userApiService.getCart()
    }

    override suspend fun addToCart(product: CartRequest): Response<CartResponseItem> {
        return userApiService.addToCart(product)
    }

    override suspend fun deleteCartItem(orderId: String): Response<CartResponseItem> {
        return userApiService.deleteCartItem(orderId)
    }

    override suspend fun getUser(): Response<User> {
        return userApiService.getUser()
    }
}