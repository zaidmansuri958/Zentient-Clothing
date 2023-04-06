package com.example.apnamall.presentation.orders

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.apnamall.domain.use_case.DeleteOrderUseCase
import com.example.apnamall.domain.use_case.GetOrderUseCase

class OrderViewModelFactory(
    private val getOrderUseCase: GetOrderUseCase,
    private val deleteOrderUseCase: DeleteOrderUseCase
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return OrderViewModel(getOrderUseCase,deleteOrderUseCase) as T
    }
}