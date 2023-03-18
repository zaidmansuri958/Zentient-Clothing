package com.example.apnamall.domain.use_case

import com.example.apnamall.data.model.category.Category
import com.example.apnamall.data.util.Resource
import com.example.apnamall.domain.repository.CategoryRepository

class GetCategoryUseCase(private val categoryRepository: CategoryRepository) {
    suspend fun execute(): Resource<Category> {
        return categoryRepository.getCategories()
    }
}