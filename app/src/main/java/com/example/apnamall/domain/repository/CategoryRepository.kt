package com.example.apnamall.domain.repository

import com.example.apnamall.data.model.category.Category
import com.example.apnamall.data.util.Resource

interface CategoryRepository {
    suspend fun getCategories():Resource<Category>
}