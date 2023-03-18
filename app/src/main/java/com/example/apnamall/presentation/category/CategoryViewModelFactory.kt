package com.example.apnamall.presentation.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.apnamall.domain.use_case.GetCategoryUseCase

class CategoryViewModelFactory(private val getCategoryUseCase: GetCategoryUseCase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CategoryViewModel(getCategoryUseCase) as T
    }
}