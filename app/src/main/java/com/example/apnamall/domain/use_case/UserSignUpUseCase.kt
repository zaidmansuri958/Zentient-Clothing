package com.example.apnamall.domain.use_case


import androidx.lifecycle.MutableLiveData
import com.example.apnamall.data.model.user.UserRequest
import com.example.apnamall.data.model.user.UserResponse
import com.example.apnamall.data.util.Resource
import com.example.apnamall.domain.repository.UserRepository

class UserSignUpUseCase(private val userRepository: UserRepository) {

    suspend fun execute(
       data:UserRequest
    ): Resource<UserResponse> {
        return userRepository.signUp(data)
    }

}