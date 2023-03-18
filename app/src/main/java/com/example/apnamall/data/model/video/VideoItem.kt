package com.example.apnamall.data.model.video

import com.example.apnamall.data.model.Size

data class VideoItem(
    val _id: String,
    val url: String,
    val productDesc: String?,
    val productID: String?,
    val productImg1: String?,
    val productImg2: String?,
    val productImg3: String?,
    val productName: String?,
    val productPrice: String?,
    val productDiscount:String?,
    val Size: Size?,
)