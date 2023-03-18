package com.example.apnamall.presentation.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.apnamall.domain.use_case.GetOrderUseCase

class CartViewModelFactory(private val getOrderUseCase: GetOrderUseCase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CartViewModel(getOrderUseCase) as T
    }
}