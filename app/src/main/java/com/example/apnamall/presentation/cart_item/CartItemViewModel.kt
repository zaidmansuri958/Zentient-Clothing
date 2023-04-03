package com.example.apnamall.presentation.cart_item

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apnamall.data.model.cart.CartResponseItem
import com.example.apnamall.data.util.Resource
import com.example.apnamall.domain.use_case.DeleteCartItemUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CartItemViewModel(private val deleteOrderUseCase: DeleteCartItemUseCase) : ViewModel() {
    val deleteOrder: MutableLiveData<Resource<CartResponseItem>> = MutableLiveData()

    fun deleteOrder(orderId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val apiResult=deleteOrderUseCase.execute(orderId)
            deleteOrder.postValue(apiResult)
        }
    }
}