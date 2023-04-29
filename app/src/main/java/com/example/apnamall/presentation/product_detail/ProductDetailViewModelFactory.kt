package com.example.apnamall.presentation.product_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.apnamall.domain.use_case.SubmitLikeUseCase
import com.example.apnamall.domain.use_case.AddToCartUseCase
import com.example.apnamall.domain.use_case.LikedOrNotUseCase
import com.example.apnamall.domain.use_case.RemoveLikeUseCase

class ProductDetailViewModelFactory(
    private val submitOrderUseCase: AddToCartUseCase,
    private val submitLikeUseCase: SubmitLikeUseCase,
    private val likedOrNotUseCase: LikedOrNotUseCase,
    private val removeLikeUseCase: RemoveLikeUseCase
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProductDetailViewModel(
            submitOrderUseCase,
            submitLikeUseCase,
            likedOrNotUseCase,
            removeLikeUseCase
        ) as T
    }
}