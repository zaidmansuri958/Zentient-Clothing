package com.example.apnamall.domain.use_case

import com.example.apnamall.data.model.user.User
import com.example.apnamall.data.util.Resource
import com.example.apnamall.domain.repository.CartRepository
import com.example.apnamall.domain.repository.UserRepository

class GetUserDetailUseCase(private val cartRepository: CartRepository) {

    suspend fun execute():Resource<User>{
        return cartRepository.getUser()
    }
}