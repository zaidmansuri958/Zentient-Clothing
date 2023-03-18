package com.example.apnamall.presentation.cart_item

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.apnamall.domain.use_case.DeleteOrderUseCase

class CartItemViewModelFactory(private val deleteOrderUseCase: DeleteOrderUseCase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CartItemViewModel(deleteOrderUseCase) as T
    }
}