package com.example.apnamall.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.apnamall.data.model.product.Product
import com.example.apnamall.data.model.user.LoginRequest
import com.example.apnamall.data.model.user.User
import com.example.apnamall.data.model.user.UserRequest
import com.example.apnamall.data.model.user.UserResponse
import com.example.apnamall.data.repository.datasource.UserRemoteDataSource
import com.example.apnamall.data.util.Resource
import com.example.apnamall.domain.repository.UserRepository
import org.json.JSONObject
import retrofit2.Response

class UserRepositoryImpl(private val userRemoteDataSource: UserRemoteDataSource) : UserRepository {

    override suspend fun signUp(
        data: UserRequest
    ): Resource<UserResponse> {
        return responseToResource(userRemoteDataSource.signUp(data))
    }

    override suspend fun signIn(data: LoginRequest): Resource<UserResponse> {
        return responseToResource(userRemoteDataSource.signIn(data))
    }

    private fun responseToResource(response: Response<UserResponse>): Resource<UserResponse> {
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