package com.example.apnamall.presentation.product_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.apnamall.domain.use_case.SubmitOrderUseCase

class ProductDetailViewModelFactory(private val submitOrderUseCase: SubmitOrderUseCase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProductDetailViewModel(submitOrderUseCase) as T
    }
}