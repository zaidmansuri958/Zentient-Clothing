package com.example.apnamall.domain.use_case

import com.example.apnamall.data.model.user.User
import com.example.apnamall.data.util.Resource
import com.example.apnamall.domain.repository.OrderRepository
import com.example.apnamall.domain.repository.UserRepository

class GetUserDetailUseCase(private val orderRepository: OrderRepository) {

    suspend fun execute():Resource<User>{
        return orderRepository.getUser()
    }
}