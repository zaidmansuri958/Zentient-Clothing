package com.example.apnamall.data.model.product

import com.example.apnamall.data.model.Size
import java.io.Serializable

data class ProductItem (
    val Size: Size?,
    val _id: String?,
    val productDesc: String?,
    val productID: String?,
    val productImg1: String?,
    val productImg2: String?,
    val productImg3: String?,
    val productName: String?,
    val productPrice: String?,
    val productDiscount:String?
): Serializable