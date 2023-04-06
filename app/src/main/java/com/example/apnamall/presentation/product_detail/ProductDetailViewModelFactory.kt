package com.example.apnamall.presentation.product_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.apnamall.domain.use_case.SubmitLikeUseCase
import com.example.apnamall.domain.use_case.AddToCartUseCase
import com.example.apnamall.domain.use_case.LikedOrNotUseCase

class ProductDetailViewModelFactory(
    private val submitOrderUseCase: AddToCartUseCase,
    private val submitLikeUseCase: SubmitLikeUseCase,
    private val likedOrNotUseCase: LikedOrNotUseCase,
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProductDetailViewModel(submitOrderUseCase,submitLikeUseCase,likedOrNotUseCase) as T
    }
}