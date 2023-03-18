package com.example.apnamall.presentation.cart

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apnamall.data.model.order.OrderResponse
import com.example.apnamall.data.util.Resource
import com.example.apnamall.domain.use_case.GetOrderUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CartViewModel(private val getOrderUseCase: GetOrderUseCase) : ViewModel() {
    val cartItem: MutableLiveData<Resource<OrderResponse>> = MutableLiveData()
    var price:Int=0

    fun getCartItem() = viewModelScope.launch(Dispatchers.IO) {
        val apiResult = getOrderUseCase.execute()
        cartItem.postValue(apiResult)
    }
}