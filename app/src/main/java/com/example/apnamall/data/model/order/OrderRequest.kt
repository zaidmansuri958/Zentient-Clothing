package com.example.apnamall.data.model.order

data class OrderRequest(
    val productDesc: String?,
    val productID: String?,
    val productImg1: String?,
    val productImg2: String?,
    val productImg3: String?,
    val productName: String?,
    val productPrice: String?,
    val quantity:String?,
    val size: String?
)
