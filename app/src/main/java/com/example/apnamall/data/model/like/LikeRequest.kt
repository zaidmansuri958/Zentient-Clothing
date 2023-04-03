package com.example.apnamall.data.model.like

import com.example.apnamall.data.model.Size

data class LikeRequest(
    val productDesc: String?,
    val productID: String?,
    val productImg1: String?,
    val productImg2: String?,
    val productImg3: String?,
    val productName: String?,
    val productPrice: String?,
    val quantity:String?,
    val size: Size?
) : java.io.Serializable