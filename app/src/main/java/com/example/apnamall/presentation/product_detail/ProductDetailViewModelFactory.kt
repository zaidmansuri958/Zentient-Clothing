package com.example.apnamall.presentation.product_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.apnamall.domain.use_case.SubmitLikeUseCase
import com.example.apnamall.domain.use_case.AddToCartUseCase

class ProductDetailViewModelFactory(
    private val submitOrderUseCase: AddToCartUseCase,
    private val submitLikeUseCase: SubmitLikeUseCase
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProductDetailViewModel(submitOrderUseCase,submitLikeUseCase) as T
    }
}