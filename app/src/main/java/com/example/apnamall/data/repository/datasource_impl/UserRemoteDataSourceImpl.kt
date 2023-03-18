package com.example.apnamall.data.repository.datasource_impl

import androidx.lifecycle.MutableLiveData
import com.example.apnamall.data.api.ApiService
import com.example.apnamall.data.model.user.LoginRequest
import com.example.apnamall.data.model.user.User
import com.example.apnamall.data.model.user.UserRequest
import com.example.apnamall.data.model.user.UserResponse
import com.example.apnamall.data.repository.datasource.UserRemoteDataSource
import com.example.apnamall.data.util.Resource
import retrofit2.Response

class UserRemoteDataSourceImpl(private val apiService: ApiService) : UserRemoteDataSource {
    override suspend fun signUp(
       data:UserRequest
    ): Response<UserResponse> {
        return apiService.singUp(data)
    }

    override suspend fun signIn(data: LoginRequest): Response<UserResponse> {
        return apiService.singIn(data)
    }
}