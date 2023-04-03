package com.example.apnamall.data.repository

import com.example.apnamall.data.model.cart.CartRequest
import com.example.apnamall.data.model.cart.CartResponse
import com.example.apnamall.data.model.cart.CartResponseItem
import com.example.apnamall.data.model.user.User
import com.example.apnamall.data.repository.datasource.CartRemoteDataSource
import com.example.apnamall.data.util.Resource
import com.example.apnamall.domain.repository.CartRepository
import org.json.JSONObject
import retrofit2.Response

class CartRepositoryImpl(private val cartRemoteDataSource: CartRemoteDataSource) :
    CartRepository {
    override suspend fun getCart(): Resource<CartResponse> {
        return responseToResource(cartRemoteDataSource.getCart())
    }

    override suspend fun addToCart(cart: CartRequest): Resource<CartResponseItem> {
        return responseToResourceCartResponseItem(cartRemoteDataSource.addToCart(cart))
    }

    override suspend fun deleteCartItem(cartId: String): Resource<CartResponseItem> {
        return responseToResourceCartResponseItem(cartRemoteDataSource.deleteCartItem(cartId))
    }

    override suspend fun getUser(): Resource<User> {
        return responseToResourceUser(cartRemoteDataSource.getUser())
    }


    private fun responseToResourceUser(response: Response<User>): Resource<User> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        } else if (response.errorBody() != null) {
            val errorObj = JSONObject(response.errorBody()!!.charStream().readText())
            return Resource.Error(errorObj.getString("message"))
        }
        return Resource.Error("Something went wrong")
    }

    private fun responseToResourceCartResponseItem(response: Response<CartResponseItem>): Resource<CartResponseItem> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        } else if (response.errorBody() != null) {
            val errorObj = JSONObject(response.errorBody()!!.charStream().readText())
            return Resource.Error(errorObj.getString("message"))
        }
        return Resource.Error("Something went wrong")
    }

    private fun responseToResource(response: Response<CartResponse>): Resource<CartResponse> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        } else if (response.errorBody() != null) {
            val errorObj = JSONObject(response.errorBody()!!.charStream().readText())
            return Resource.Error(errorObj.getString("message"))
        }
        return Resource.Error("Something went wrong")
    }
}