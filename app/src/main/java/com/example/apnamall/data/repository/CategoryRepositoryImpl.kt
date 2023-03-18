package com.example.apnamall.data.repository

import com.example.apnamall.data.model.category.Category
import com.example.apnamall.data.repository.datasource.CategoryRemoteDataSource
import com.example.apnamall.data.util.Resource
import com.example.apnamall.domain.repository.CategoryRepository
import retrofit2.Response

class CategoryRepositoryImpl(private val categoryRemoteDataSource: CategoryRemoteDataSource) :
    CategoryRepository {
    override suspend fun getCategories(): Resource<Category> {
        return responseToResource(categoryRemoteDataSource.getCategories())
    }

    private fun responseToResource(response: Response<Category>): Resource<Category> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }
}