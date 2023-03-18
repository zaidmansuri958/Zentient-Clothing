package com.example.apnamall.data.model.category

import java.io.Serializable

data class CategoryItem(
    val _id: String,
    val categoryID: String,
    val categoryImage: String,
    val categoryName: String
): Serializable