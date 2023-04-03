package com.example.apnamall.presentation.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.apnamall.domain.use_case.GetCartUseCase

class CartViewModelFactory(private val getCartUseCase: GetCartUseCase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CartViewModel(getCartUseCase) as T
    }
}