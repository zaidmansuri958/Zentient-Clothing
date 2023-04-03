package com.example.apnamall.presentation.cart_item

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.apnamall.domain.use_case.DeleteCartItemUseCase

class CartItemViewModelFactory(private val deleteOrderUseCase: DeleteCartItemUseCase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CartItemViewModel(deleteOrderUseCase) as T
    }
}