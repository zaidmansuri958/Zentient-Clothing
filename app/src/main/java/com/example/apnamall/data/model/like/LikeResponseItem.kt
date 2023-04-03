package com.example.apnamall.data.model.like

import com.example.apnamall.data.model.Size

data class LikeResponseItem(
    val __v: Int,
    val _id: String,
    val productDesc: String,
    val productID: String,
    val productImg1: String,
    val productImg2: String,
    val productImg3: String,
    val productName: String,
    val productPrice: String,
    val size: Size,
    val quantity:String,
    val userID: String
)
