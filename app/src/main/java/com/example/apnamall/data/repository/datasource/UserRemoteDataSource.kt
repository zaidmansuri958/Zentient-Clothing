package com.example.apnamall.data.repository.datasource


import androidx.lifecycle.MutableLiveData
import com.example.apnamall.data.model.user.LoginRequest
import com.example.apnamall.data.model.user.User
import com.example.apnamall.data.model.user.UserRequest
import com.example.apnamall.data.model.user.UserResponse
import com.example.apnamall.data.util.Resource
import retrofit2.Response

interface UserRemoteDataSource {
    suspend fun signUp(
      data:UserRequest
    ): Response<UserResponse>

    suspend fun signIn(data:LoginRequest):Response<UserResponse>


}