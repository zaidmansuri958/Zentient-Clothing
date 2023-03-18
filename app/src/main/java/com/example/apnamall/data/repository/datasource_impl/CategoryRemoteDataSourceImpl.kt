package com.example.apnamall.data.repository.datasource_impl

import com.example.apnamall.data.api.ApiService
import com.example.apnamall.data.model.category.Category
import com.example.apnamall.data.repository.datasource.CategoryRemoteDataSource
import retrofit2.Response

class CategoryRemoteDataSourceImpl(private val apiService: ApiService) : CategoryRemoteDataSource {
    override suspend fun getCategories(): Response<Category> {
        return apiService.getCategories()
    }
}