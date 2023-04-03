package com.example.apnamall.data.repository

import com.example.apnamall.data.model.cart.CartRequest
import com.example.apnamall.data.model.cart.CartResponse
import com.example.apnamall.data.model.cart.CartResponseItem
import com.example.apnamall.data.model.order.OrderRequest
import com.example.apnamall.data.model.order.OrderResponse
import com.example.apnamall.data.model.order.OrderResponseItem
import com.example.apnamall.data.model.user.User
import com.example.apnamall.data.repository.datasource.CartRemoteDataSource
import com.example.apnamall.data.repository.datasource.OrderRemoteDataSource
import com.example.apnamall.data.util.Resource
import com.example.apnamall.domain.repository.CartRepository
import com.example.apnamall.domain.repository.OrderRepository
import org.json.JSONObject
import retrofit2.Response

class OrderRepositoryImpl(private val orderRemoteDataSource: OrderRemoteDataSource) :
    OrderRepository {

    override suspend fun getOrder(): Resource<OrderResponse> {
        return responseToResource(orderRemoteDataSource.getOrder())
    }

    override suspend fun submitOrder(order: OrderRequest): Resource<OrderResponseItem> {
        return responseToResourceOrderResponseItem(orderRemoteDataSource.submitOrder(order))
    }

    override suspend fun deleteOrder(orderId: String): Resource<OrderResponseItem> {
        return responseToResourceOrderResponseItem(orderRemoteDataSource.deleteOrder(orderId))
    }

    private fun responseToResourceOrderResponseItem(response: Response<OrderResponseItem>): Resource<OrderResponseItem> {
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

    private fun responseToResource(response: Response<OrderResponse>): Resource<OrderResponse> {
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