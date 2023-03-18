package com.example.apnamall.domain.repository

import androidx.lifecycle.MutableLiveData
import com.example.apnamall.data.model.user.LoginRequest
import com.example.apnamall.data.model.user.User
import com.example.apnamall.data.model.user.UserRequest
import com.example.apnamall.data.model.user.UserResponse
import com.example.apnamall.data.util.Resource

interface UserRepository {
    suspend fun signUp(
       data: UserRequest
    ): Resource<UserResponse>

    suspend fun signIn(data:LoginRequest):Resource<UserResponse>



}