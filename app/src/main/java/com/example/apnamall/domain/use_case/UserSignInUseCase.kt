package com.example.apnamall.domain.use_case

import com.example.apnamall.data.model.user.LoginRequest
import com.example.apnamall.data.model.user.UserResponse
import com.example.apnamall.data.util.Resource
import com.example.apnamall.domain.repository.UserRepository

class UserSignInUseCase(private val userRepository: UserRepository) {

    suspend fun execute(data:LoginRequest):Resource<UserResponse>{
        return userRepository.signIn(data)
    }
}