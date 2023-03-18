package com.example.apnamall.data.model.user

data class UserRequest(
    val name: String,
    val email: String,
    val mobile_no: String,
    val address: String,
    val password: String,
    val pincode: String
)