package com.example.apnamall.data.model.like

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.apnamall.data.model.Size

@Entity(tableName = "likesTable")
data class LikeRequest(
    @PrimaryKey
    val _id: String,
    val productDesc: String?,
    val productID: String?,
    val productImg1: String?,
    val productImg2: String?,
    val productImg3: String?,
    val productName: String?,
    val productPrice: String?,
    val quantity: String?,
    val size: String?
):java.io.Serializable