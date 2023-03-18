package com.example.apnamall.data.repository.datasource

import com.example.apnamall.data.model.category.Category
import retrofit2.Response

interface CategoryRemoteDataSource {
    suspend fun getCategories():Response<Category>
}